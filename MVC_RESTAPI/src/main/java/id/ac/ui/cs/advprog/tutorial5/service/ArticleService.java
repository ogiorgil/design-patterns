package id.ac.ui.cs.advprog.tutorial5.service;

import id.ac.ui.cs.advprog.tutorial5.model.Article;
import id.ac.ui.cs.advprog.tutorial5.model.Category;

import java.util.List;

public interface ArticleService {
    List<Article> getListArticle();

    Iterable<Article> getListArticleByEditor(int editorId);

    Article createArticle(int editorId, Article article);

    Article getArticleById(int id);

    Article updateArticle(int id, Article article);

    void deleteArticleById(int id);

    Category addCategory(int id, Category categoryRequest);

    Iterable<Category> getArticleCategories(int id);

    void removeCategory(int id, Category categoryRequest);
}
