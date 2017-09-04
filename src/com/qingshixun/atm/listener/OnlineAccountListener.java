package com.qingshixun.atm.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnlineAccountListener implements HttpSessionListener {

	private int onlineUserCount = 0;

	/**
	 * 监听到SessionContext被创建时执行
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
		onlineUserCount++;
		HttpSession session = arg0.getSession();
		session.setAttribute("user", onlineUserCount);
	}

	/**
	 * 监听到SessionContext被销毁时执行
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		onlineUserCount--;
		HttpSession session = arg0.getSession();
		session.setAttribute("user", onlineUserCount);
	}

}
