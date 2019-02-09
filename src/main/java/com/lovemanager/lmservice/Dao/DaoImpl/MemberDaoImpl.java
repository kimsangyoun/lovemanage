package com.lovemanager.lmservice.Dao.DaoImpl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import com.lovemanager.lmservice.Dao.MemberDao;
import com.lovemanager.lmservice.Dto.UserDto;

@Repository
public class MemberDaoImpl implements MemberDao{
	@Autowired
	@Qualifier("sqlSessionTemplate")
	SqlSessionTemplate session;
	
	@Override
	public UserDto selectMember(String id) {
		UserDto user = session.selectOne("user.selectOneUser", id);
		return user;
	}

	@Override
	public int insertUser(UserDto user) throws DuplicateKeyException{
		int result = -1;
		try {
			 result = session.insert("user.insertUser", user);
		}catch(Exception e) {
			if(e instanceof DuplicateKeyException){
	            throw new DuplicateKeyException(e.toString());
	        } 
	        e.getStackTrace();
		}
		
		return result;
	}

	@Override
	public int insertRole(UserDto user) throws SQLException {
		// TODO Auto-generated method stub
		int result = -1;
		try {
			result = session.insert("user.insertRoleList", user);
		}catch(Exception e) {
	        throw new SQLException(e.toString());
		}
		
		return result;
	}

	@Override
	public int deleteUser(UserDto user) throws SQLException{
		// TODO Auto-generated method stub
		int result = -1;
		try {
			result = session.insert("user.deleteUser", user);
		}catch(Exception e) {
	        System.out.println(e.toString());
	        throw new SQLException(e.toString());
		}
		
		return result;
	}

	@Override
	public UserDto findMemberbyCouple(String id){
		// TODO Auto-generated method stub
		UserDto	user = session.selectOne("user.selectOneUserByCouple", id);
	
		return user;
	}

	@Override
	public List<UserDto> findRequestUser(String id) {
		List<UserDto> userlist =(List) session.selectList("user.selectRequestUser", id);

		return userlist;
	}

	@Override
	public int insertRequest(UserDto user) throws SQLException {
		// TODO Auto-generated method stub
		int result = -1;
		try {
			result = session.insert("user.insertRequestbyUser", user);
		}catch(Exception e) {
	        throw new SQLException(e.toString());
		}
		
		return result;
	}

}
