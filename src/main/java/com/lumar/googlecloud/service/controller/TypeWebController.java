package com.lumar.googlecloud.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lumar.googlecloud.service.datastore.DataStoreService;
import com.lumar.googlecloud.service.model.CreateTypeTemplate;
import com.lumar.googlecloud.service.model.Fields;
import com.lumar.googlecloud.service.model.FieldsByTypesRequests;
import com.lumar.googlecloud.service.model.Type;
import com.lumar.googlecloud.service.model.TypeRequest;

import org.springframework.http.HttpStatus;

@RestController
public class TypeWebController {
	
private static final Logger logger = LoggerFactory.getLogger(TypeWebController.class);

	@Autowired
    private DataStoreService dataStoreService;
	@RequestMapping("/home")
    public String home() {
            return "running Latest Type service on google cloud";
    }
	
	@RequestMapping(value = "/createType", method = RequestMethod.POST)
	public ResponseEntity<Void> createType(@RequestBody CreateTypeTemplate template){
		logger.info("Creating Template for "+template.toString());
		dataStoreService.createTypeTemplate(template.getType(), template.getParentId());
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/findType", method = RequestMethod.POST)
	public ResponseEntity<Type> findTypeTemplate(@RequestBody TypeRequest request){
		logger.info("Find Type "+request.getId());
		Type type = dataStoreService.findTypeTemplate(request.getId());
		logger.info("Return Type "+type.toString());
		return new ResponseEntity<Type>(type, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/createFields", method = RequestMethod.POST)
	public ResponseEntity<Void> createField(@RequestBody Fields fields){
		logger.info("Creating Template for "+fields.toString());
		dataStoreService.modifyFieldEntity(fields);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/findFields", method = RequestMethod.POST)
	public ResponseEntity<Fields> findFields(@RequestBody TypeRequest request){
		logger.info("Find fields  for Type "+request.getId());
		Fields fields = dataStoreService.findFields(request.getId());
		return new ResponseEntity<Fields>(fields, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findFieldsAncestors", method = RequestMethod.POST)
	public ResponseEntity<Fields> findFields(@RequestBody FieldsByTypesRequests request){
		logger.info("Find fields  for Type "+request.toString());
		Fields fields = dataStoreService.findFields(request);
		return new ResponseEntity<Fields>(fields, HttpStatus.OK);
	}

	
	
}
