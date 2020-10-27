package com.gocamp.forum.dao.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.spi.CurrentSessionContext;

import com.gocamp.forum.bean.Post;
import com.gocamp.util.HibernateUtil;


@WebServlet("/PostUpdateAction")
public class PostUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processSelectAll(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processSelectAll(request, response);
	}

	
	
	private void processSelectAll(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		if(request.getParameter("postid")!=null) {
			gotoupdate(request,response);
			
			
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.getCurrentSession();
		
			PostBeanDAO pDao = new PostBeanDAO(session);
			int postid = Integer.parseInt(request.getParameter("postid"));
			String forumname = request.getParameter("forumname");
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String content = request.getParameter("content");
			String category = request.getParameter("category");
			
			Post newPost = new Post(forumname, title, author, content, category);

			pDao.update(postid, newPost);
			}
		}
		
		private void gotoupdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.getCurrentSession();
			
			int postid = Integer.parseInt(request.getParameter("postid"));
			PostBeanDAO pDAO = new PostBeanDAO(session);
			List<Post> list = pDAO.select(postid);
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/AdminLTE-3.0.5/EditPost.jsp");
			rd.forward(request, response);
			
}
		
}
