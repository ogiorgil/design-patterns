package id.ac.ui.cs.advprog.tutorial5.service;

import id.ac.ui.cs.advprog.tutorial5.model.Article;
import id.ac.ui.cs.advprog.tutorial5.model.Category;

public interface CategoryService {
    Iterable<Category> getListCategory();

    Category createCategory(Category category);

    Category getCategoryById(int id);

    Category createSubcategory(int parentId, Category category);

    Category updateCategory(int id, Category category);

    void deleteCategoryById(int id);

    Iterable<Article> getCategoryArticles(int id);
}
