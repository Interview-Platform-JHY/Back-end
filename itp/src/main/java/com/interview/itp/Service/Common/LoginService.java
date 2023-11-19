package com.interview.itp.Service.Common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.itp.Dao.Common.LoginDao;
import com.interview.itp.Dto.Common.LoginDto;

@Service
public class LoginService {
	
	@Autowired
	LoginDao loginDao;
	
	/**
	 * Login 확인 및 Session에 필요한 값 조회
	 *
	 * @param SessionDto      session Dto 객체
	 * @return session
	 */
	public LoginDto loginHr(LoginDto loginDto) {
		
		return loginDao.loginHr(loginDto);
	}
	
}
