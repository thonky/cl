package com.thonky.xqj.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/file")
public class CommonFileController {

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public String updateFile(HttpServletRequest request,
			HttpServletResponse response) {
		return "";
	}

	@RequestMapping(value = "/getFile")
	public void getPicFile() {
	}
}
