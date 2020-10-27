package com.gocamp.member.action;

import java.io.IOException;

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



@WebServlet("/ActionInsert.do")
public class ActionInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	processAction(request,response)	;
	
	

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	processAction(request,response)	;
	}
	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");  
		response.setContentType("text/html");   
		response.setCharacterEncoding("UTF-8");	
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
			
			
			MemberDAO mDAO=new MemberDAO(session);
//			String id=request.getParameter("id");		
			String account = request.getParameter("account");			
			String password = request.getParameter("password");
			String name = request.getParameter("name");	
			String gender = request.getParameter("gender");
			String birthday = request.getParameter("birthday");
			String mobile = request.getParameter("mobile");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String membertype = request.getParameter("membertype");
            System.out.println(membertype);
			Member newMember = new Member(account,password,name,gender,birthday,mobile,address,email,membertype);
			
			mDAO.insert(newMember);

			request.getRequestDispatcher("/AdminLTE-3.0.5/addExampleAddSuccess.jsp").forward(request, response);
		
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();

		}finally {

			System.out.println("Session Closed");
			
		}
	}
}		