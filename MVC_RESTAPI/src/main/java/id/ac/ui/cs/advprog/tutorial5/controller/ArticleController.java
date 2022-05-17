package id.ac.ui.cs.advprog.tutorial5.controller;

import id.ac.ui.cs.advprog.tutorial5.model.Article;
import id.ac.ui.cs.advprog.tutorial5.model.Category;
import id.ac.ui.cs.advprog.tutorial5.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping(path = "/editor/{editorId}/articles", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Article> postArticle(@PathVariable(value = "editorId") int editorId, @RequestBody Article article) {
        return ResponseEntity.ok(articleService.createArticle(editorId, article));
    }

    @GetMapping(path = "/editor/{editorId}/articles", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Iterable<Article>> getArticleByEditor(@PathVariable(value = "editorId") int editorId) {
        Iterable<Article> articles = articleService.getListArticleByEditor(editorId);
        if (articles == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(articles);
    }

    @GetMapping(path = "/article", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<List<Article>> getListArticle() {
        List<Article> articles = articleService.getListArticle();
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @GetMapping(path = "/article/{id}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity getArticle(@PathVariable(value = "id") int id) {
        Article article = articleService.getArticleById(id);
        if (article == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(article);
    }

    @PutMapping(path = "/article/{id}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Article> updateArticle(@PathVariable(value = "id") int id, @RequestBody Article article) {
        return ResponseEntity.ok(articleService.updateArticle(id, article));
    }

    @DeleteMapping(path = "/article/{id}", produces = {"application/json"})
    public ResponseEntity deleteArticle(@PathVariable(value = "id") int id) {
        articleService.deleteArticleById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(path = "/article/{id}/categories", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity addCategory(@PathVariable(value = "id") int id, @RequestBody Category categoryRequest) {
        return ResponseEntity.ok(articleService.addCategory(id, categoryRequest));
    }

    @GetMapping(path = "/article/{id}/categories", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Iterable<Category>> getCategories(@PathVariable(value = "id") int id) {
        Iterable<Category> categories = articleService.getArticleCategories(id);
        if (categories == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(articleService.getArticleCategories(id));
    }

    @DeleteMapping(path = "/article/{id}/categories", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity removeCategory(@PathVariable(value = "id") int id, @RequestBody Category categoryRequest) {
        articleService.removeCategory(id, categoryRequest);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}

