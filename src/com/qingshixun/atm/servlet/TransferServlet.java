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
 * Servlet implementation class TransferServlet
 */
@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AccountServiceImpl service = new AccountServiceImpl();
	private VIPAccountServiceImpl service1 = new VIPAccountServiceImpl();

	public TransferServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String targetAccountName = request.getParameter("targetAccountName");
		String transferAmount = request.getParameter("transferAmount");

		// 获取数组普通用户下标
		int accountIndex = (int) request.getSession().getAttribute("accountIndex");
		double balance = service.transfer(accountIndex, Double.valueOf(transferAmount), targetAccountName);
		if (balance != -5) {
			if (balance != -3) {
				if (balance != -1) {
					if (balance != -2) {
						if (balance != -4) {
							request.setAttribute("balance", balance);
							request.getRequestDispatcher("/query.jsp").forward(request, response);
						} else {
							request.setAttribute("message", "请输入有效金额！");
							request.getRequestDispatcher("/transfer.jsp").forward(request, response);
						}
					} else {
						request.setAttribute("message", "转账金额不能超过账户余额！");
						request.getRequestDispatcher("/transfer.jsp").forward(request, response);
					}
				} else {
					request.setAttribute("message", "您不能转账给自己！");
					request.getRequestDispatcher("/transfer.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("message", "此账户不存在！");
				request.getRequestDispatcher("/transfer.jsp").forward(request, response);
			}
		} else {

			// 获取数组VIP用户下标
			int accountIndex1 = (int) request.getSession().getAttribute("accountIndex");
			double balance1 = service1.transfer(accountIndex1, Double.valueOf(transferAmount), targetAccountName);
			if (balance1 != -5) {
				if (balance1 == -1) {
					request.setAttribute("message", "您不能转账给自己！");
					request.getRequestDispatcher("/vipTransfer.jsp").forward(request, response);
				} else if (balance1 == -2) {
					request.setAttribute("message", "转账金额不能超过账户余额！");
					request.getRequestDispatcher("/vipTransfer.jsp").forward(request, response);
				} else if (balance1 == -3) {
					request.setAttribute("message", "此账户不存在！");
					request.getRequestDispatcher("/vipTransfer.jsp").forward(request, response);
				} else if (balance1 == -4) {
					request.setAttribute("message", "请输入有效金额！");
					request.getRequestDispatcher("/vipTransfer.jsp").forward(request, response);
				} else {
					request.setAttribute("balance", balance1);
					request.getRequestDispatcher("/vipQuery.jsp").forward(request, response);
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
