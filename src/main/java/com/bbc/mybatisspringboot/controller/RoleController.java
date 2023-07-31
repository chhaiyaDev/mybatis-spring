package com.bbc.mybatisspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbc.mybatisspringboot.model.Role;
import com.bbc.mybatisspringboot.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

	final private RoleService roleService;
	
	@Autowired
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@GetMapping
	public List<Role> getRoles(){
		return roleService.getRoles();
	}
}
