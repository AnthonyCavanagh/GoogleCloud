package com.lumar.googlecloud.service.datastore;

import java.util.List;

import com.lumar.googlecloud.service.model.Fields;
import com.lumar.googlecloud.service.model.FieldsByTypesRequests;
import com.lumar.googlecloud.service.model.Type;

public interface DataStoreService {
	
	public void createTypeTemplate(Type template, long parentId);
	public void updateTypeTemplate(Type template);
	public Type findTypeTemplate(Long typeId);
	public void removeTypeTemplate(Long typeId);
	
	public Fields findFields(Long typeId);
	public void removeFields(Long typeId);
	void modifyFieldEntity(Fields fields);
	public Fields findFields(FieldsByTypesRequests request);

}
