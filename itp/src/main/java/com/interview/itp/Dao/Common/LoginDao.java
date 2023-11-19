package com.interview.itp.Dao.Common;

import org.apache.ibatis.annotations.Mapper;

import com.interview.itp.Dto.Common.LoginDto;

@Mapper
public interface LoginDao {
	public LoginDto loginHr(LoginDto loginDto);
}
