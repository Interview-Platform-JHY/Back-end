package com.interview.itp.Service.Common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.itp.Dao.Common.LoginDao;
import com.interview.itp.Dto.Common.LoginDto_IN;
import com.interview.itp.Dto.Common.LoginDto_OUT;

@Service
public class LoginService {
	
	@Autowired
	LoginDao loginDao;
	
	/**
	 * Login 확인 및 Session에 필요한 값 조회 (HR)
	 *
	 * @param LoginDto_IN      LoginDto_IN 객체
	 * @return LoginDto_OUT
	 */
	public LoginDto_OUT loginHr(LoginDto_IN loginDto_IN) {
		
		return loginDao.loginHr(loginDto_IN);
	}

	/**
	 * Login 확인 및 Session에 필요한 값 조회 (loginInterviewer)
	 *
	 * @param LoginDto_IN      LoginDto_IN 객체
	 * @return LoginDto_OUT
	 */
	public LoginDto_OUT loginInterviewer(LoginDto_IN loginDto_IN) {
		
		return loginDao.loginHr(loginDto_IN);
	}
	
	/**
	 * Login 확인 및 Session에 필요한 값 조회 (Interviwee)
	 *
	 * @param LoginDto_IN      LoginDto_IN 객체
	 * @return LoginDto_OUT
	 */
	public LoginDto_OUT loginInterviwee(LoginDto_IN loginDto_IN) {
		
		return loginDao.loginInterviwee(loginDto_IN);
	}
}
