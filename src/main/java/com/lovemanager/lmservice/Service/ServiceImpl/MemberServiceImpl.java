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
import com.lovemanager.lmservice.Service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDao memberDAO;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public int insertUser(UserDto user) {
		// TODO Auto-generated method stub
		String encPassword = passwordEncoder.encode(user.getPassword());
		user.setUserPwd(encPassword);
		
		int result = memberDAO.insertUser(user);
		
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public int insertBasicRole(UserDto user) {
		// TODO Auto-generated method stub
		ArrayList<RoleDto> roles = new ArrayList<RoleDto>();
		
		roles.add(new RoleDto(user.getUserId(),"ROLE_S000","사용자"));
		int result = -1;
		user.setRoleList(roles);
		
		try {
			result = memberDAO.insertRole(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result = -1;
		} 
		return result;
	}

	@Override
	public int deleteUser(UserDto user) {
		// TODO Auto-generated method stub
		int result = -1;
		try {
			result = memberDAO.deleteUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public UserDto findMemberbyCouple(UserDto user) {
		// TODO Auto-generated method stub
		UserDto rstUser = memberDAO.findMemberbyCouple(user.getUserId());
		return rstUser;
	}

	@Override
	public List<UserDto> findRequestUser(UserDto user) {
		// TODO Auto-generated method stub
		List<UserDto> rstUser = memberDAO.findRequestUser(user.getUserId());
		return rstUser;
	}

	@Override
	public int insertRequest(UserDto user) {
		// TODO Auto-generated method stub
		int result=-1;
		
		try {
			result = memberDAO.insertRequest(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public int insertCouple(UserDto user) {
		// TODO Auto-generated method stub
		int result = -1;
		List<UserDto> userlist = new ArrayList<UserDto>();
		UserDto currUser = new UserDto();
		UserDto coupleUser = new UserDto();
		currUser.setUserId(user.getUserId());
		coupleUser.setUserId(user.getCoupleId());
		
		currUser.setCoupleId(user.getCoupleId());
		coupleUser.setCoupleId(user.getUserId());
		
		currUser.setCoupleYn("Y");
		coupleUser.setCoupleYn("Y");
		
		ArrayList<RoleDto> currUserRoles = new ArrayList<RoleDto>();
		ArrayList<RoleDto> coupleUserRoles = new ArrayList<RoleDto>();
		
		currUserRoles.add(new RoleDto(currUser.getUserId(),"ROLE_S001","일반사용자"));
		coupleUserRoles.add(new RoleDto(coupleUser.getUserId(),"ROLE_S001","일반사용자"));
		
		currUser.setRoleList(currUserRoles);
		coupleUser.setRoleList(coupleUserRoles);

		userlist.add(currUser);
		userlist.add(coupleUser);
		
		
		try {
			result = memberDAO.insertCouple(userlist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		if(result >0) {
			result = memberDAO.updateRole(userlist);
		}
		
		if(result >0) {
			result = memberDAO.updateRequest(user);
		}
		
		
		return result;
	}
	
	
	
	

}
