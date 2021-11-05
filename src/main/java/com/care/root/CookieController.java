package com.care.root;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	@RequestMapping("cookie")
		public String cookie(HttpServletResponse response,
				HttpServletRequest req,
				@CookieValue(value="myCookie", required = false) Cookie cookie) {
		System.out.println("mycookie : "+cookie );
		Cookie cook = new Cookie("myCookie", "쿠키생성");
		cook.setMaxAge(5);
		
		response.addCookie(cook);
		
		for(Cookie c : req.getCookies() ) {
			System.out.println(c.getName());
		}
		
		return "cook/cookie";
	}
	
}
