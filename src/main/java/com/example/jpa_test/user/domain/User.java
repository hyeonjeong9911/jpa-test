package com.example.jpa_test.user.domain;

import com.example.jpa_test.store.domain.Store;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "USERS",
        indexes = {
                @Index(columnList ="email"),
                @Index(columnList = "username")
        }
)

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id @Column(name = "USERID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(length = 10, nullable = false)
    private String username; // 사장님 이름
    @OneToMany(mappedBy = "user")
    private List<Store> stores;
}
