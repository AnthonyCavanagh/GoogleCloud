package com.lumar.googlecloud.service.model;

public class CreateTypeTemplate {
	
	private Long parentId;
	private Type type;

	
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "CreateTypeTemplate [parentId=" + parentId + ", type=" + type + "]";
	}
}
