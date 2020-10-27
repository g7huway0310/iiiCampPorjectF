package com.gocamp.shop.testpackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

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

import tw.huway0310.model.HouseBean;
import tw.huway0310.model.HouseBeanDAO;

/**
 * Servlet implementation class DemoHibernateAction
 */
@WebServlet("/DemoHibernateAction")
public class initProductdata extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		prcessAction(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		prcessAction(request, response);
	}

	private void prcessAction(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.getCurrentSession();

		ProductDAOImp daoImp = new ProductDAOImp(session);

		File file = new File("C:\\newdatas.csv");
		
		InputStream is;
		try {
			is = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strLine = null;
			while ((strLine = br.readLine()) != null) {
				String[] array = strLine.split(",");// 因為預設是用"，"分開所以用split切開存入字串陣列
//			System.out.println(strLine);
//			System.out.println(array[0]);
//			System.out.println(array[3]);
//			System.out.println(array[4]);
				Product aProduct = null;
				for (int i = 0; i < array.length; i++) {// 偷看陣列元素有沒有切對

				String brand = array[0];
				String name = array[1];
				int price = Integer.valueOf(array[2]);
				String feature = array[3];
			    String spec = array[4];
				String warring = array[5];
				int stock = Integer.valueOf(array[6]);
				int categortId = Integer.valueOf(array[7]);
				int click = Integer.valueOf(array[8]);
				String pic = array[9];
			    
				aProduct=new Product(brand, name, price, categortId, spec, stock, warring, feature, pic, click);
				
				}
				daoImp.inserData(aProduct);
			
		}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	}
	}
