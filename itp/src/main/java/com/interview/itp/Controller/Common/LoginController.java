package com.interview.itp.Controller.Common;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.interview.itp.Dto.Common.LoginDto;
import com.interview.itp.Service.Common.LoginService;
import com.interview.itp.Util.bizRecruitNoUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LoginController {
	
	private final String ROLE_ADMIN = "admin";
	private final String ROLE_HR = "hr";
	private final String ROLE_INTERVIEWER = "interviewer";
	private final String ROLE_INTERVIEWEE = "interviewee";
	
	@Autowired
	private LoginService loginService;
	
	bizRecruitNoUtil bizNoUtil;

	@PostMapping("/login")
	public String loginRole(@RequestBody LoginDto loginDto, HttpServletRequest request) {
		
		String role = loginDto.getRole();
		
		log.info("role >>>>>>>>>>>>>>>>>> : " + role);
		
		// 1. bizRecruitDtlNo 검증 및 DTO 세팅
		HashMap<String, String> bizInfo = bizNoUtil.getBizInterviewInfo(loginDto.getBizRecruitDtlNo());
		loginDto.setBizNo(bizInfo.get("bizNo"));
		loginDto.setBizJobGrp(bizInfo.get("bizJobGrp"));
		loginDto.setBizRecruitRegDt(bizInfo.get("bizRecruitRegDt"));
		loginDto.setBizInterviewNo(bizInfo.get("bizInterviewNo"));
		
		// 2. role에 따른 json 로그인 service 태우기
		LoginDto chkLoginDto = null;
		switch (role) {
			case ROLE_ADMIN:
				break;
			case ROLE_HR:
				chkLoginDto = loginService.loginHr(loginDto);
				break;
			case ROLE_INTERVIEWER:
				break;
			case ROLE_INTERVIEWEE:
				break;
			default:
				break;
		}
		
		log.info(chkLoginDto.toString());
		
		// 3. 로그인 성공이면 세션에 저장할 데이터 조회
		if (!StringUtils.isNotBlank(chkLoginDto.getName())) {
			log.error(" 로그인 실패 !!!!!!!!!!!");
		} else {
			// 4. 1번에서 로그인 성공하면 세션 생성
			HttpSession session = request.getSession();
		}
		
		return "확인!";
		
	}
	
	
}
