package com.lumar.googlecloud.service.datastore;

import java.util.List;

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

import com.lumar.googlecloud.service.entity.FieldsEntity;




public interface FieldsDataStore extends DatastoreRepository<FieldsEntity,Long> {

}
