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
 * Servlet implementation class QueryServlet
 */
@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AccountServiceImpl service = new AccountServiceImpl();
	private VIPAccountServiceImpl service1 = new VIPAccountServiceImpl();

	public QueryServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取数组普通用户下标
		int accountIndex = (int) request.getSession().getAttribute("accountIndex");
		double balance = service.queryBalance(accountIndex);
		if (balance != -1) {
			request.setAttribute("balance", balance);
			request.getRequestDispatcher("/query.jsp").forward(request, response);
		} else {

			// 获取数组VIP下标
			int accountIndex1 = (int) request.getSession().getAttribute("accountIndex");
			double balance1 = service1.queryBalance(accountIndex1);
			if (balance1 != -1) {
				request.setAttribute("balance", balance1);
				request.getRequestDispatcher("/vipQuery.jsp").forward(request, response);
			}
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
