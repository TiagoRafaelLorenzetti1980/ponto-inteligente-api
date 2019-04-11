package com.lorenzetti.pontointeligente.api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.ObjectUtils;

public class PasswordUtils {

	private static final Logger log = LoggerFactory.getLogger(PasswordUtils.class);

	public PasswordUtils() {
		
	}
	
	public static String gerarBCrypt(String valor) {
		
		if (ObjectUtils.isEmpty(valor)) {
			return valor;
		}
		
		log.info("PasswordUtils.gerarBCrypt - Gernado hash com BCrypt.");
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		return bCryptPasswordEncoder.encode(valor);
	}
	
}
