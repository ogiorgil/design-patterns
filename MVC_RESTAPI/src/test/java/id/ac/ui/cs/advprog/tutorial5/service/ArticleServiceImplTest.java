package id.ac.ui.cs.advprog.tutorial5.service;

import id.ac.ui.cs.advprog.tutorial5.model.Article;
import id.ac.ui.cs.advprog.tutorial5.model.ArticleCategoryComposite;
import id.ac.ui.cs.advprog.tutorial5.model.Category;
import id.ac.ui.cs.advprog.tutorial5.model.Editor;
import id.ac.ui.cs.advprog.tutorial5.repository.ArticleCategoryCompositeRepository;
import id.ac.ui.cs.advprog.tutorial5.repository.ArticleRepository;
import id.ac.ui.cs.advprog.tutorial5.repository.CategoryRepository;
import id.ac.ui.cs.advprog.tutorial5.repository.EditorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ArticleServiceImplTest {

    @Mock
    private ArticleRepository articleRepository;

    @Mock
    private EditorRepository editorRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private ArticleCategoryCompositeRepository compositeRepository;

    @InjectMocks
    private ArticleServiceImpl articleService;

    private Article article;
    private String articleTitle = "Warning: this is a warning";
    private String articleContent = "If you are reading this, you can read";

    private Editor editor;
    private String editorName = "Pacil";
    private String editorEmail = "pacil@pacil.com";
    private int editorWrittenArticles = 0;

    private Category category;
    String categoryName = "Action";
    int categoryNumArticles = 0;

    @BeforeEach
    public void setUp() {
        editor = new Editor(editorName, editorEmail, editorWrittenArticles);
        article = new Article(editor, articleTitle, articleContent);
        category = new Category(categoryName, categoryNumArticles);
    }

    @Test
    public void testGetListArticle() {
        List<Article> articleList = articleRepository.findAll();
        when(articleService.getListArticle()).thenReturn(articleList);
        assertIterableEquals(articleList, articleService.getListArticle());
    }

    @Test
    public void testGetListArticleByEditor() {
        when(editorRepository.existsById(editor.getId())).thenReturn(true);
        List<Article> articles = List.of(article);
        when(articleRepository.findByEditorId(editor.getId())).thenReturn(articles);

        assertEquals(articles, articleService.getListArticleByEditor(editor.getId()));
    }

    @Test
    public void testGetListArticleByNonExistentEditor() {
        when(editorRepository.existsById(editor.getId())).thenReturn(false);

        assertNull(articleService.getListArticleByEditor(editor.getId()));
    }

    @Test
    public void testCreateArticle() {
        when(editorRepository.existsById(editor.getId())).thenReturn(true);
        when(editorRepository.findById(editor.getId())).thenReturn(editor);

        articleService.createArticle(editor.getId(), article);

        assertEquals(1, editor.getWrittenArticles());
        assertEquals(editor, article.getEditor());
        assertNotNull(article.getCreated_at());
        verify(articleRepository).save(article);
    }

    @Test
    public void testCreateArticleByNonExistentEditor() {
        when(editorRepository.existsById(editor.getId())).thenReturn(false);

        assertNull(articleService.createArticle(editor.getId(), article));
    }

    @Test
    public void testGetArticleById() {
        when(articleRepository.findById(article.getId())).thenReturn(article);

        assertEquals(article, articleService.getArticleById(article.getId()));
    }

    @Test
    public void testUpdateArticle() {
        when(editorRepository.existsById(editor.getId())).thenReturn(true);
        when(editorRepository.findById(editor.getId())).thenReturn(editor);
        articleService.createArticle(editor.getId(), article);
        article.setLast_updated_at(new Date());
        String prevTitle = article.getTitle();
        String prevContent = article.getContent();
        Date prevUpdated = article.getLast_updated_at();

        article.setTitle("New Title");
        article.setContent("New Content");

        when(articleService.getArticleById(article.getId())).thenReturn(article);
        Article updatedArticle = articleService.updateArticle(article.getId(), article);

        assertEquals(article.getId(), updatedArticle.getId());
        assertNotEquals(prevTitle, updatedArticle.getTitle());
        assertNotEquals(prevContent, updatedArticle.getContent());
        verify(articleRepository, times(2)).save(article);
    }

    @Test
    public void testDeleteArticleById() {
        when(articleService.getArticleById(article.getId())).thenReturn(article);

        articleService.deleteArticleById(article.getId());

        verify(articleRepository).delete(article);
        verify(compositeRepository).deleteAllByArticleId(article.getId());
    }

    @Test
    public void testAddCategory() {
        when(articleRepository.existsById(article.getId())).thenReturn(true);
        when(articleRepository.findById(article.getId())).thenReturn(article);

        category.setSubcategory(false);
        when(categoryRepository.existsById(category.getId())).thenReturn(true);
        when(categoryRepository.findById(category.getId())).thenReturn(category);

        ArgumentCaptor<ArticleCategoryComposite> compositeArg = ArgumentCaptor.forClass(ArticleCategoryComposite.class);

        Category returnedCategory = articleService.addCategory(article.getId(), category);

        assertEquals(1, category.getNumArticles());
        assertEquals(category, returnedCategory);
        verify(compositeRepository).save(compositeArg.capture());
    }

    @Test
    public void testAddCategoryNonExistentArticle() {
        lenient().when(articleRepository.existsById(article.getId())).thenReturn(false);

        assertNull(articleService.addCategory(article.getId(), category));
    }

    @Test
    public void testAddCategoryNonExistentCategory() {
        lenient().when(categoryRepository.existsById(category.getId())).thenReturn(false);

        assertNull(articleService.addCategory(article.getId(), category));
    }

    @Test
    public void testAddSubcategory() {
        when(articleRepository.existsById(article.getId())).thenReturn(true);
        when(articleRepository.findById(article.getId())).thenReturn(article);

        Category subcategory = new Category("sub", 0);
        subcategory.setSubcategory(true);
        subcategory.setParentCategory(category);
        subcategory.setId(100);
        when(categoryRepository.existsById(subcategory.getId())).thenReturn(true);
        when(categoryRepository.findById(subcategory.getId())).thenReturn(subcategory);
        when(compositeRepository.existsByArticleIdAndCategoryId(article.getId(), category.getId())).thenReturn(false);
        when(categoryRepository.findById(category.getId())).thenReturn(category);



        ArgumentCaptor<ArticleCategoryComposite> compositeArg = ArgumentCaptor.forClass(ArticleCategoryComposite.class);

        Category returnedCategory = articleService.addCategory(article.getId(), subcategory);

        assertEquals(1, subcategory.getNumArticles());
        assertEquals(1, category.getNumArticles());
        assertEquals(subcategory, returnedCategory);
        verify(compositeRepository, times(2)).save(compositeArg.capture());
    }

    @Test
    public void testGetArticleCategories() {
        when(articleRepository.existsById(article.getId())).thenReturn(true);

        ArticleCategoryComposite composite1 = new ArticleCategoryComposite(article.getId(), 1);
        ArticleCategoryComposite composite2 = new ArticleCategoryComposite(article.getId(), 2);
        List<ArticleCategoryComposite> composites = List.of(composite1, composite2);
        when(compositeRepository.findByArticleId(category.getId())).thenReturn(composites);

        List<Integer> ids = List.of(1, 2);
        Category category1 = new Category();
        Category category2 = new Category();
        List<Category> categories = List.of(category1, category2);
        when(categoryRepository.findAllById(ids)).thenReturn(categories);

        assertEquals(categories, articleService.getArticleCategories(article.getId()));
    }

    @Test
    public void testRemoveCategory() {
        Category subcategory1 = new Category();
        subcategory1.setSubcategory(true);
        subcategory1.setParentCategory(category);
        Category subcategory2 = new Category();
        subcategory2.setSubcategory(true);
        subcategory2.setParentCategory(category);
        List<Category> subcategories = List.of(subcategory1, subcategory2);

        when(categoryRepository.existsById(category.getId())).thenReturn(true);
        when(categoryRepository.findById(category.getId())).thenReturn(category);
        when(categoryRepository.findAllByParentCategory(category)).thenReturn(subcategories);

        articleService.removeCategory(article.getId(), category);

        ArgumentCaptor<Integer> intArg = ArgumentCaptor.forClass(Integer.class);
        verify(compositeRepository, times(3))
                .deleteByArticleIdAndCategoryId(eq(article.getId()), intArg.capture());
    }


}
