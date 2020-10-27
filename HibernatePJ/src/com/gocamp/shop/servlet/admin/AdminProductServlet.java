package com.gocamp.shop.servlet.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.criteria.CriteriaBuilder.Case;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.gocamp.shop.bean.PageBean;
import com.gocamp.shop.bean.Product;
import com.gocamp.shop.dao.impl.ProductDAOImp;
import com.gocamp.shop.service.ProductService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class AdminProductServlet
 */
@WebServlet("/AdminProductServlet")
public class AdminProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		System.out.println("inside");
		String action = request.getParameter("action");
		System.out.println(action);

		switch (action) {

		case "jump":
//			jump(request, response);
			break;
		case "list":
			List(request, response);
			break;
		case "add":
			Add(request, response);
			break;
		case "update":
//			Update(request, response);
			break;
		case "edit":
			Edit(request, response);
			break;
		case "del":
			Del(request, response);
			break;
		case "saveupload":
			saveupload(request, response);
			break;

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		response.setContentType("text/html; charset=UTF-8");

		String pname = request.getParameter("name");

		System.out.println(pname);

		doGet(request, response);
	}

	private void List(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");

		response.setContentType("text/html; charset=UTF-8");

		ProductService service = new ProductService();

//		String page = request.getParameter("pageno");
//
//		System.out.println(page);
//
//		int pageno = Integer.valueOf(page);

		PageBean<Product> listAll = service.getAll(0);

		java.util.List<Product> dataList = listAll.getDataList();

//		Gson gson = new GsonBuilder().create();

//		JsonArray jsonArray = gson.toJsonTree(dataList).getAsJsonArray();
//
//		JsonObject aJsonObject = new JsonObject();
//
//		aJsonObject.add("datas", jsonArray);
//
//		PrintWriter writer = response.getWriter();
//
//		writer.print(aJsonObject);
//Ajax

		System.out.println(dataList);

		request.setAttribute("totalPage", listAll.getTotalPage());

		request.setAttribute("listAll", dataList);

		RequestDispatcher rd = request.getRequestDispatcher("AdminLTE-3.0.5/admin.shop.list.jsp");

		rd.forward(request, response);

	}

	private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		System.out.println(isMultipart);
		
		Product aProduct = null;

		int id = 0;

		ProductService service = new ProductService();

		request.setCharacterEncoding("UTF-8");

		response.setContentType("text/html; charset=UTF-8");

		System.out.println("進入存檔");

		try {

			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// Configure a repository (to ensure a secure temp location is used)
			ServletContext servletContext = this.getServletConfig().getServletContext();

			File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");

			factory.setRepository(repository);

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			upload.setHeaderEncoding("UTF-8");

			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			// Parse the request
			java.util.List<FileItem> items = upload.parseRequest(request);

			Iterator<FileItem> iter = items.iterator();

			System.out.println(iter);

			HashMap<String, String> fields = new HashMap<String, String>();

			java.util.List<String> aList = new ArrayList<String>();

			String filename = null;

			while (iter.hasNext()) {
				FileItem item = iter.next();

				// 判斷是否是普通類型的表單
				if (item.isFormField()) {

					fields.put(item.getFieldName(), item.getString());
					String value = item.getString("UTF-8");
					String name = item.getFieldName();
					System.out.println("name=" + name);
					System.out.println("value" + value);

					aList.add(value);
					
					// 不是普通
				} else {
					filename = item.getName();

					System.out.println("filename=" + filename);

					filename = filename.substring(filename.lastIndexOf(File.separatorChar) + 1);

					System.out.println(filename);

					String name = aList.get(0);
					String brand = aList.get(1);
					String prices = aList.get(2);
					String stocks = aList.get(3);
					String catoID = aList.get(4);

					String productSpec = aList.get(5);
					String productfeature = aList.get(6);
					String productWarring = aList.get(7);

					int price = Integer.valueOf(prices);
					int stock = Integer.valueOf(stocks);
					int cato = Integer.valueOf(catoID);

					Path path = Paths.get(filename);

					String storePath = "D:\\productIMG";

					Path fileName2 = path.getFileName();

					String filenames = String.valueOf(fileName2);

					System.out.println(filenames);

					System.out.println(storePath);

					File uploadFile = new File(storePath + "/" + fileName2);

					if (uploadFile.exists()) {
						uploadFile.delete();
					}

					item.write(uploadFile);
					System.out.println("寫入資料");
					System.out.println(storePath + "/" + fileName2);
					aProduct = new Product(brand, name, price, cato, productSpec, stock, productWarring, productfeature,
							filenames, 0);

				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		finally {
			Product updateData = service.inserData(aProduct);
			List(request, response);
		}

	}

//
	private void Edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");

		response.setContentType("text/html; charset=UTF-8");

		String ids = request.getParameter("id");

		int id = Integer.valueOf(ids);

		ProductService service = new ProductService();

		Product findProduct = service.findProduct(id);

		request.setAttribute("product", findProduct);

		RequestDispatcher rd = request.getRequestDispatcher("AdminLTE-3.0.5/admin.shop.edit.jsp");

		rd.forward(request, response);
	}

	private void saveupload(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		Product aProduct = new Product();

		int id = 0;

		ProductService service = new ProductService();

		request.setCharacterEncoding("UTF-8");

		response.setContentType("text/html; charset=UTF-8");

		System.out.println("進入存檔");

		try {

			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// Configure a repository (to ensure a secure temp location is used)
			ServletContext servletContext = this.getServletConfig().getServletContext();

			File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");

			factory.setRepository(repository);

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			upload.setHeaderEncoding("UTF-8");

			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			// Parse the request
			java.util.List<FileItem> items = upload.parseRequest(request);

			Iterator<FileItem> iter = items.iterator();

			System.out.println(iter);

			HashMap<String, String> fields = new HashMap<String, String>();

			java.util.List<String> aList = new ArrayList<String>();

			String filename = null;
			
			

			while (iter.hasNext()) {
				
				FileItem item = iter.next();

			    //一般form
				if (item.isFormField()) {

					fields.put(item.getFieldName(), item.getString());
					String value = item.getString("UTF-8");
					String name = item.getFieldName();
					System.out.println("name=" + name);
					System.out.println("value" + value);
					
					aList.add(value);
					

				} else {
					
					filename = item.getName();
					
					if (filename == null || filename.equals("")) {
						System.out.println("沒更新圖片");
						String ids=aList.get(0);
						String name = aList.get(1);
						String brand = aList.get(2);
						String stocks = aList.get(3);
						String prices = aList.get(4);
						String productSpec = aList.get(5);
						String productfeature = aList.get(6);
						String productWarring = aList.get(7);
					    
						id=Integer.valueOf(ids);
						System.out.println(id);
						int price = Integer.valueOf(prices);
						int stock = Integer.valueOf(stocks);

						aProduct.setProductBrand(brand);
						aProduct.setProductfeature(productfeature);
						aProduct.setProductName(name);
						aProduct.setProductPrice(price);
						aProduct.setProductStock(stock);
						aProduct.setProductWarring(productWarring);
						aProduct.setProductSpec(productSpec);
						
						Product orgProduct = service.findProduct(id);
						
						aProduct.setPicpath(orgProduct.getPicpath());
						
						Product updateData = service.updateData(aProduct, id);
						
					} else {
						System.out.println(aList.get(1));
						System.out.println("成功");
						String ids = aList.get(0);
						id = Integer.valueOf(ids);
						
						String name = aList.get(1);
						String brand = aList.get(2);
						String stocks = aList.get(3);
						String prices = aList.get(4);
						String productSpec = aList.get(5);
						String productfeature = aList.get(6);
						String productWarring = aList.get(7);
						String fileString = aList.get(8);
						

						int price = Integer.valueOf(prices);
						int stock = Integer.valueOf(stocks);
						
						
						
						aProduct.setProductBrand(brand);
						aProduct.setProductfeature(productfeature);
						aProduct.setProductName(name);
						aProduct.setProductPrice(price);
						aProduct.setProductStock(stock);
						aProduct.setProductWarring(productWarring);
						aProduct.setProductSpec(productSpec);
						
						

						Path path = Paths.get(filename);

						String storePath = "D:\\productIMG";

						Path fileName2 = path.getFileName();

						String filenames = String.valueOf(fileName2);

						aProduct.setPicpath(filenames);

						System.out.println(filenames);

						System.out.println(storePath);
						File uploadFile = new File(storePath + "/" + fileName2);

						if (uploadFile.exists()) {
							uploadFile.delete();
						}

						item.write(uploadFile);
						System.out.println("寫入資料");
						System.out.println(storePath + "/" + fileName2);
						
						

					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		finally {			
			Product updateData = service.updateData(aProduct, id);
			List(request, response);
		}

	}

//
	private void Del(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		ProductService service = new ProductService();

		String ids = request.getParameter("id");

		int id = Integer.valueOf(ids);

		boolean delete = service.delete(id);

		Product findProduct = service.findProduct(id);

		System.out.println("成功刪除");

		List(request, response);

	}
//
//	//取得編號內的數字
//	public static String getNum(String strInput) {
//		
//		// 匹配指定範圍內的數字
//		String regEx = "[^0-9]";
//		// Pattern是一個正則表示式經編譯後的表現模式
//		Pattern p = Pattern.compile(regEx);
//		// 一個Matcher物件是一個狀態機器，它依據Pattern物件做為匹配模式對字串展開匹配檢查。
//		Matcher m = p.matcher(strInput);
//		// 將輸入的字串中非數字部分用空格取代並存入一個字串
//		String string = m.replaceAll(" ").trim();
//		// 以空格為分割符在講數字存入一個字串陣列中
//		String[] strArr = string.split(" ");
//		StringBuffer stringBuffer = new StringBuffer();
//		// 遍歷陣列轉換資料型別輸出
//		for (String s : strArr) {
//			stringBuffer.append(s);
//			System.out.println(Integer.parseInt(s));
//		}
//		String num = stringBuffer.toString();
//		System.out.println("num is " + num);
//		return num;
//	}
//
//// 擷取非數字 
//	public String splitNotNumber(String content) {
//		Pattern pattern = Pattern.compile("\\D ");
//		Matcher matcher = pattern.matcher(content);
//		while (matcher.find()) {
//			return matcher.group(0);
//		}
//		return "";
//	}//	    ProductService service=new ProductService();
//    
//	String name = request.getParameter("name");
//	System.out.println(name);
//	String brand = request.getParameter("brand");
//	String prices = request.getParameter("price");
//	int price = Integer.valueOf(prices);
//	String stocks = request.getParameter("stock");
//	int stock = Integer.valueOf(stocks);
//	String spec = request.getParameter("spec");
//	String warring = request.getParameter("warring");
//	String categortIds = request.getParameter("cato");
//	int categortId = Integer.valueOf(categortIds);
//	System.out.println(categortId);
//	String productfeature = request.getParameter("feat");
//
//	java.util.List<Product> cattype = service.searchtype(categortId);
//
//	Product shoppingProduct = cattype.get(cattype.size() - 1);
//
//	String id = shoppingProduct.getProductId();
//
//	System.out.println(id);
//
//	AdminProductServlet a = new AdminProductServlet();
//
//	String numbers = a.getNum(id);
//
//	System.out.println(numbers);
//
//	String type = id.replaceAll("([1-9]+[0-9]*|0)(\\.[\\d]+)?", "");
//
//	System.out.println(type);
//
//	int pid = Integer.valueOf(numbers);
//
//	pid = pid + 1;
//
//	String aBuffer;
//
//	if (pid < 100) {
//
//		System.out.println(pid);
//
//		String megid = String.valueOf(pid);
//
//		aBuffer = type + "0" + megid;
//
//	} else {
//		System.out.println(pid);
//
//		String megid = String.valueOf(pid);
//
//		aBuffer = type + megid;
//
//	}
//
//	Product aProduct = new Product(aBuffer, brand, name, price, categortId, spec, stock, warring,
//			productfeature, 0);
//
//	service.inserData(aProduct);
//
//	System.out.println("成功inser");
//
//	request.setAttribute("searchtype", cattype);
//
//	RequestDispatcher rd = request.getRequestDispatcher("admin/listProduct.jsp");
//
//	rd.forward(request, response);

//
//private void Update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//	Connection connection = null;
//	InitialContext ctxt = null;
//	Object lookup = null;
//	try {
//		ctxt = new InitialContext();
//		lookup = ctxt.lookup("java:comp/env/jdbc/xe");
//		DataSource ds = (DataSource) lookup;
//		connection = ds.getConnection();
//
//	} catch (NamingException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	ProductDAOImp service = new ProductDAOImp(connection);
//	String id = request.getParameter("id");
//	Product findProduct = service.findProduct(id);
//	
//	int cato = findProduct.getCategortId();
//	String name = request.getParameter("name");
//	System.out.println(name);
//	String brand = request.getParameter("brand");
//	String prices = request.getParameter("price");
//	int price = Integer.valueOf(prices);
//	String stocks = request.getParameter("stock");
//	int stock = Integer.valueOf(stocks);
//	String spec = request.getParameter("spec");
//	String warring = request.getParameter("warring");
//	String categortIds = request.getParameter("cato");
//
//	String productfeature = request.getParameter("feat");
//	
//	Product aProduct=new Product(id, brand, name, price, cato, spec, stock, warring, productfeature, 0);
//
//	service.updateDatas(aProduct);
//	
//	findProduct=service.findProduct(id);
//	
//	ArrayList<Product> aList=new ArrayList<Product>();
//	
//	aList.add(findProduct);
//	
//	request.setAttribute("searchtype", aList);
//	
//	RequestDispatcher rd = request.getRequestDispatcher("admin/listProduct.jsp");
//
//	rd.forward(request, response);
//	
////
//
//}
}
