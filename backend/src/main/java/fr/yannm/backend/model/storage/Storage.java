package fr.yannm.backend.model.storage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.yannm.backend.model.product.Product;
import fr.yannm.backend.utility.Slug;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yann
 * @version 1.0
 * @name : Storage
 * @created 24/02/2022 - 14:04
 * @project backend
 * @copyright Yann
 **/
@Entity
@Table(name = "storages")
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String slug;

    @OneToMany(mappedBy = "storage", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("storage")
    @Getter
    @Setter
    private List<Product> productList;

    public Storage(String name) {
        super();
        this.name = name;
        this.slug = Slug.makeSlug(this.name);
        this.productList = new ArrayList<>();
    }
}
