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


@WebServlet("/PostAddServletAction")
public class PostAddServletAction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);

	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session  = factory.getCurrentSession();
		
		try {
			PostBeanDAO pDao = new PostBeanDAO(session);
			String forumname = request.getParameter("forumname");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String favorite = request.getParameter("favorite");
			String author = request.getParameter("author");
			String category = request.getParameter("category");
		
			Post newPost = new Post(forumname, title, author, content, category);
				
			Post post1 = pDao.insert(newPost);
		
			
			
			
			}catch (Exception e) {
				session.getTransaction().rollback();
				e.printStackTrace();

			}finally {
				HibernateUtil.closeSessionFactory();
				System.out.println("Session Closed");
				
			}
		}
	

	private void processDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		

		PostBeanDAO pDAO = new PostBeanDAO(session);
		int postid=Integer.parseInt(request.getParameter("postid"));
		try {
			pDAO.delete(postid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}

	
	
	

	
	
	
	
	
	
	


	


}		