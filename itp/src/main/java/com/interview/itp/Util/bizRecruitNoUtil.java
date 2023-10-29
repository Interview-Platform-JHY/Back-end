package com.interview.itp.Util;

import org.apache.commons.lang3.StringUtils;

public class bizRecruitNoUtil {
	
	final int bizRecruitDtlNo_LEN = 24;		// 기업채용면접정보번호 (24자리)
	final int bizNo[] = {0, 10};			// 기업채용면접정보번호에서 '기업번호' 얻기위한 index 시작, 끝+1 위치 : 10자리
	final int bizJobGrp[] = {10, 15};		// 기업채용면접정보번호에서 '채용직군분야' 얻기위한 index 시작, 끝+1 위치 : 5자리
	final int bizRecruitRegDt[] = {15, 23};	// 기업채용면접정보번호에서 '등록일자' 얻기위한 index 시작, 끝+1 위치 : 8자리
	final int bizInterviewNo[] = {23, 24};	// 기업채용면접정보번호에서 '면접차수' 얻기위한 index 시작, 끝+1 위치 : 1자리
	
	
	/*
	 * chkTotalLen : bizRecruitDtlNo(기업채용면접정보번호) 자리수 체크
	 * */
	public boolean chkTotalLen(String bizRecruitDtlNo) {
		return StringUtils.length(StringUtils.trim(bizRecruitDtlNo)) == bizRecruitDtlNo_LEN;
	}

	
	/*
	 * getBizNo : bizRecruitDtlNo(기업채용면접정보번호)에서 기업번호 get
	 * */
	public String getBizNo(String bizRecruitDtlNo) {
		return StringUtils.substring(bizRecruitDtlNo, bizNo[0], bizNo[1]);
	}
	
	/*
	 * getBizJobGrp : bizRecruitDtlNo(기업채용면접정보번호)에서 채용직군분야 get
	 * */
	public String getBizJobGrp(String bizRecruitDtlNo) {
		return StringUtils.substring(bizRecruitDtlNo, bizJobGrp[0], bizJobGrp[1]);
	}
	
	/*
	 * getBizRecruitRegDt : bizRecruitDtlNo(기업채용면접정보번호)에서 등록일자 get
	 * */
	public String getBizRecruitRegDt(String bizRecruitDtlNo) {
		return StringUtils.substring(bizRecruitDtlNo, bizRecruitRegDt[0], bizRecruitRegDt[1]);
	}
	
	/*
	 * getBizInterviewNo : bizRecruitDtlNo(기업채용면접정보번호)에서 면접차수번호 get
	 * */
	public String getBizInterviewNo(String bizRecruitDtlNo) {
		return StringUtils.substring(bizRecruitDtlNo, bizInterviewNo[0], bizInterviewNo[1]);
	}
}
