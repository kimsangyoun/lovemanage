package com.lovemanager.lmservice.Dao.DaoImpl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import com.lovemanager.lmservice.Dao.MemberDao;
import com.lovemanager.lmservice.Dto.RoleDto;
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

	@Override
	public int updateRequest(UserDto user) {
		// TODO Auto-generated method stub
		int result = -1;
		
		result = session.update("user.updateRequest", user);

		return result;
	}

	@Override
	public int insertCouple(List<UserDto> user) throws SQLException {
		// TODO Auto-generated method stub
		
		int result = -1;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list",user);
		
		try {
			result = session.insert("user.insertCouple", map);
		}catch(Exception e) {
	        throw new SQLException(e.toString());
		}
		
		return result;
	}

	@Override
	public int updateRole(List<UserDto> userlist){
		// TODO Auto-generated method stub
		int result = -1;
		List<RoleDto> rolelist = new ArrayList();
		Map<String, Object> map = new HashMap<String, Object>();
		for(UserDto user : userlist) {
			for(RoleDto role : user.getRoleList()) {
				rolelist.add(role);
			}
		}
		map.put("list",rolelist);
		
		
		result = session.update("user.updateRolebyUser", map);
	
		
		return result;
		
		
	}

}
