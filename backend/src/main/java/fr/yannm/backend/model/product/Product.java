package fr.yannm.backend.model.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.yannm.backend.model.storage.Storage;
import fr.yannm.backend.utility.Slug;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * @author Yann
 * @version 1.0
 * @name : Product
 * @created 24/02/2022 - 14:01
 * @project backend
 * @copyright Yann
 **/
@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

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
    private int quantity;

    @Getter
    @Setter
    private String slug;

    @ManyToOne
    @JoinColumn(name = "storage_id")
    @JsonIgnoreProperties("productList")
    @Getter
    @Setter
    private Storage storage;

    public Product(String name, int quantity, Storage storage) {
        super();
        this.name = name;
        this.quantity = quantity;
        this.slug = Slug.makeSlug(this.name);
        this.storage = storage;
    }

}
