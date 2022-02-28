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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String slug;

    @OneToMany(mappedBy = "storage", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("storage")
    private List<Product> productList;

    public Storage(String name) {
        super();
        this.name = name;
        this.slug = Slug.makeSlug(this.name);
        this.productList = new ArrayList<>();
    }
}
