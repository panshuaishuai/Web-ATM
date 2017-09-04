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
 * Servlet implementation class DeposiServlet
 */
@WebServlet("/DeposiServlet")
public class DeposiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AccountServiceImpl service = new AccountServiceImpl();
	private VIPAccountServiceImpl service1 = new VIPAccountServiceImpl();

	public DeposiServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String depositAmount = request.getParameter("depositAmount");

		// 获取数组普通用户下标
		int accountIndex = (int) request.getSession().getAttribute("accountIndex");

		double depositBalance = service.deposit(accountIndex, Double.valueOf(depositAmount));
		if (depositBalance != -2) {
			if (depositBalance != -1) {
				request.setAttribute("balance", depositBalance);
				request.getRequestDispatcher("/query.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "请输入有效金额！");
				request.getRequestDispatcher("/deposit.jsp").forward(request, response);
			}
		} else {

			// 获取数组VIP用户下标
			int accountIndex1 = (int) request.getSession().getAttribute("accountIndex");
			double depositBalance1 = service1.deposit(accountIndex1, Double.valueOf(depositAmount));
			if (depositBalance1 != -2) {
				if (depositBalance1 != -1) {
					request.setAttribute("balance", depositBalance1);
					request.getRequestDispatcher("/vipQuery.jsp").forward(request, response);
				} else {
					request.setAttribute("message", "请输入有效金额！");
					request.getRequestDispatcher("/vipDeposit.jsp").forward(request, response);
				}
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
