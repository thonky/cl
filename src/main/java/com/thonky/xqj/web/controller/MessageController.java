package com.thonky.xqj.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thonky.xqj.web.JsonResponse;

@Controller
@RequestMapping("/message")
public class MessageController {

	@RequestMapping(value = "/save")
	public JsonResponse leaveMsg() {
		return null;
	}
}
