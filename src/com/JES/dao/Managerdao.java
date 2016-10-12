package com.JES.dao;

import org.springframework.transaction.annotation.Transactional;

import com.JES.model.Manager;

@Transactional
public interface Managerdao {
	private String getMname(Manager manager);
	private String getPassword(Manager manager);
}
