package com.lumar.googlecloud.service.datastore;

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

import com.lumar.googlecloud.service.entity.FieldEntity;

public interface FieldDataStore extends DatastoreRepository <FieldEntity,Long> {

}
