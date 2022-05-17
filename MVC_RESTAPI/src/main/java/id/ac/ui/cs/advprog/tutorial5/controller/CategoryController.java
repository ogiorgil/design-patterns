package id.ac.ui.cs.advprog.tutorial5.controller;

import id.ac.ui.cs.advprog.tutorial5.model.Article;
import id.ac.ui.cs.advprog.tutorial5.model.Category;
import id.ac.ui.cs.advprog.tutorial5.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping(produces = {"application/json"})
    @ResponseBody
    public ResponseEntity postCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @PostMapping("/{id}/sub")
    @ResponseBody
    public ResponseEntity postSubCategory(@PathVariable(value = "id") int id, @RequestBody Category category) {
        category = categoryService.createSubcategory(id, category);
        if (category == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(category);
    }

    @GetMapping(produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Iterable<Category>> getListCategory() {
        return ResponseEntity.ok(categoryService.getListCategory());
    }
    @GetMapping(path = "/{id}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity getCategory(@PathVariable(value = "id") int id) {
        Category category = categoryService.getCategoryById(id);
        if (category == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(category);
    }

    @PutMapping(path = "/{id}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity updateCategory(@PathVariable(value = "id") int id, @RequestBody Category category) {
        return ResponseEntity.ok(categoryService.updateCategory(id, category));
    }

    @DeleteMapping(path = "/{id}", produces = {"application/json"})
    public ResponseEntity deleteCategory(@PathVariable(value = "id") int id) {
        categoryService.deleteCategoryById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/{id}/articles", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Iterable<Article>> getArticles(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(categoryService.getCategoryArticles(id));
    }
}
