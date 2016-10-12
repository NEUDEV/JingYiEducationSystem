package com.JES.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.JES.model.Manager;

@Transactional
public interface Managerdao {
	public void save(Manager manager);
	public void delete(Manager manager);
	public List findByMname(Manager manager);
	public String getMname(Manager manager);
	public String getPassword(Manager manager);
}
