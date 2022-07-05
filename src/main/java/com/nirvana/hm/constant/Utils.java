package com.nirvana.hm.constant;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class Utils {
	
	public String generateId(){
		return RandomStringUtils.randomAlphanumeric(6);
	}
}
