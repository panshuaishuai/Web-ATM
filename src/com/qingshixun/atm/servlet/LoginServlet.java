package com.qingshixun.atm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.qingshixun.atm.service.AccountServiceImpl;
import com.qingshixun.atm.service.VIPAccountServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/LoginServlet", loadOnStartup = 2)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AccountServiceImpl service = new AccountServiceImpl();
	private VIPAccountServiceImpl service1 = new VIPAccountServiceImpl();

	public LoginServlet() {
		super();
		service.initAccounts();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 字符转换
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charset = utf-8");

		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 普通用户
		int accountIndex = service.login(username, password);

		// 判断用户登录是否成功
		if (accountIndex != -1) {
			session.setAttribute("accountIndex", accountIndex);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {

			// VIP用户
			int accountIndex1 = service1.login(username, password);
			if (accountIndex1 != -1) {
				session.setAttribute("accountIndex", accountIndex1);
				session.setAttribute("vip", "您是VIP用户！");
				request.getRequestDispatcher("/vipIndex.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "账户名或密码错误！");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
