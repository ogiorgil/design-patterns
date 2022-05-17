package id.ac.ui.cs.advprog.tutorial5.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Category")
@Data
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name = "category_name")
    private String name;

    @Column(name = "num_articles")
    private int numArticles;

    @Column(name = "is_subcategory")
    private boolean isSubcategory;

    @ManyToOne
//    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "category_id")
//    @JsonBackReference
    private Category parentCategory;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentCategory")
//    @JsonManagedReference
//    private Set<Category> subCategories;

//    @ManyToMany(mappedBy = "categories")
//    @JsonIgnore
    // reference: https://www.baeldung.com/jpa-many-to-many
//    private Set<ArticleCategories> articleCategories = new HashSet<>();

    public Category(String name, int numArticles){
        this.name = name;
        this.numArticles = numArticles;
    }

}
