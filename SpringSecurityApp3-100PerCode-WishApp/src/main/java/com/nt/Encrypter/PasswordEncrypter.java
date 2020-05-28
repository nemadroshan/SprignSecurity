package com.nt.Encrypter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncrypter {
		public static void main(String[] args) {
			BCryptPasswordEncoder pwdEncoder=null;
			pwdEncoder=new BCryptPasswordEncoder(11);
			
			System.out.println("shunham :: "+pwdEncoder.encode("shubham"));
			System.out.println("rani :: "+pwdEncoder.encode("rani"));
			
		}
}
