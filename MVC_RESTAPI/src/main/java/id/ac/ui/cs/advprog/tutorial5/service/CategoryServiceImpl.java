package id.ac.ui.cs.advprog.tutorial5.service;

import id.ac.ui.cs.advprog.tutorial5.model.Article;
import id.ac.ui.cs.advprog.tutorial5.model.ArticleCategoryComposite;
import id.ac.ui.cs.advprog.tutorial5.model.Category;
import id.ac.ui.cs.advprog.tutorial5.repository.ArticleCategoryCompositeRepository;
import id.ac.ui.cs.advprog.tutorial5.repository.ArticleRepository;
import id.ac.ui.cs.advprog.tutorial5.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleCategoryCompositeRepository compositeRepository;

    @Override
    public Category getCategoryById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Iterable<Category> getListCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category createSubcategory(int parentId, Category category) {
        if (!categoryRepository.existsById(parentId)) {
            return null;
        }
        category.setSubcategory(true);
        category.setParentCategory(categoryRepository.findById(parentId));
        categoryRepository.save(category);
        return categoryRepository.findById(parentId);
    }

    @Override
    public Category updateCategory(int id, Category category) {
        category.setId(id);
        categoryRepository.save(category);
        return category;
    }

    @Override
    public void deleteCategoryById(int id) {
        Category category = this.getCategoryById(id);
        if(category != null) {
            if (!category.isSubcategory()) {
                List<Category> subs = categoryRepository.findAllByParentCategory(category);
                for (Category c: subs) {
                    categoryRepository.delete(c);
                    compositeRepository.deleteAllByCategoryId(c.getId());
                }
            }
            categoryRepository.delete(category);
            compositeRepository.deleteAllByCategoryId(id);
        }
    }

    @Override
    public Iterable<Article> getCategoryArticles(int id) {
        if (!categoryRepository.existsById(id)) {
            return null;
        }
        List<ArticleCategoryComposite> composites = compositeRepository.findByCategoryId(id);
        ArrayList<Integer> articleIds = new ArrayList<>();
        for (ArticleCategoryComposite c : composites) {
            articleIds.add(c.getArticleId());
        }
        return articleRepository.findAllById(articleIds);
    }
}
