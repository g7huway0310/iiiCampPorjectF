package com.gocamp.forum.dao.impl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gocamp.util.HibernateUtil;


@WebServlet("/PostDelectAction")
public class PostDelectAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
		
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		PostBeanDAO pDAO = new PostBeanDAO(session);
		
		int postid=Integer.parseInt(request.getParameter("postid"));
		System.out.println("uuuu");
		try {
			pDAO.delete(postid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}

}
