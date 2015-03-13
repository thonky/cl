package com.thonky.xqj.dao;

import java.util.List;

import com.thonky.xqj.model.Room;

public interface RoomDao {

	public List<Room> queryRoomList();

	public Room getRoomDetail(Integer id);
}
