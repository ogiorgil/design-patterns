package id.ac.ui.cs.advprog.tutorial5.service;

import id.ac.ui.cs.advprog.tutorial5.model.Article;
import id.ac.ui.cs.advprog.tutorial5.model.ArticleCategoryComposite;
import id.ac.ui.cs.advprog.tutorial5.model.Category;
import id.ac.ui.cs.advprog.tutorial5.repository.ArticleCategoryCompositeRepository;
import id.ac.ui.cs.advprog.tutorial5.repository.ArticleRepository;
import id.ac.ui.cs.advprog.tutorial5.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {
    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private ArticleRepository articleRepository;

    @Mock
    private ArticleCategoryCompositeRepository compositeRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    private Category category;

    private Category subcategory;

    @BeforeEach
    public void setUp() {
        String categoryName = "Action";
        String subcategoryName = "sub";
        int categoryNumArticles = 0;
        category = new Category(categoryName, categoryNumArticles);
        category.setId(0);
        subcategory = new Category(subcategoryName, categoryNumArticles);
        subcategory.setId(1);
    }

    @Test
    public void testGetCategoryById() {
        lenient().when(categoryService.getCategoryById(0)).thenReturn(category);
        Category calledCategory = categoryService.getCategoryById(0);
        assertEquals(calledCategory.getId(), category.getId());
    }

    @Test
    public void testGetListCategory() {
        Iterable<Category> categoryList = categoryRepository.findAll();
        lenient().when(categoryService.getListCategory()).thenReturn(categoryList);
        Iterable<Category> categoryListResult = categoryService.getListCategory();
        assertIterableEquals(categoryList, categoryListResult);
    }

    @Test
    public void testCreateCategory() {
        lenient().when(categoryService.createCategory(category)).thenReturn(category);
    }

    @Test
    public void testCreateSubcategory() {
        when(categoryRepository.existsById(category.getId())).thenReturn(true);
        when(categoryRepository.findById(category.getId())).thenReturn(category);

        assertEquals(category, categoryService.createSubcategory(0, subcategory));
    }

    @Test
    public void testCreateSubcategoryNonExistentParent() {
        when(categoryRepository.existsById(category.getId())).thenReturn(false);

        assertNull(categoryService.createSubcategory(0, subcategory));
    }

    @Test
    public void testUpdateCategory() {
        categoryService.createCategory(category);
        String pastName = category.getName();

        String newName = "Fantasy";
        category.setName(newName);

        lenient().when(categoryService.updateCategory(category.getId(), category)).thenReturn(category);
        Category categoryResult = categoryService.updateCategory(category.getId(), category);

        assertEquals(categoryResult.getId(), category.getId());
        assertNotEquals(categoryResult.getName(), pastName);
    }

    @Test
    public void testDeleteCategoryById() {
        categoryService.createCategory(category);
        lenient().when(categoryRepository.findById(0)).thenReturn(category);
        categoryService.deleteCategoryById(0);
        lenient().when(categoryService.getCategoryById(0)).thenReturn(null);
        assertNull(categoryService.getCategoryById(0));
    }

    @Test
    public void testDeleteNonExistentCategoryById() {
        categoryService.createCategory(category);
        lenient().when(categoryRepository.findById(0)).thenReturn(null);
        categoryService.deleteCategoryById(0);
    }

    @Test
    public void testGetCategoryArticles() {
        when(categoryRepository.existsById(category.getId())).thenReturn(true);

        ArticleCategoryComposite composite1 = new ArticleCategoryComposite(1, 0);
        ArticleCategoryComposite composite2 = new ArticleCategoryComposite(2, 0);
        List<ArticleCategoryComposite> composites = List.of(composite1, composite2);
        when(compositeRepository.findByCategoryId(category.getId())).thenReturn(composites);

        List<Integer> ids = List.of(1, 2);
        Article article1 = new Article();
        Article article2 = new Article();
        List<Article> articles = List.of(article1, article2);
        when(articleRepository.findAllById(ids)).thenReturn(articles);

        assertEquals(articles, categoryService.getCategoryArticles(category.getId()));
    }

    @Test
    public void testGetCategoryArticlesNonExistentCategory() {
        when(categoryRepository.existsById(category.getId())).thenReturn(false);

        assertNull(categoryService.getCategoryArticles(category.getId()));
    }
}
