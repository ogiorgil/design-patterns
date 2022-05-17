package id.ac.ui.cs.advprog.tutorial5.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ArticleCategoryComposite")
@Data
@NoArgsConstructor
public class ArticleCategoryComposite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name = "article_id")
    private int articleId;

    @Column(name = "category_id")
    private int categoryId;

    public ArticleCategoryComposite(int articleId, int categoryId) {
        this.articleId = articleId;
        this.categoryId = categoryId;
    }
}
