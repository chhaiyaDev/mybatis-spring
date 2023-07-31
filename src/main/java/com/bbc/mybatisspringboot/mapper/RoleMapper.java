package com.bbc.mybatisspringboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bbc.mybatisspringboot.model.Role;

@Mapper
public interface RoleMapper {

	List<Role> getRoles();
}
