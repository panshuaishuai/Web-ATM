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
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AccountServiceImpl service = new AccountServiceImpl();
	private VIPAccountServiceImpl service1 = new VIPAccountServiceImpl();

	public ChangePasswordServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String originalPassword = request.getParameter("originalPassword");
		String newPassword = request.getParameter("newPassword");

		// 获取数组普通用户下标
		int accountIndex = (int) request.getSession().getAttribute("accountIndex");
		int revampPassword = service.changePassword(accountIndex, originalPassword, newPassword);
		if (revampPassword != -1) {
			if (revampPassword != -2) {
				if (revampPassword == 0) {
					request.setAttribute("message", "密码修改成功！");
					request.getRequestDispatcher("/changePasswordResult.jsp").forward(request, response);
				}

			} else {
				request.setAttribute("message", "原密码输入有误，修改失败！");
				request.getRequestDispatcher("/changePassword.jsp").forward(request, response);
			}
		} else {

			// 获取数组VIP用户下标
			int accountIndex1 = (int) request.getSession().getAttribute("accountIndex");
			int revampPassword1 = service1.changePassword(accountIndex1, originalPassword, newPassword);
			if (revampPassword1 != -1) {
				if (revampPassword1 != -2) {
					if (revampPassword1 == 0) {
						request.setAttribute("message", "密码修改成功！");
						request.getRequestDispatcher("/vipChangePasswordResult.jsp").forward(request, response);
					}
				} else {
					request.setAttribute("message", "原密码输入有误，修改失败！");
					request.getRequestDispatcher("/vipChangePassword.jsp").forward(request, response);
				}
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
