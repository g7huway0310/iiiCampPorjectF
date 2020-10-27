package com.gocamp.recipe.daoimpl;

import java.util.List;

import org.hibernate.Session;

import com.gocamp.recipe.dao.RecipeDAO;
import com.gocamp.recipe.model.Recipe;

public class RecipeService implements IRecipeService {

private RecipeDAO rDao;
	
	public RecipeService(Session session) {
		rDao = new RecipeDAO(session);
	}
	
	@Override
	public Recipe insert(Recipe recipe) {
		return rDao.insert(recipe);
	}

	@Override
	public List<Recipe> select(int reid) {
		return rDao.select(reid);
	}

	@Override
	public List<Recipe> selectAll() {
		return rDao.selectAll();
	}

	@Override
	public Recipe update(int reid, String rename, String brief, String image, String ingredient, String tip1,
			String tip2, String tip3, String tip4, String tip5, String tip6, String note, int people, Integer time) {
		return rDao.update(reid, rename, brief, image, ingredient, tip1, tip2, tip3, tip4, tip5, tip6, note, people, time);
	}

	@Override
	public boolean delete(int reid) {
		return rDao.delete(reid);
	}

	@Override
	public List<Recipe> selectByName(String rename) {
		return rDao.selectByName(rename);
	}
}
