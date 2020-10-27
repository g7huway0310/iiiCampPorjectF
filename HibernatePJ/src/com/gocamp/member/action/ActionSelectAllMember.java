package com.gocamp.member.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gocamp.member.model.Member;
import com.gocamp.member.model.MemberDAO;
import com.gocamp.util.HibernateUtil;


@WebServlet("/ActionSelectAllMember.do")
public class ActionSelectAllMember extends HttpServlet {
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
		

		MemberDAO mDAO = new MemberDAO(session);
		List<Member> list = mDAO.selectAll();
		request.setAttribute("beanList", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("AdminLTE-3.0.5/admin.member.listok.jsp"); 
		rd.forward(request, response);

	}

}