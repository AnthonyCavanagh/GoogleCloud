package com.lumar.googlecloud.service.datastore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lumar.googlecloud.service.entity.FieldEntity;
import com.lumar.googlecloud.service.entity.FieldsEntity;
import com.lumar.googlecloud.service.entity.TypeTemplate;
import com.lumar.googlecloud.service.model.Field;
import com.lumar.googlecloud.service.model.Fields;
import com.lumar.googlecloud.service.model.FieldsByTypesRequests;
import com.lumar.googlecloud.service.model.Type;

@Service
public class DataStoreServiceImpl implements DataStoreService {

	@Autowired
	private TypeDataStore typeStore;

	@Autowired
	private FieldsDataStore fieldsStore;
	
	@Autowired
	private FieldDataStore fieldStore;
	
	

	private static final Logger logger = LoggerFactory.getLogger(DataStoreServiceImpl.class);

	@Override
	public void createTypeTemplate(Type type, long parentId) {
		logger.info("Creating for " + type.toString());
		TypeTemplate template = new TypeTemplate(type.getId(), type.getName(), type.getParentId());
		try {
			Optional<TypeTemplate> parentTemplate = typeStore.findById(parentId);
			if (parentTemplate != null) {
				template.getParentId().addAll(parentTemplate.get().getParentId());
				template.getParentId().add(parentId);
			}
		} catch (NoSuchElementException e) {
			logger.info("No   parent " + parentId);
		}
		logger.info("Saving enity " + template.toString());
		typeStore.save(template);
	}

	@Override
	public void updateTypeTemplate(Type template) {
		// TODO Auto-generated method stub

	}

	@Override
	public Type findTypeTemplate(Long typeId) {
		logger.info("Search typestore for  type " + typeId);
		Optional<TypeTemplate> template = typeStore.findById(typeId);
		Type type = new Type();
		try {
			if (template != null) {
				TypeTemplate temp = template.get();
				type.setId(temp.getId());
				type.setName(temp.getName());
				type.setParentId(temp.getParentId());
			}
		} catch (NoSuchElementException e) {
			logger.info("No type for " + typeId);
		}
		logger.info("Returning  " + type.toString());
		return type;
	}

	@Override
	public void removeTypeTemplate(Long typeId) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void modifyFieldEntity(Fields fields) {
		logger.info("Creating for " + fields.toString());
		List<Long> fieldIds = new ArrayList<Long>();
		FieldsEntity fEntity = new FieldsEntity(fields.getTypeId(), fieldIds);
		try {
			fEntity = fieldsStore.findById(fields.getTypeId()).get();
		} catch (NoSuchElementException e) {
			logger.info("No type for " + fields.getTypeId());
		}
		for(Field field : fields.getFields()){
			fieldIds.add(field.getId());
			FieldEntity entity = mapFieldEntity(field);
			fieldStore.save(entity);
		}
		fEntity.getFieldIds().addAll(fieldIds);
		fieldsStore.save(fEntity);
	}

	

	@Override
	public Fields findFields(FieldsByTypesRequests request) {
		logger.info("Finding fields for " + request.toString());
		// The very first id is the subChild all the rest are parents.
		Fields fields = new Fields();
		List<Long> typeIds = request.getTypeIds();
		typeIds.add(request.getSubTypeId());
		try {
			List <Long> fieldIds = new ArrayList<Long> ();
			
			 Iterable<FieldsEntity> fEnties = fieldsStore.findAllById(typeIds);
			 for(FieldsEntity entity :fEnties){
				 fieldIds.addAll(entity.getFieldIds());
			 }
			List<FieldEntity> entities = (List<FieldEntity>) fieldStore.findAllById(fieldIds);
			List<Field> fList = entities.stream().filter(Objects::nonNull).map(f->mapField(f)).collect(Collectors.toList());
		    fields.setFields(fList);
		    fields.setTypeId(request.getSubTypeId());
		} catch (NoSuchElementException e) {
			logger.info("No fields  for " + request.getSubTypeId());
		}
		return fields;
	}
	
	@Override
	public Fields  findFields(Long typeId) {
		logger.info("Finding fields for " + typeId);
		Fields fields = new Fields();
		try {
			Optional<FieldsEntity> fEntity = fieldsStore.findById(typeId);
			FieldsEntity fieldsEntity = fEntity.get();
			Iterable<Long> fieldIds = (Iterable)fieldsEntity.getFieldIds();
			List<FieldEntity> entities = (List<FieldEntity>) fieldStore.findAllById(fieldIds);
			List<Field> fList = entities.stream().filter(Objects::nonNull).map(f->mapField(f)).collect(Collectors.toList());
		    fields.setFields(fList);
		    fields.setTypeId(typeId);
		} catch (NoSuchElementException e) {
			logger.info("No fields  for " + typeId);
		}
		return fields;
	}
	
	private Field mapField(FieldEntity entity){
		Field field = new Field();
		field.setId(entity.getId());
		field.setName(entity.getName());
		field.setOptions(entity.getOptions());
		field.setPrimitive(entity.getPrimitive());
		return field;
	}
	
	private FieldEntity mapFieldEntity(Field field){
		FieldEntity entity = new FieldEntity(field.getId(), field.getName(), field.getOptions(), field.getPrimitive());
		return entity;
	}

	@Override
	public void removeFields(Long typeId) {
		// TODO Auto-generated method stub

	}

	

}
