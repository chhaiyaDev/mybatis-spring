package com.bbc.mybatisspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbc.mybatisspringboot.mapper.RoleMapper;
import com.bbc.mybatisspringboot.model.Role;

@Service
public class RoleService {

	final private RoleMapper roleMapper;
	
	@Autowired
	public RoleService (RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}
	
	public List<Role> getRoles(){
		return roleMapper.getRoles();
	}
}
