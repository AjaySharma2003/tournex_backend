package com.tournex.repository;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TournexRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public ArrayList<?> select(String query, Map<String, Object> param) {
		return (ArrayList<?>) jdbcTemplate.queryForList(query, param);
	}

	public int update(String query, Map<String, Object> param) {
		return jdbcTemplate.update(query, param);
	}

	public int[] batchUpdate(String query, Map<String, Object>[] param) {
		return jdbcTemplate.batchUpdate(query, param);
	}
}
