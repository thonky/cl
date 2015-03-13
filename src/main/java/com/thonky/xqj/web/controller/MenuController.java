package com.thonky.xqj.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thonky.xqj.web.JsonResponse;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@RequestMapping(value = "/add")
	public JsonResponse addNewMenu() {
		return null;
	}
}
