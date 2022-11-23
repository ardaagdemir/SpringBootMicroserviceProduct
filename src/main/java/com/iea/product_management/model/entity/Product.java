package com.iea.product_management.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@SequenceGenerator(name = "PRODUCTS_SEQUENCE", sequenceName = "PRODUCTS_SEQ", initialValue = 1, allocationSize = 1)
@Data
@Table(name = "PRODUCTS")
@Entity
public class Product
{
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTS_SEQUENCE")
    @Column(name = "PRODUCT_ID", nullable = false)
    @Id
    private Integer productID;

    @Column(length = 120, nullable = false)
    private String name;

    private String description;

    @Column(length = 80, nullable = false)
    private String category;

    @Column(nullable = false)
    private Double price;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date created;
}
