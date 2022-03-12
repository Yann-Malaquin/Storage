package fr.yannm.backend.model.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Yann
 * @version 1.0
 * @name : CreateStorage
 * @created 28/02/2022 - 13:40
 * @project backend
 * @copyright Yann
 **/
@NoArgsConstructor
@AllArgsConstructor
public class CreateProduct {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int quantity;

    @Getter
    @Setter
    private Long storageId;

}
