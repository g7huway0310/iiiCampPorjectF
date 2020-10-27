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
import com.gocamp.util.HibernateUtil;


@WebServlet("/DemoCampgroundServlet")
public class DemoCampgroundServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("submitshow") != null){//查詢
			ManagerFind(request, response);
		}else {  
			CampSelec(request, response);
		}
		
		if (request.getParameter("submit") != null)//新增
			gotoSubmitProcess(request, response);
			
		
		 if (request.getParameter("confirmupdate") != null)//更新
			Updateconfirm(request, response);
		else if (request.getParameter("confirmshow") != null)
			UpdateSussce(request, response);
		 
		if (request.getParameter("id") != null && request.getParameter("cmd").equals("DEL") ) { //刪除
			System.out.println("id");
			ManagerDelet(request, response);
		}else if (request.getParameter("id") != null && request.getParameter("cmd").equals("Update")) //修改
			System.out.println("id=" + request.getParameter("id"));
			ManagerUpdate(request, response);
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
		request.getRequestDispatcher("./AdminLTE-3.0.5/CRUD Table.jsp").forward(request, response);
		
	}

	public void CampSelec(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		CampgroundDAO cDao = new CampgroundDAO(session);
		List<CampgroundBean> bean = cDao.selectAll();	

		
		request.getSession(true).setAttribute("bean",bean);
		request.getRequestDispatcher("./AdminLTE-3.0.5/CRUD Table.jsp").forward(request, response);
		} 
	
	public void ManagerFind(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		
		CampgroundDAO cDao = new CampgroundDAO(session);
		
		String city =request.getParameter("city");
		
		List<CampgroundBean> list1 = (List<CampgroundBean>)cDao.selectByCity(city);
		request.setAttribute("CampgroundList", list1);
		request.getRequestDispatcher("./AdminLTE-3.0.5/CRUD Table.jsp").forward(request, response);
		}

	

	public void ManagerDelet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		CampgroundDAO cDao = new CampgroundDAO(session);
			String idstr = request.getParameter("id");
			int id = Integer.parseInt(idstr);
			
			if(cDao.delete(id)) {
				request.getRequestDispatcher("./AdminLTE-3.0.5/CRUD Table.jsp").forward(request, response);
			}
		}
		


	public void ManagerUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		
//
//			int id = Integer.parseInt(request.getParameter("id").trim());
//			System.out.println(id);
//			
//			CampBeanDAO dao = new CampBeanDAO(conn);
//			
//			List<CampBean> list1 = dao.getcampsById(id);
//			
//		
//			request.getSession(true).setAttribute("list1", list1);
//			
//			
//			request.getRequestDispatcher("/CampUpdate.jsp").forward(request, response);
//			
		} 
	
	public void Updateconfirm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		
//		int id = Integer.parseInt(request.getParameter("id").trim());
//		String name = request.getParameter("name").trim();
//		String city = request.getParameter("city").trim();
//		String adress = request.getParameter("adress").trim();
//		String tel = request.getParameter("tel").trim();
//		int oprice = Integer.parseInt(request.getParameter("oprice").trim());
//		int wprice = Integer.parseInt(request.getParameter("wprice").trim());
//		int tentnum = Integer.parseInt(request.getParameter("tentnum").trim());
//		String elevation = request.getParameter("elevation").trim();
//		String feature = request.getParameter("feature").trim();
//		String facility = request.getParameter("facility").trim();
//		String pet = request.getParameter("pet").trim();
//		String service = request.getParameter("service").trim();
//		String parking = request.getParameter("parking").trim();
//		CampBean dao = new CampBean(id, name, city, adress, tel, oprice, wprice, tentnum, elevation, feature, facility,
//				pet, service, parking);
//		request.getSession(true).setAttribute("dao", dao);
//		request.getRequestDispatcher("/DisplayUpdate.jsp").forward(request, response);
	}

	public void UpdateSussce(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//			CampBeanDAO campBeanDAO = new CampBeanDAO(conn);
//			CampBean campData = (CampBean) request.getSession(true).getAttribute("dao");
//			if (campBeanDAO.updateCamp(campData)) {
//				System.out.println("更新成功");
//				request.getSession(true).invalidate();
//				request.getRequestDispatcher("/UpdateSussce.jsp").forward(request, response);
//			}
		} 

	
	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		CampgroundDAO cDao = new CampgroundDAO(session);
		CampgroundBean campBean = cDao.select(26);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.write("Id:" + campBean.getId() + "<br/>");
		out.write("Name:" + campBean.getName() + "<br/>");
		
		out.close();
		
	}

}
