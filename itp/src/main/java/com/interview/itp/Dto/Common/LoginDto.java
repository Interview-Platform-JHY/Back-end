package com.interview.itp.Dto.Common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor // 생성자가 모든 멤버 변수를 포함하도록 설정
@ToString
public class LoginDto {
	
	private String role;	// 역할 : admin, hr, interviewer, interviewee

	// (개인)
	private String id;			// 로그인 : 사번 or 이메일
	private String password; 	// 로그인 : 비밀번호
	private String name;		// 이름
	
	// (회사)
	private String bizRecruitDtlNo;	// 기업채용면접정보번호 : 기업대표번호(10) + 채용직군분야(5) + 등록일자(8) + 면접차수(1)
	private String bizNo;	// 기업대표번호(10)
	private String bizNm;		// 기업명
	private String bizJobGrp;	// 채용직군분야(5)
	private String bizRecruitRegDt; //등록일자(8)
	private String bizInterviewNo; // 면접차수번호(1)
	
}
