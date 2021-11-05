package com.care.root;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@GetMapping("login")
	public String login() {
		return "login/login";
	}
	@PostMapping("chkUser")
	public String chkUser(@RequestParam String id,
			@RequestParam String pwd,
			HttpSession session) {
		String db_id = "1", db_pwd="1", db_nick="홍길동구리구리";
		if(id.equals(db_id) && pwd.equals(db_pwd)) {
			session.setAttribute("loginId",db_id);
			session.setAttribute("loginNick",db_nick);
			return "redirect:main";
		}else {
			return "redirect:login";
		}
	}
	@RequestMapping("main")
	public String main(HttpSession session, HttpServletResponse` response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(session.getAttribute("loginId") !=null) {//확인 끝났으면 주석으로 묶어준다
		out.print("<script>alert('로그인 성공')</script>")
			return "login/main";
	}
		return "login/main";
	}
