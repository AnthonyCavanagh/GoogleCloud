package com.lumar.googlecloud.service.model;

import java.util.List;

public class AllFieldsForParentsRequest {
	
	private long subTypeId;
	private List <Long> parentTypeIds;
	public long getSubTypeId() {
		return subTypeId;
	}
	public void setSubTypeId(long subTypeId) {
		this.subTypeId = subTypeId;
	}
	public List<Long> getParentTypeIds() {
		return parentTypeIds;
	}
	public void setParentTypeIds(List<Long> parentTypeIds) {
		this.parentTypeIds = parentTypeIds;
	}
}
