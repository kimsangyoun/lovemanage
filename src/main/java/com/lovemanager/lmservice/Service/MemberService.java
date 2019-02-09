package com.lovemanager.lmservice.Service;

import java.util.List;

import com.lovemanager.lmservice.Dto.UserDto;

public interface MemberService {
	public int insertUser(UserDto user);
	public int deleteUser(UserDto user);
	public int insertBasicRole(UserDto user);
	public int insertRequest(UserDto user);
	public UserDto findMemberbyCouple(UserDto user);
	public List<UserDto> findRequestUser(UserDto user);
}
