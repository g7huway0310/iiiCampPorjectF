package com.gocamp.recipe.servlet.admin;

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
import org.hibernate.Transaction;

import com.gocamp.recipe.daoimpl.RecipeService;
import com.gocamp.recipe.model.Recipe;
import com.gocamp.util.HibernateUtil;


@WebServlet("/RecipeServletForUser.do")
public class RecipeServletForUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRecipeAction(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRecipeAction(request, response);
	}
	
private void processRecipeAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  request.setCharacterEncoding("UTF-8");
	  response.setContentType("text/html;charset=UTF-8");
	    if (request.getParameter("cmd")!=null && request.getParameter("cmd").equals("DEL")) {
			gotoDeleteRecipe(request,response);
	    }else if (request.getParameter("cmd")!=null && request.getParameter("cmd").equals("modify")) {
	    	gotoModifyRecipe(request,response);
		}else if (request.getParameter("confirmModify")!=null) {
			gotoModifyComfirm(request,response);
		}else if (request.getParameter("createRecipe")!=null) {
			createRecipe(request,response);
		}else if (request.getParameter("submit") !=null) {
			gotoCheckID(request, response);
		}else {
			gotoSelectAll(request, response);
				}
}
		
		
		private void createRecipe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.getCurrentSession();
			
			String rename = request.getParameter("rename").trim();
			String brief = request.getParameter("brief").trim();
			String image = request.getParameter("img").trim();
			String ingredient = request.getParameter("ingredients");
			String tip1 = request.getParameter("tip1").trim();
			String tip2 = request.getParameter("tip2").trim();
			String tip3 = request.getParameter("tip3").trim();
			String tip4 = request.getParameter("tip4").trim();
			String tip5 = request.getParameter("tip5").trim();
			String tip6 = request.getParameter("tip6").trim();
			String note = request.getParameter("note").trim();
			int people = Integer.parseInt(request.getParameter("people"));
			int time = Integer.parseInt(request.getParameter("time"));
			double price =0;
			double discount =0;
			int stock = 0;
			
			Recipe recipe = new Recipe(rename,brief,image,ingredient,tip1,tip2,tip3,tip4,tip5,tip6,note,people,time,price,discount,stock);
            RecipeService service = new RecipeService(session);
            service.insert(recipe);
			request.getRequestDispatcher("./AdminLTE-3.0.5/AddRecipeSuccess.jsp").forward(request,response);	
	
}


		private void gotoModifyComfirm(HttpServletRequest request, HttpServletResponse response) {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.getCurrentSession();
			
			int reid = Integer.parseInt(request.getParameter("reid"));
			String rename = request.getParameter("rename");
			String brief = request.getParameter("brief");
			String image = request.getParameter("image");
			String ingredient = request.getParameter("ingredient");
			String tip1 = request.getParameter("tip1");
			String tip2 = request.getParameter("tip2");
			String tip3 = request.getParameter("tip3");
			String tip4 = request.getParameter("tip4");
			String tip5 = request.getParameter("tip5");
			String tip6 = request.getParameter("tip6");
			String note = request.getParameter("note");
			int people = Integer.parseInt(request.getParameter("people"));
			int time = Integer.parseInt(request.getParameter("time"));
			
			RecipeService service = new RecipeService(session);
			Recipe recipe = service.update(reid, rename, brief, image, ingredient, tip1, tip2, tip3, tip4, tip5, tip6, note, people, time);
			try {
				request.getRequestDispatcher("./AdminLTE-3.0.5/UpdateRecipeSuccess.jsp").forward(request,response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			
}


		private void gotoModifyRecipe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.getCurrentSession();
			
			int reid = Integer.valueOf(request.getParameter("reid"));
			RecipeService service = new RecipeService(session);
			List<Recipe> recipe = service.select(reid);
			request.setAttribute("recipe", recipe);	
			request.getRequestDispatcher("./AdminLTE-3.0.5/UpdateRecipe.jsp").forward(request,response);				
			
}

		private void gotoDeleteRecipe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.getCurrentSession();
			
			int reid = Integer.valueOf(request.getParameter("reid"));
			RecipeService service = new RecipeService(session);
			if(service.delete(reid)) {
				RequestDispatcher rd = request.getRequestDispatcher("./AdminLTE-3.0.5/DeleteRecipeSuccess.jsp");
			    rd.forward(request, response);
				
		};
	
}


		private void gotoCheckID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.getCurrentSession();
			
			String rename = request.getParameter("re_name");
			System.out.println(rename);
			RecipeService service = new RecipeService(session);
			List<Recipe> recipe = service.selectByName(rename);
			
			request.setAttribute("recipe", recipe);	
			request.getRequestDispatcher("./recipe/Recipe.jsp").forward(request,response);
	               
	
}


		private void gotoSelectAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    
			SessionFactory factory = HibernateUtil.getSessionFactory();
		    Session session = factory.getCurrentSession();
		
		RecipeService service = new RecipeService(session);
		List<Recipe> recipe = service.selectAll();
		request.setAttribute("recipe", recipe);		
		request.getRequestDispatcher("./AdminLTE-3.0.5/RecipeAdmin.jsp").forward(request,response);
		
		}
		
	
}

		
		
		

		
	


