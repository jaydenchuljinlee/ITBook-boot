package com.example.ITBook.common.domain;

import com.example.ITBook.common.enums.Authority;
import com.example.ITBook.common.enums.Grade;
import com.example.ITBook.common.enums.SocialType;
import com.example.ITBook.common.enums.UserStatus;
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
@Setter @Getter @AllArgsConstructor
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

    public User setInactive(){
        this.status = UserStatus.INACTIVE;
        return this;
    }

    public User(Long userNo) {
    	this.userNo = userNo;
    }

    public User(String identity, String password) {
    	this.identity 	= identity;
    	this.password	= password;
    }

    public User(String identity, String name, String email,SocialType socialType) {
    	this.identity = identity;
        this.name = name;
        this.password = "non";
        this.email = email;
        this.principal = "1";
        this.socialType = socialType;
        this.phone = "non";
        this.address1 = "non";
        this.address2 = "non";
        this.address3 = "non";
        this.mileage = 0;
    }

    public User( String name, String password, String email,String phone
    		, String address1, String address2, String address3) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.principal = "1";
        this.socialType = SocialType.DEFAULT;
        this.phone = phone;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.mileage = 0;
    }

}
