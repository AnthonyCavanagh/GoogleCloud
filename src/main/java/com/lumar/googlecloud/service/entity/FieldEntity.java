package com.lumar.googlecloud.service.entity;

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Entity  (name = "field")
public class FieldEntity {

	@Id
	private Long id;
	private String name;
	private String primitive;
    private String options;
    
	public FieldEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public FieldEntity(Long id, String name, String primitive, String options) {
		super();
		this.id = id;
		this.name = name;
		this.primitive = primitive;
		this.options = options;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPrimitive() {
		return primitive;
	}
	public String getOptions() {
		return options;
	}
	@Override
	public String toString() {
		return "FieldEntity [id=" + id + ", name=" + name + ", primitive=" + primitive + ", options=" + options + "]";
	}
}
