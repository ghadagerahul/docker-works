package com.springboot.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.entity.UserEntity;
import com.springboot.app.service.AppService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/app")
public class SpringBootController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private AppService appService;

	@GetMapping("/test")
	public String getRequest() {
		String str = """
				=======================================================
				              Welcome To Docker Tutorial
				=======================================================
				Api Is Returning Response for Spring Boot with Docker.
				""";
		logger.info(str);
		return str;
	}

	@PostMapping("/register")
	public ResponseEntity<UserEntity> saveEntity(@RequestBody UserEntity entity) {
		logger.info("saveEntity-entity: " + entity);
		UserEntity saveData = appService.saveData(entity);
		return ResponseEntity.ok(saveData);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<UserEntity> getEntity(@PathVariable Long id) {
		logger.info("getEntity-id: {}", id);
		UserEntity dataById = appService.getDataById(id);

		if (dataById != null) {
			return ResponseEntity.ok(dataById);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/get")
	public ResponseEntity<List<UserEntity>> getAllEntity() {
		logger.info(" ------------- getAllEntity ------------");
		List<UserEntity> dataById = appService.getData();
		if (dataById != null) {
			return ResponseEntity.ok(dataById);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
