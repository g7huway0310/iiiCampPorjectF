package com.gocamp.forum.dao.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gocamp.forum.bean.Post;
import com.gocamp.util.HibernateUtil;


@WebServlet("/PostSelectAllAction")
public class PostSelectAllAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processSelectAll(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processSelectAll(request, response);
		
	}

	private void processSelectAll(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		

		PostBeanDAO pDAO = new PostBeanDAO(session);
		List<Post> list = pDAO.selectAll();
		request.setAttribute("beanList", list);
		RequestDispatcher rd = request.getRequestDispatcher("/AdminLTE-3.0.5/admin.blog.postall.jsp"); // ���w��������� Demo.jsp
		rd.forward(request, response);
	}

}