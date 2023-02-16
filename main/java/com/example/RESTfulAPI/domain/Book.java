package com.example.RESTfulAPI.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "TB_Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column(name = "Names")
    private String name;
@Column(name = "Values")
    private BigDecimal price;

@Column(name = "Dates")
    private String date;
}
