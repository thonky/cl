package com.thonky.xqj.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thonky.xqj.model.Room;
import com.thonky.xqj.service.RoomService;
import com.thonky.xqj.web.Constants;
import com.thonky.xqj.web.JsonResponse;

@Controller
@RequestMapping("/room")
public class RoomController {

	@Autowired
	private RoomService roomService;

	/**
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String toAdd(HttpSession session, Model model) {
		String mng = (String) session.getAttribute(Constants.ATTR_MANAGER);
		if (!StringUtils.isNotEmpty(mng)) {
			model.addAttribute("msg", "当前会话已失效，请重启登录！");
			return "/login";
		}
		return "/menu/add";
	}

	/**
	 * @param room
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public JsonResponse saveRoomInfo(Room room, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		JsonResponse res = new JsonResponse();
		Integer rid = room.getId();
		if (rid != null) {
			// 更新
			roomService.updateRoomInfo(room);
		} else {
			// 新增
			roomService.saveRoomInfo(room);
		}
		res.setCode(Constants.RESPONSE_200);
		return res;
	}

	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String roomList(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		roomService.queryAllRoom();
		return "/room/list";
	}

}
