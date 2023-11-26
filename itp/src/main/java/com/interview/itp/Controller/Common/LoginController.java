package com.interview.itp.Controller.Common;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.interview.itp.Dto.Common.LoginDto_IN;
import com.interview.itp.Dto.Common.LoginDto_OUT;
import com.interview.itp.Service.Common.LoginService;
import com.interview.itp.Util.bizRecruitNoUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {
	
	private final String ROLE_ADMIN = "admin";
	private final String ROLE_HR = "hr";
	private final String ROLE_INTERVIEWER = "interviewer";
	private final String ROLE_INTERVIEWEE = "interviewee";
	
	@Autowired
	private LoginService loginService;
	
	private bizRecruitNoUtil bizNoUtil ;

	@PostMapping("/login")
	public String loginRole(@RequestBody LoginDto_IN loginDto_IN, HttpServletRequest request) {

		log.info(">>>>>>>>>>>>>>>>>> Login In DTO 확인 >>>>>>>>>>>>>>>>>> : "+loginDto_IN.toString());
		
		String role = loginDto_IN.getRole();
		
		// 1. bizRecruitDtlNo 검증
		if (!bizNoUtil.chkTotalLen(loginDto_IN.getBizRecruitDtlNo())) {
			log.error(">>>>>>>>>>>>>>>>>>>>>. biz Error !!!!!!!! >>>>>>>>>>>>>.");
		}
		
		// 2. role에 따른 json 로그인 service 태우기
		LoginDto_OUT loginDto_OUT = null;
		switch (role) {
			case ROLE_ADMIN:
				break;
			case ROLE_HR:
				loginDto_OUT = loginService.loginHr(loginDto_IN);
				break;
			case ROLE_INTERVIEWER:
				loginDto_OUT = loginService.loginInterviewer(loginDto_IN);
				break;
			case ROLE_INTERVIEWEE:
				loginDto_OUT = loginService.loginInterviwee(loginDto_IN);
				break;
			default:
				break;
		}
		
		log.info(">>>>>>>>>>>>>>>>>> Login Out DTO 확인 >>>>>>>>>>>>>>>>>> : "+loginDto_OUT.toString());
		
		// 3. 로그인 성공이면 세션에 저장할 데이터 조회
		if (!StringUtils.isNotBlank(loginDto_OUT.getName())) {
			log.error(" 로그인 실패 !!!!!!!!!!!");
		} else {
			// 4. 1번에서 로그인 성공하면 세션 생성
			HttpSession session = request.getSession();
		}
		
		return "확인!";
		
	}
	
	
}
