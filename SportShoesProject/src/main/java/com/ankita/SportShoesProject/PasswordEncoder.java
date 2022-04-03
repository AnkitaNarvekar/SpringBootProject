package com.ankita.SportShoesProject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	
	public static void main(String [] args)
	{
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String rawpassword="admin@1";
		String encodedPassword=encoder.encode(rawpassword);
		
		System.out.println(encodedPassword);
		
	}

}
