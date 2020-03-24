package com.example.ITBook.common.enums;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@Getter
public enum Authority implements GrantedAuthority {

	USER("user"),
	ADMIN("admin");
	
	private String name;
	private static final String ROLE_PREFIX = "ROLE_";
	
	Authority(String name) {
		this.name = name;
	}
	
	public String getRoleType() {
		return ROLE_PREFIX + name.toUpperCase();
	}
	
	public boolean isEquals(String authority) {
		
		return this.name.equals(authority);
	};

	@Override
	public String getAuthority() {
		return this.getRoleType();
	}


}
