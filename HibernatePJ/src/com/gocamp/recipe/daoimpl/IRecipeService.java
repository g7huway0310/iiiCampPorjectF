package com.gocamp.recipe.daoimpl;

import java.util.List;

import com.gocamp.recipe.model.Recipe;

public interface IRecipeService {
	public Recipe insert(Recipe recipe);
	public List<Recipe> select(int reid);
	public List<Recipe> selectAll();
	public Recipe update(int reid, String rename, String brief, String image, String ingredient, String tip1, String tip2,
			String tip3, String tip4, String tip5, String tip6, String note, int people, Integer time);
	public boolean delete(int reid);
	public List<Recipe> selectByName(String rename);

}
