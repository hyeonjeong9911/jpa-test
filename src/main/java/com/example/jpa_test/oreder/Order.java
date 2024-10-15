package com.example.jpa_test.oreder;

import com.example.jpa_test.store.domain.Store;
import com.example.jpa_test.user.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ORDERS", indexes = {@Index(columnList = "productName")})
public class Order {
    @Id
    @Column(name = "ORDER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long price;

    @Column(name = "PRODUCT_NAME")
    private String product_name;

    @ManyToOne
    @JoinColumn(name = "STORE_ID")
    private Store store;
}
