package com.interview.itp.Dao.Common;

import org.apache.ibatis.annotations.Mapper;

import com.interview.itp.Dto.Common.LoginDto_IN;
import com.interview.itp.Dto.Common.LoginDto_OUT;

@Mapper
public interface LoginDao {
	
	/**
	 * Login 확인 및 Session에 필요한 값 조회 (HR)
	 *
	 * @param LoginDto_IN      LoginDto_IN 객체
	 * @return LoginDto_OUT
	 */
	public LoginDto_OUT loginHr(LoginDto_IN loginDto_IN);
	
	/**
	 * Login 확인 및 Session에 필요한 값 조회 (Interviwer)
	 *
	 * @param LoginDto_IN      LoginDto_IN 객체
	 * @return LoginDto_OUT
	 */
	public LoginDto_OUT loginInterviewer(LoginDto_IN loginDto_IN);
	
	/**
	 * Login 확인 및 Session에 필요한 값 조회 (Interviwee)
	 *
	 * @param LoginDto_IN      LoginDto_IN 객체
	 * @return LoginDto_OUT
	 */
	public LoginDto_OUT loginInterviwee(LoginDto_IN loginDto_IN);
}
