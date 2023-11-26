package com.interview.itp.Dto.Common;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor // 생성자가 모든 멤버 변수를 포함하도록 설정
@ToString
public class LoginDto_IN {
	
	private String role;	// 역할 : admin, hr, interviewer, interviewee

	// (개인)
	private String id;			// 로그인 : 사번 or 이메일
	private String password; 	// 로그인 : 비밀번호
	
	// (회사/지원자)
	private String bizRecruitDtlNo;	// 기업채용면접정보번호 : 기업대표번호(10) + 채용직군분야(5) + 등록일자(8) + 면접차수(1)
	
	@Builder
	public LoginDto_IN(String role, String id, String bizRecruitDtlNo) {
		
		this.role = role;
		this.id = id;
		this.bizRecruitDtlNo = bizRecruitDtlNo;
	}
}
