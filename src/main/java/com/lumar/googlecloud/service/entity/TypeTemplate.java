package com.lumar.googlecloud.service.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Entity (name = "types")
public class TypeTemplate {
	
	@Id
	private Long id;
	private String name;
	private List <Long>parentId = new ArrayList<Long>();
	
	public TypeTemplate(Long id, String name, List<Long> parentId) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
	}

	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Long> getParentId() {
		return parentId;
	}

	@Override
	public String toString() {
		return "TypeTemplate [id=" + id + ", name=" + name + ", parentId=" + parentId + "]";
	}
}
