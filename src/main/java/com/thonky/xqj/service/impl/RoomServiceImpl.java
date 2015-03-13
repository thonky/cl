package com.thonky.xqj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thonky.xqj.mapper.RoomMapper;
import com.thonky.xqj.model.Room;
import com.thonky.xqj.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomMapper roomMapper;

	@Override
	public Integer saveRoomInfo(Room room) {
		roomMapper.saveRoomInfo(room);

		roomMapper.saveRoomPic(room);
		return 1;
	}

	@Override
	public Integer updateRoomInfo(Room room) {
		// 先删除照片
		roomMapper.deleteRoomPic(room.getId());

		// 保存基础信息
		roomMapper.updateRoomInfo(room);
		// 保存新照片
		roomMapper.saveRoomPic(room);
		return 1;
	}

	@Override
	public Integer deleteRoom(Integer roomId) {
		roomMapper.deleteRoomPic(roomId);
		return roomMapper.deleteRoomInfo(roomId);
	}

	public List<Room> queryAllRoom() {
		List<Room> rlist = roomMapper.getAllRoom();
		if (rlist != null && rlist.size() > 0) {
			for (Room r : rlist) {
				// 获取照片
				r.setPicList(roomMapper.getRoomPicList(r.getId()));
			}
		}
		return rlist;
	}
}
