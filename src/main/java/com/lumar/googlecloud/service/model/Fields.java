package com.lumar.googlecloud.service.model;

import java.util.ArrayList;
import java.util.List;

public class Fields {
	
	private Long typeId;
	private List <Field> fields = new ArrayList<Field> ();

	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	@Override
	public String toString() {
		return "Fields [id=" + typeId + ", fields=" + fields + "]";
	}
}
