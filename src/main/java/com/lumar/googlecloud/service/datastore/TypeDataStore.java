package com.lumar.googlecloud.service.datastore;

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;
import com.lumar.googlecloud.service.entity.TypeTemplate;

public interface TypeDataStore  extends DatastoreRepository<TypeTemplate,Long>{

}
