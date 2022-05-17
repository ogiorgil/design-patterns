package id.ac.ui.cs.advprog.tutorial5.controller;

import id.ac.ui.cs.advprog.tutorial5.model.Article;
import id.ac.ui.cs.advprog.tutorial5.model.Category;
import id.ac.ui.cs.advprog.tutorial5.model.Editor;
import id.ac.ui.cs.advprog.tutorial5.service.ArticleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = ArticleController.class)
public class ArticleControllerTest {

    private final Editor editor = new Editor("editorName", "editorEmail", 0);
    private final String title = "Warning: this is a warning";
    private final String content = "If you are reading this, you can read.";
    private final String categoryName = "Action";
    private final int categoryNumArticles = 0;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ArticleService articleService;
    private Article article;
    private Category category;

    @BeforeEach
    public void setUp() {
        article = new Article(editor, title, content);
        category = new Category(categoryName, categoryNumArticles);
    }

    @Test
    public void testPostArticle() throws Exception {
        when(articleService.createArticle(1, article)).thenReturn(article);

        mockMvc.perform(post("/editor/1/articles")
                        .contentType(MediaType.APPLICATION_JSON).content(Mapper.mapToJson(article)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.editor").value(editor))
                .andExpect(jsonPath("$.title").value(title))
                .andExpect(jsonPath("$.content").value(content));
    }

    @Test
    public void testGetArticleByEditor() throws Exception {
        Iterable<Article> articlesList = List.of(article);
        when(articleService.getListArticleByEditor(1)).thenReturn(articlesList);

        mockMvc.perform(get("/editor/1/articles").contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].editor").value(editor))
                .andExpect(jsonPath("$[0].title").value(title))
                .andExpect(jsonPath("$[0].content").value(content));
    }

    @Test
    public void testGetArticleByNonExistentEditor() throws Exception {
        when(articleService.getListArticleByEditor(100)).thenReturn(null);

        mockMvc.perform(get("/editor/100/articles").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetListArticle() throws Exception {
        List<Article> articlesList = List.of(article);
        when(articleService.getListArticle()).thenReturn(articlesList);

        mockMvc.perform(get("/article").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].editor").value(editor))
                .andExpect(jsonPath("$[0].title").value(title))
                .andExpect(jsonPath("$[0].content").value(content));
    }

    @Test
    public void testGetArticle() throws Exception {
        when(articleService.getArticleById(1)).thenReturn(article);

        mockMvc.perform(get("/article/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.editor").value(editor))
                .andExpect(jsonPath("$.title").value(title))
                .andExpect(jsonPath("$.content").value(content));
    }

    @Test
    public void testGetNonExistentArticle() throws Exception {
        mockMvc.perform(get("/article/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdateArticle() throws Exception {
        when(articleService.updateArticle(1, article)).thenReturn(article);

        mockMvc.perform(put("/article/1")
                        .contentType(MediaType.APPLICATION_JSON).content(Mapper.mapToJson(article)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.editor").value(editor))
                .andExpect(jsonPath("$.title").value(title))
                .andExpect(jsonPath("$.content").value(content));
    }

    @Test
    public void testDeleteArticle() throws Exception {
        articleService.createArticle(0, article);

        mockMvc.perform(delete("/article/0").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

    }

    @Test
    public void testAddCategory() throws Exception {
        when(articleService.addCategory(1, category)).thenReturn(category);

        mockMvc.perform(post("/article/1/categories")
                        .contentType(MediaType.APPLICATION_JSON).content(Mapper.mapToJson(category)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(categoryName))
                .andExpect(jsonPath("$.numArticles").value(categoryNumArticles));
    }

    @Test
    public void testGetCategories() throws Exception {
        when(articleService.getArticleCategories(1)).thenReturn(List.of(category));

        mockMvc.perform(get("/article/1/categories").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value(categoryName))
                .andExpect(jsonPath("$[0].numArticles").value(categoryNumArticles));
    }

    @Test
    public void testGetCategoriesNonExistentArticle() throws Exception {
        when(articleService.getArticleCategories(1)).thenReturn(null);

        mockMvc.perform(get("/article/1/categories").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testRemoveCategory() throws Exception {
        mockMvc.perform(delete("/article/1/categories")
                        .contentType(MediaType.APPLICATION_JSON).content(Mapper.mapToJson(category)))
                .andExpect(status().isNoContent());
    }

}
