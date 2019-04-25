package com.lumar.googlecloud.service.model;

import java.util.ArrayList;
import java.util.List;

public class Type {

	private Long id;
	private String name;
	private List <Long>parentId = new ArrayList<Long>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Long> getParentId() {
		return parentId;
	}
	public void setParentId(List<Long> parentId) {
		this.parentId = parentId;
	}
	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name + ", parentId=" + parentId + "]";
	}

	
}
