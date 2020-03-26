package com.example.ITBook.common.domain;

import com.example.ITBook.common.enums.Authority;
import com.example.ITBook.common.enums.Grade;
import com.example.ITBook.common.enums.SocialType;
import com.example.ITBook.common.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * 회원 테이블
 * */

@Builder
@Entity
@Table(name = "user")
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    private Long userNo;
    
    @Column(name = "identity",length = 255)
    private String identity;
    @Column(name = "name",length = 50)
    private String name;
    @JsonIgnore
    @Column(name = "password",length = 255)
    private String password;
    @Column(name = "email",length = 255)
    private String email;

    @Column(name = "created_date",nullable = true)
    private LocalDateTime createdDate;
    @Column(name = "updated_date",nullable = true)
    private LocalDateTime updatedDate;

    // OAuth
    @Column(name = "principal",length = 255,nullable = true)
    private String principal;

    @Column(name = "social_type")
    private SocialType socialType;

    // Batch
    @Column(name = "status")
    private UserStatus status; // 추가
    @Column(name = "grade")
    private Grade grade; // 추가
    
    @Column(name = "phone",length = 255)
    private String phone;
    @Column(name = "address_1",length = 50)
    private String address1;
    @Column(name = "address_2",length = 255)
    private String address2;
    @Column(name = "address_3",length = 255)
    private String address3;
    
    @Column(name = "mileage",length = 7,nullable = true)
    private int mileage;

    public void setCreatedDate() {
        this.createdDate = LocalDateTime.now();
    }

    public void setUpdatedDate() {
        this.updatedDate = LocalDateTime.now();
    }

    public User setInactive(){
        this.status = UserStatus.INACTIVE;
        return this;
    }


}
