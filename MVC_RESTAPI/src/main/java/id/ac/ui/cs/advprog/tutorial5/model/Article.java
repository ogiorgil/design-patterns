package id.ac.ui.cs.advprog.tutorial5.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Article")
@Data
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    // reference: https://www.bezkoder.com/jpa-one-to-many/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "editor_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Editor editor;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    // reference: https://www.bezkoder.com/jpa-many-to-many/
//    @ManyToMany
//    @JoinTable(name = "article_categories",
//            joinColumns = {@JoinColumn(name = "article_id")},
//            inverseJoinColumns = {@JoinColumn(name = "category_id")})
//    private Set<ArticleCategories> categories = new HashSet<>();

    @CreatedDate
    @Column(name = "created_at")
    private Date created_at;

    @UpdateTimestamp
    @Column(name = "last_updated_at")
    private Date last_updated_at;

    public Article(Editor editor, String title, String content) {
        this.editor = editor;
        this.title = title;
        this.content = content;
    }

//    public void addCategory(Category category) {
//        categories.add(category);
//        category.getArticles().add(this);
//    }
//
//    public void removeCategory(int categoryId) {
//        Category category = categories.stream().
//                filter(c -> c.getId() == categoryId).findFirst().orElse(null);
//        if (category != null) {
//            categories.remove(category);
//            category.getArticles().remove(this);
//        }
//    }
}
