package com.ciandt.fullstack.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME")
    private String name;

    @Column(name = "PRECO_VENDA")
    private Double salePrice;

    @Column(name = "PRECO_COMPRA")
    private Double purchasePrice;

    @Column(name = "LUCRO")
    private Double gain;

    @Column(name = "QTD_ESTOQUE")
    private Integer quantityInStock;

    @Column(name = "QTD_ADICIONADA")
    private Integer addedAmount;

    @Column(name = "FORNECEDOR")
    private String provider;

}
