package com.springboot.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.entity.UserEntity;
import com.springboot.app.repo.AppRepository;

@Service
public class AppService {

	@Autowired
	private AppRepository appService;

	public UserEntity saveData(UserEntity entity) {
		return appService.save(entity);

	}

	public List<UserEntity> getData() {
		return appService.findAll();
	}

	public UserEntity getDataById(Long id) {

		Optional<UserEntity> data = appService.findById(id);
		if (null != data && data.isPresent())
			return data.get();
		else
			return null;

	}
}
