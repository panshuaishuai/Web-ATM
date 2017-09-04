package com.qingshixun.atm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qingshixun.atm.service.AccountServiceImpl;
import com.qingshixun.atm.service.VIPAccountServiceImpl;

/**
 * Servlet implementation class WithdrawServlet
 */
@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AccountServiceImpl service = new AccountServiceImpl();
	private VIPAccountServiceImpl service1 = new VIPAccountServiceImpl();

	public WithdrawServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String withdrawAmount = request.getParameter("withdrawAmount");

		// 获取数组普通用户下标
		int accountIndex = (int) request.getSession().getAttribute("accountIndex");
		double balance = service.queryBalance(accountIndex);
		double withdrawBalance = service.withdraw(accountIndex, Double.valueOf(withdrawAmount));
		if (withdrawBalance != -2) {
			if (withdrawBalance != -1) {
				if (Double.valueOf(withdrawAmount) > balance) {
					request.setAttribute("message", "取款金额不能超过账户余额！");
					request.getRequestDispatcher("/withdraw.jsp").forward(request, response);
				} else {
					request.setAttribute("balance", withdrawBalance);
					request.getRequestDispatcher("/query.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("message", "请输入有效金额！");
				request.getRequestDispatcher("/withdraw.jsp").forward(request, response);
			}
		} else {
			// 获取数组VIP用户下标
			int accountIndex1 = (int) request.getSession().getAttribute("accountIndex");
			double balance1 = service1.queryBalance(accountIndex1);
			double withdrawBalance1 = service1.withdraw(accountIndex1, Double.valueOf(withdrawAmount));
			if (withdrawBalance1 != -2) {
				if (withdrawBalance1 != -1) {
					if (Double.valueOf(withdrawAmount) > balance1) {
						request.setAttribute("message", "取款金额不能超过账户余额！");
						request.getRequestDispatcher("/vipWithdraw.jsp").forward(request, response);
					} else {
						request.setAttribute("balance", withdrawBalance1);
						request.getRequestDispatcher("/vipQuery.jsp").forward(request, response);
					}
				} else {
					request.setAttribute("message", "请输入有效金额！");
					request.getRequestDispatcher("/vipWithdraw.jsp").forward(request, response);
				}

			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
