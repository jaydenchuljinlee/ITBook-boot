package com.example.ITBook.common.enums;

import lombok.Getter;

@Getter
public enum Authority {

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
	
}
