package com.thonky.xqj.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thonky.xqj.web.Constants;

@Controller
public class SystemController {

	@RequestMapping(value = "/toLogin")
	public String toLogin() {
		return "/manager/login";
	}

	@RequestMapping(value = "/login")
	public String managerLogin(Model model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		String un = request.getParameter("username");
		String pw = request.getParameter("password");

		if (un.equals(Constants.USERNAME) && pw.equals(Constants.PASSWORD)) {
			session.setAttribute(Constants.ATTR_MANAGER, Constants.USERNAME);
			return "/manager/index";
		}
		model.addAttribute("msg", "用户名密码错误！");
		return "/manager/login";
	}

}
