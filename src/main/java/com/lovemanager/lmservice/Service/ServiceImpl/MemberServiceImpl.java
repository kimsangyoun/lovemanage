package com.lovemanager.lmservice.Service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovemanager.lmservice.Dao.MemberDao;
import com.lovemanager.lmservice.Dto.MemberDto;
import com.lovemanager.lmservice.Service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDao memberDAO;
	
	@Override
	public MemberDto selectOne(String id) {
		// TODO Auto-generated method stub
		return memberDAO.selectMember(id);
	}
	

}
