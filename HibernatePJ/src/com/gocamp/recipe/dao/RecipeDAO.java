package com.gocamp.recipe.dao;

import java.util.List;

import com.gocamp.recipe.model.Recipe;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class RecipeDAO {
	private Session session;
	
	public RecipeDAO(Session session) {
		this.session = session;
	}
	
	public Recipe insert(Recipe recipe) {
		Recipe result = session.get(Recipe.class,recipe.getReid());
		
		if (result==null) {
			session.saveOrUpdate(recipe);
			return recipe;
		}
		return null;
	}
	
	public List<Recipe> select(int reid) {
		Query<Recipe> query = session.createQuery("From Recipe where reid="+reid, Recipe.class);
		List<Recipe> list = query.list();
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getReid()!=reid) {
				return null;
		}    	
			}
			return list;
	}
	
	
	public List<Recipe> selectByName(String rename){
		List result=session.createQuery("from Recipe where rname like "+"'%"+rename+"%'").list(); 
		
		for (int i = 0; i<result.size() ; i++) {
			Recipe recipe = (Recipe) result.get(i);
			int reid = recipe.getReid();
			String rname = recipe.getRename();
			String brief = recipe.getBrief();
			String image = recipe.getImage();
			String ingredient = recipe.getIngredient();
			int people = recipe.getPeople();
			int time = recipe.getTime();			
		}
		return result;
	}

	
	public List<Recipe> selectAll() {
		Query<Recipe> query = session.createQuery("From Recipe", Recipe.class);
		List<Recipe> list = query.list();
		return list;
	}
	
	public Recipe update(int reid, String rename, String brief, String image, String ingredient, String tip1, String tip2,
			String tip3, String tip4, String tip5, String tip6, String note, int people, Integer time) {
		Recipe result = session.get(Recipe.class, reid);
		
		if(result!=null) {
			result.setRename(rename);
			result.setBrief(brief);
			result.setImage(image);
			result.setIngredient(ingredient);
			result.setTip1(tip1);
			result.setTip2(tip2);
			result.setTip3(tip3);
			result.setTip4(tip4);
			result.setTip5(tip5);
			result.setTip6(tip6);
			result.setNote(note);
			result.setPeople(people);
			result.setTime(time);
		}
		
		return result;
	}
	
	public boolean delete(int reid) {
		Recipe result = session.get(Recipe.class, reid);
		
		if(result!=null) {
			session.delete(result);
			return true;
		}
		
		return false;
	}

}
