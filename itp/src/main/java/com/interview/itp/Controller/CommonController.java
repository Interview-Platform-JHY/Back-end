package com.interview.itp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CommonController {

	@GetMapping("/login/{bizRecruitDtlNo}")
	public String loginRole(@PathVariable String bizRecruitDtlNo, @RequestParam String role) {
		
		log.info("role >>>>>>>>>>>>>>>>>> : " + bizRecruitDtlNo);
		log.info("role >>>>>>>>>>>>>>>>>> : " + role);
		return role;
	}
}
