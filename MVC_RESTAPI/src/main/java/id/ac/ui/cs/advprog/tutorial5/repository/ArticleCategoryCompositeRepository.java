package id.ac.ui.cs.advprog.tutorial5.repository;

import id.ac.ui.cs.advprog.tutorial5.model.ArticleCategoryComposite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleCategoryCompositeRepository extends JpaRepository<ArticleCategoryComposite, Integer> {
    List<ArticleCategoryComposite> findByArticleId(int articleId);
    List<ArticleCategoryComposite> findByCategoryId(int categoryId);
    void deleteAllByArticleId(int articleId);
    void deleteAllByCategoryId(int categoryId);
    void deleteByArticleIdAndCategoryId(int articleId, int categoryId);
    boolean existsByArticleIdAndCategoryId(int articleId, int categoryId);
}
