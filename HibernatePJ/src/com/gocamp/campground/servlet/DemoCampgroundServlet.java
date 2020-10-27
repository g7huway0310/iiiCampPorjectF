package com.gocamp.campground.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gocamp.campground.bean.CampgroundBean;
import com.gocamp.campground.dao.CampgroundDAO;
import com.gocamp.campground.impl.CampgroundBeanService;
import com.gocamp.util.HibernateUtil;


@WebServlet("/DemoCampgroundServlet")
public class DemoCampgroundServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		 if (request.getParameter("submitupdate") != null) { //修改成功
			Updateconfirm(request, response);
		 }else if (request.getParameter("submit") != null){//新增
			 gotoSubmitProcess(request, response);
			 
		}else if (request.getParameter("id") != null && request.getParameter("cmd").equals("DEL") ) { //刪除
			ManagerDelet(request, response);
		}else if (request.getParameter("id1") != null&& request.getParameter("cmd").equals("Update") ) { //修改
			ManagerUpdate(request, response);
       }else if (request.getParameter("city") != null ) {//查詢
	        System.out.println(request.getParameter("city"));
    	   ManagerFind(request, response);
	    }else {  
			CampSelec(request, response);
			return;
		}
	}
		
	
	public void gotoSubmitProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		int id = Integer.parseInt(request.getParameter("id").trim());
		String name = request.getParameter("name").trim();
		String city = request.getParameter("city").trim();
		String adress = request.getParameter("adress").trim();
		String tel = request.getParameter("tel").trim();
		int oprice = Integer.parseInt(request.getParameter("oprice").trim());
		int wprice = Integer.parseInt(request.getParameter("wprice").trim());
		int tentnum = Integer.parseInt(request.getParameter("tentnum").trim());
		String elevation = request.getParameter("elevation").trim();
		String feature = request.getParameter("feature").trim();
		String facility = request.getParameter("facility").trim();
		String pet = request.getParameter("pet").trim();
		String service = request.getParameter("service").trim();
		String parking = request.getParameter("parking").trim();
		CampgroundBean bean = new CampgroundBean(id, name, city, adress, tel, oprice, wprice, tentnum, elevation, feature, facility,
				pet, service, parking);
		CampgroundDAO service2 = new CampgroundDAO(session);
		service2.insert(bean);
		CampSelec(request, response);
		
	}

	public void CampSelec(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		CampgroundDAO cDao = new CampgroundDAO(session);
		List<CampgroundBean> bean = cDao.selectAll();	
		request.getSession(true).setAttribute("bean",bean);
		request.getRequestDispatcher("./AdminLTE-3.0.5/admin.campgroundCRUDTable.jsp").forward(request, response);
		} 
	
	public void ManagerFind(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		CampgroundBeanService service = new CampgroundBeanService(session);
		String city =request.getParameter("city");
		
		List<CampgroundBean> bean =service.selectByCity(city);
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("./AdminLTE-3.0.5/admin.campgroundCRUDTable.jsp").forward(request, response);
		}

	public void ManagerDelet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		CampgroundDAO cDao = new CampgroundDAO(session);
			String idstr = request.getParameter("id");
			int id = Integer.parseInt(idstr);
			
			if(cDao.delete(id)) {
				request.getSession(true).invalidate();
				request.getRequestDispatcher("./AdminLTE-3.0.5/admin.campgrounddel.jsp").forward(request, response);
			}
		}
		
	public void ManagerUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		CampgroundDAO cDao = new CampgroundDAO(session);
		String idstr = request.getParameter("id1");
		int id = Integer.parseInt(idstr);
		
		List<CampgroundBean> bean=cDao.selectById(id);
		try {
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("./AdminLTE-3.0.5/admin.campgroundupdate.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
			
		} 
	
	public void Updateconfirm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		int id = Integer.parseInt(request.getParameter("id").trim());
		String name = request.getParameter("name").trim();
		String city = request.getParameter("city").trim();
		String adress = request.getParameter("adress").trim();
		String tel = request.getParameter("tel").trim();
		int oprice = Integer.parseInt(request.getParameter("oprice").trim());
		int wprice = Integer.parseInt(request.getParameter("wprice").trim());
		int tentnum = Integer.parseInt(request.getParameter("tentnum").trim());
		String elevation = request.getParameter("elevation").trim();
		String feature = request.getParameter("feature").trim();
		String facility = request.getParameter("facility").trim();
		String pet = request.getParameter("pet").trim();
		String service = request.getParameter("service").trim();
		String parking = request.getParameter("parking").trim();

		CampgroundBeanService service2 = new CampgroundBeanService(session);
		service2.update(id, name, city, adress, tel, oprice, wprice, tentnum, elevation, feature, facility, pet, service, parking);
		try {
			request.getRequestDispatcher("./AdminLTE-3.0.5/admin.campgroundupsuccess.jsp").forward(request, response);
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}


}