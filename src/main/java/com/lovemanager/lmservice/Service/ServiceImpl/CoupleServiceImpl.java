package com.lovemanager.lmservice.Service.ServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lovemanager.lmservice.Dao.MemberDao;
import com.lovemanager.lmservice.Dto.RoleDto;
import com.lovemanager.lmservice.Dto.UserDto;
import com.lovemanager.lmservice.Exception.UserInvalidException;
import com.lovemanager.lmservice.Service.CoupleService;
import com.lovemanager.lmservice.Service.MemberService;

@Service
public class CoupleServiceImpl implements CoupleService{

	@Autowired
	MemberDao memberDAO;

	@Override
	public int insertRequest(UserDto user) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public UserDto findCouple(UserDto user) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
