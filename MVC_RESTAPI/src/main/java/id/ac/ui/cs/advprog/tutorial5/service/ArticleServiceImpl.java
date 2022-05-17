package id.ac.ui.cs.advprog.tutorial5.service;

import id.ac.ui.cs.advprog.tutorial5.model.Article;
import id.ac.ui.cs.advprog.tutorial5.model.ArticleCategoryComposite;
import id.ac.ui.cs.advprog.tutorial5.model.Category;
import id.ac.ui.cs.advprog.tutorial5.model.Editor;
import id.ac.ui.cs.advprog.tutorial5.repository.ArticleCategoryCompositeRepository;
import id.ac.ui.cs.advprog.tutorial5.repository.ArticleRepository;
import id.ac.ui.cs.advprog.tutorial5.repository.CategoryRepository;
import id.ac.ui.cs.advprog.tutorial5.repository.EditorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private EditorRepository editorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ArticleCategoryCompositeRepository compositeRepository;

    @Override
    public List<Article> getListArticle() {
        return articleRepository.findAll();
    }

    @Override
    public Iterable<Article> getListArticleByEditor(int editorId) {
        if (!editorRepository.existsById(editorId)) {
            return null;
        }
        return articleRepository.findByEditorId(editorId);
    }

    @Override
    public Article createArticle(int editorId, Article article) {
        if (!editorRepository.existsById(editorId)) {
            return null;
        }
        Editor editor = editorRepository.findById(editorId);
        editor.setWrittenArticles(editor.getWrittenArticles() + 1);
        article.setEditor(editor);
        article.setCreated_at(new Date());
        articleRepository.save(article);
        return article;
    }

    @Override
    public Article getArticleById(int id) {
        return articleRepository.findById(id);
    }

    @Override
    public Article updateArticle(int id, Article article) {
        Article old = getArticleById(id);
        old.setTitle(article.getTitle());
        old.setContent(article.getContent());
        articleRepository.save(old);
        return old;
    }

    @Override
    @Transactional
    public void deleteArticleById(int id) {
        Article article = this.getArticleById(id);
        if (article != null) {
            articleRepository.delete(article);
            compositeRepository.deleteAllByArticleId(id);
            Editor editor = article.getEditor();
            editor.setWrittenArticles(editor.getWrittenArticles() - 1);
        }
    }

    @Override
    public Category addCategory(int id, Category categoryRequest) {
        if (!articleRepository.existsById(id)) {
            return null;
        }
        Article article = articleRepository.findById(id);
        int categoryId = categoryRequest.getId();

        if (!categoryRepository.existsById(categoryId)) {
            return null;
        }
        Category category = categoryRepository.findById(categoryId);

        // by this point, article and category is GUARANTEED to exist
        if (category.isSubcategory()) {
            // if trying to add subcategory, article must also be included as parent category
            int parentId = category.getParentCategory().getId();
            if (!compositeRepository.existsByArticleIdAndCategoryId(article.getId(), parentId)) {
                Category parentCategory = categoryRepository.findById(parentId);
                compositeRepository.save(new ArticleCategoryComposite(article.getId(), parentId));
                parentCategory.setNumArticles(parentCategory.getNumArticles() + 1);
            }
        }
        category.setNumArticles(category.getNumArticles() + 1);
        compositeRepository.save(new ArticleCategoryComposite(article.getId(), category.getId()));
        return category;
    }

    @Override
    public Iterable<Category> getArticleCategories(int id) {
        if (!articleRepository.existsById(id)) {
            return null;
        }
        List<ArticleCategoryComposite> composites = compositeRepository.findByArticleId(id);
        ArrayList<Integer> categoryIds = new ArrayList<>();
        for (ArticleCategoryComposite c : composites) {
            categoryIds.add(c.getCategoryId());
        }
        return categoryRepository.findAllById(categoryIds);
    }

    @Override
    @Transactional
    public void removeCategory(int id, Category categoryRequest) {
        if (categoryRepository.existsById(categoryRequest.getId())) {
            Category category = categoryRepository.findById(categoryRequest.getId());
            category.setNumArticles(category.getNumArticles() - 1);
            List<Category> subs = categoryRepository.findAllByParentCategory(category);
            // if parent category, remove all its subcategory
            for (Category c: subs) {
                compositeRepository.deleteByArticleIdAndCategoryId(id, c.getId());
                c.setNumArticles(c.getNumArticles() - 1);
            }
        }
        compositeRepository.deleteByArticleIdAndCategoryId(id, categoryRequest.getId());
    }
}
