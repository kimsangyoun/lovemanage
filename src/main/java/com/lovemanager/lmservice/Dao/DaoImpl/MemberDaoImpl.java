package com.lovemanager.lmservice.Dao.DaoImpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.lovemanager.lmservice.Dao.MemberDao;
import com.lovemanager.lmservice.Dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{
	@Autowired
	@Qualifier("sqlSessionTemplate")
	SqlSessionTemplate session;
	
	@Override
	public MemberDto selectMember(String id) {
		MemberDto user = session.selectOne("member.memberSelectOne", id);
		return user;
	}

}
