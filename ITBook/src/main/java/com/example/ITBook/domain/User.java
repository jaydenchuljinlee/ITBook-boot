package com.example.ITBook.domain;

import com.example.ITBook.enums.SocialType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long index;

    private String name;
    private String password;
    private String email;

    @Column(name = "createddate")
    private LocalDateTime createdDate;
    @Column(name = "updateddate")
    private LocalDateTime updatedDate;

    // OAuth
    private String principal;
    @Column(name = "socialtype")
    private SocialType socialType;

    @Builder
    public User(Long index, String name, String password, String email, LocalDateTime createdDate, LocalDateTime updatedDate, String principal, SocialType socialType) {
        this.index = index;
        this.name = name;
        this.password = password;
        this.email = email;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.principal = principal;
        this.socialType = socialType;
    }
}
