package id.ac.ui.cs.advprog.tutorial5.repository;

import id.ac.ui.cs.advprog.tutorial5.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    List<Article> findByEditorId(int editorId);
    Article findById(int id);
}
