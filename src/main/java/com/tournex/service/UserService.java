package com.tournex.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tournex.config.SqlQueriesConfig;
import com.tournex.repository.TournexRepository;

@Service
public class UserService {

	@Autowired
	TournexRepository repository;

	@Autowired
	SqlQueriesConfig sqlQueries;

	public ArrayList<?> getAllUsers() {
		return repository.select(sqlQueries.getUser().getSelect().getAll(), null);
	}

	public ArrayList<?> getUserById(Map<String, Object> request) {
		return repository.select(sqlQueries.getUser().getSelect().getById(), request);
	}

	public int addUser(Map<String, Object> request) {
		ArrayList<?> result = repository.select(sqlQueries.getUser().getSelect().getByEmail(), request);
		if(result.size() > 0) {
			return 2;
		}
		return repository.update(sqlQueries.getUser().getInsert().getNewUser(), request);
	}

	public int updateUser(Map<String, Object> request) {
		return repository.update(sqlQueries.getUser().getUpdate().getUserDetails(), request);
	}

	public int deleteUser(Map<String, Object> request) {
		return repository.update(sqlQueries.getUser().getDelete().getById(), request);
	}
}
