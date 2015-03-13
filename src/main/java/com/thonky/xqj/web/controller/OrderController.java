package com.thonky.xqj.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thonky.xqj.web.JsonResponse;

@Controller
@RequestMapping("/order")
public class OrderController {

	@RequestMapping(value = "/save")
	public JsonResponse save() {
		return null;
	}

	@RequestMapping(value = "/cancle")
	public JsonResponse cancle() {
		return null;
	}
}
