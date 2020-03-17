package com.example.ITBook.common.domain;

import com.example.ITBook.common.enums.SocialType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Entity
@Setter @Getter 
@NoArgsConstructor
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "name",length = 50)
    private String name;
    @Column(name = "password",length = 255)
    private String password;
    @Column(name = "email",length = 255)
    private String email;

    @Column(name = "createddate")
    private LocalDateTime createdDate;
    @Column(name = "updateddate")
    private LocalDateTime updatedDate;

    // OAuth
    @Column(name = "principal",length = 255)
    private String principal;
    @Column(name = "socialtype")
    private SocialType socialType;
    
    @Column(name = "phone",length = 255)
    private String phone;
    @Column(name = "address_1",length = 50)
    private String address1;
    @Column(name = "address_2",length = 255)
    private String address2;
    @Column(name = "address_3",length = 255)
    private String address3;
    
    @Column(name = "mileage",length = 7)
    private int mileage;

    public User(Long index) {
    	this.idx = index;
    }
    
    public User(String email, String password) {
    	this.email 		= email;
    	this.password	= password;
    }
    
    public User(Long index, String name, String password, String email, LocalDateTime createdDate
    		, LocalDateTime updatedDate, String principal, SocialType socialType,String phone
    		, String address1, String address2, String address3,int mileage) {
        this.idx = index;
        this.name = name;
        this.password = password;
        this.email = email;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.principal = principal;
        this.socialType = socialType;
        this.phone = phone;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.mileage = mileage;
    }
}
