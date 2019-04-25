package com.lumar.googlecloud.service.model;

import java.util.ArrayList;
import java.util.List;

public class FieldsByTypesRequests {

	private long subTypeId;
	private List <Long> typeIds = new ArrayList<Long>();
	
	public long getSubTypeId() {
		return subTypeId;
	}

	public void setSubTypeId(long subTypeId) {
		this.subTypeId = subTypeId;
	}

	public List<Long> getTypeIds() {
		return typeIds;
	}

	@Override
	public String toString() {
		return "FieldsByTypesRequests [subTypeId=" + subTypeId + ", typeIds=" + typeIds + "]";
	}
}

