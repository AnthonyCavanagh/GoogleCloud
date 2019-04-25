package com.lumar.googlecloud.service.entity;


import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;


@Entity (name = "fields")
public class FieldsEntity {
	
	@Id
	private Long typeId;
	private List <Long>fieldIds = new ArrayList<Long>();
	public FieldsEntity(Long typeId, List<Long> fieldIds) {
		super();
		this.typeId = typeId;
		this.fieldIds = fieldIds;
	}
	public Long getTypeId() {
		return typeId;
	}
	public List<Long> getFieldIds() {
		return fieldIds;
	}
}
