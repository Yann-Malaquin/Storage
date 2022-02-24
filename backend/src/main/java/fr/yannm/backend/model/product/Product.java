package fr.yannm.backend.model.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.yannm.backend.model.storage.Storage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int quantity;

    private String slug;

    @ManyToOne
    @JoinColumn(name = "storage_id")
    @JsonIgnoreProperties("productList")
    private Storage storage;



}
