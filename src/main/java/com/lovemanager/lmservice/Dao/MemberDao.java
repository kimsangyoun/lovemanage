package com.lovemanager.lmservice.Dao;

import com.lovemanager.lmservice.Dto.MemberDto;

public interface MemberDao {
	public MemberDto selectMember(String id);
}
