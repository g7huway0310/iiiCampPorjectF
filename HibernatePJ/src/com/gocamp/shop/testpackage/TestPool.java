package com.gocamp.shop.testpackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gocamp.shop.bean.Product;
import com.gocamp.shop.dao.impl.ProductDAOImp;
import com.gocamp.util.HibernateUtil;

/**
 * Servlet implementation class TestPool
 */
@WebServlet("/TestPool")
public class TestPool extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestPool() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		prcessAction(request, response);
	}

	private void prcessAction(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.getCurrentSession();
		
		ProductDAOImp daoImp = new ProductDAOImp(session);
		
//		daoImp.SearchBrandItem("a",0).getDataList();
		
		int productPrice = daoImp.searchtypeOrderByPrice(1, 0).getDataList().get(0).getProductPrice();
		
		List<Product> dataList = daoImp.searchtypePriceDesc(1, 0).getDataList();
		
		System.out.println(productPrice);
		
		System.out.println(dataList);
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		prcessAction(request, response);
	}

}
