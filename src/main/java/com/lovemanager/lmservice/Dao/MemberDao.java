package com.lovemanager.lmservice.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lovemanager.lmservice.Dto.UserDto;

public interface MemberDao {
	public UserDto selectMember(String id);
	public int insertUser(UserDto user);
	public int insertRole(UserDto user) throws SQLException;
	public int deleteUser(UserDto user) throws SQLException;
	public int insertRequest(UserDto user) throws SQLException;
	public int updateRequest(UserDto user);
	public int insertCouple(List<UserDto> userlist) throws SQLException;
	public UserDto findMemberbyCouple(String id) ;
	public List<UserDto> findRequestUser(String id);
	public int updateRole(List<UserDto> userlist);
	
	
	
}


