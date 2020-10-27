package com.gocamp.member.action;

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

import com.gocamp.member.model.Member;
import com.gocamp.member.model.MemberDAO;
import com.gocamp.util.HibernateUtil;


@WebServlet("/ActionUpdate.do")
public class ActionUpdate extends HttpServlet {
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
		request.setCharacterEncoding("UTF-8");  
		response.setContentType("text/html");   
		response.setCharacterEncoding("UTF-8");
		if(request.getParameter("id")!=null) {
			gotoModify(request,response);		
		}else if(request.getParameter("confirm")!=null) {
			gotoHell(request,response);
		}		
	
	}

	private void gotoHell(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");  
		response.setContentType("text/html");   
		response.setCharacterEncoding("UTF-8");	
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		MemberDAO mDAO=new MemberDAO(session);
		int id = Integer.parseInt(request.getParameter("id2"));
		String account = request.getParameter("account");			
		String password = request.getParameter("password");
		String name = request.getParameter("name");	
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String membertype = request.getParameter("membertype");
		System.out.println(email);
		
		Member newMember = new Member(account,password,name,gender,birthday,mobile,address,email,membertype);
		mDAO.update(id,newMember);
		
		request.getRequestDispatcher("/AdminLTE-3.0.5/addExampleUpdateSuccess.jsp").forward(request, response);
	}

	private void gotoModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");  
		response.setContentType("text/html");   
		response.setCharacterEncoding("UTF-8");
		
		
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		int id = Integer.parseInt(request.getParameter("id"));
		MemberDAO mDAO=new MemberDAO(session);
		List<Member> list = mDAO.select(id);//選
		request.setAttribute("list", list);//包
		RequestDispatcher rd = request.getRequestDispatcher("/AdminLTE-3.0.5/addExample2.jsp");//送
		rd.forward(request, response);
		
		
		
		
	}

}