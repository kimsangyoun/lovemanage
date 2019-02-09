package com.lovemanager.lmservice.Service;

import java.util.List;

import com.lovemanager.lmservice.Dto.UserDto;

public interface CoupleService {
	public int insertRequest(UserDto user);
	public UserDto findCouple(UserDto user);
}
