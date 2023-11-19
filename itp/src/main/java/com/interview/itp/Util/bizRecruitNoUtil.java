package com.interview.itp.Util;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class bizRecruitNoUtil {
	
	final int bizRecruitDtlNo_LEN = 24;		// 기업채용면접정보번호 (24자리)
	final int bizNo[] = {0, 10};			// 기업채용면접정보번호에서 '기업번호' 얻기위한 index 시작, 끝+1 위치 : 10자리
	final int bizJobGrp[] = {10, 15};		// 기업채용면접정보번호에서 '채용직군분야' 얻기위한 index 시작, 끝+1 위치 : 5자리
	final int bizRecruitRegDt[] = {15, 23};	// 기업채용면접정보번호에서 '등록일자' 얻기위한 index 시작, 끝+1 위치 : 8자리
	final int bizInterviewNo[] = {23, 24};	// 기업채용면접정보번호에서 '면접차수' 얻기위한 index 시작, 끝+1 위치 : 1자리
	
	/*
	 * chkTotalLen : bizRecruitDtlNo(기업채용면접정보번호) 자리수 체크
	 * @param : bizRecruitDtlNo(기업채용면접정보번호)
	 * @return : 기업채용면접정보번호 길이
	 * */
	public boolean chkTotalLen(String bizRecruitDtlNo) {
		return StringUtils.length(StringUtils.trim(bizRecruitDtlNo)) == bizRecruitDtlNo_LEN;
	}
	
	/*
	 * getBizNo : bizRecruitDtlNo(기업채용면접정보번호)에서 기업번호 get
	 * @param : bizRecruitDtlNo(기업채용면접정보번호)
	 * @return : 기업번호 (10)
	 * */
	public String getBizNo(String bizRecruitDtlNo) {
		
		if (chkTotalLen(bizRecruitDtlNo) == false) {
			return "";
		}
		
		return StringUtils.substring(bizRecruitDtlNo, bizNo[0], bizNo[1]);
	}
	
	/*
	 * getBizJobGrp : bizRecruitDtlNo(기업채용면접정보번호)에서 채용직군분야 get
	 * @param : bizRecruitDtlNo(기업채용면접정보번호)
	 * @return : 채용직군분야 (5)
	 * */
	public String getBizJobGrp(String bizRecruitDtlNo) {
		if (chkTotalLen(bizRecruitDtlNo) == false) {
			return "";
		}
		return StringUtils.substring(bizRecruitDtlNo, bizJobGrp[0], bizJobGrp[1]);
	}
	
	/*
	 * getBizRecruitRegDt : bizRecruitDtlNo(기업채용면접정보번호)에서 등록일자 get
	 * @param : bizRecruitDtlNo(기업채용면접정보번호)
	 * @return : 등록일자 (8)
	 * */
	public String getBizRecruitRegDt(String bizRecruitDtlNo) {
		if (chkTotalLen(bizRecruitDtlNo) == false) {
			return "";
		}
		return StringUtils.substring(bizRecruitDtlNo, bizRecruitRegDt[0], bizRecruitRegDt[1]);
	}
	
	/*
	 * getBizInterviewNo : bizRecruitDtlNo(기업채용면접정보번호)에서 면접차수번호 get
	 * @param : bizRecruitDtlNo(기업채용면접정보번호)
	 * @return : 면접차수 (1)
	 * */
	public String getBizInterviewNo(String bizRecruitDtlNo) {
		if (chkTotalLen(bizRecruitDtlNo) == false) {
			return "";
		}
		return StringUtils.substring(bizRecruitDtlNo, bizInterviewNo[0], bizInterviewNo[1]);
	}
	
	/*
	 * getBizInterviewInfo : bizRecruitDtlNo(기업채용면접정보번호)를 통해 기업, 면접정보 추출
	 * @param : bizRecruitDtlNo(기업채용면접정보번호)
	 * @return : 면접차수 (1)
	 * */
	public HashMap<String, String> getBizInterviewInfo(String bizRecruitDtlNo) {
		
		HashMap<String, String> bizInterviewInfoMap = new HashMap<String, String>();
		
		if (chkTotalLen(bizRecruitDtlNo) == false) {
			log.error(">>>>>>>>>>>>>>>>>>>>>>>>> 생성 error");
			return bizInterviewInfoMap;
		}
		
		bizInterviewInfoMap.put("bizRecruitDtlNo", bizRecruitDtlNo);
		bizInterviewInfoMap.put("bizNo", this.getBizNo(bizRecruitDtlNo));
		bizInterviewInfoMap.put("bizJobGrp", this.getBizJobGrp(bizRecruitDtlNo));
		bizInterviewInfoMap.put("bizRecruitRegDt", this.getBizRecruitRegDt(bizRecruitDtlNo));
		bizInterviewInfoMap.put("bizInterviewNo", this.getBizInterviewNo(bizRecruitDtlNo));
		
		return bizInterviewInfoMap;
	}
}
