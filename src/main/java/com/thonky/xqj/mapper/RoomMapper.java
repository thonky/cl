package com.thonky.xqj.mapper;

import java.util.List;

import com.thonky.xqj.model.Room;
import com.thonky.xqj.model.RoomPic;

/**
 * @author hzjinwenbin
 * 
 */
public interface RoomMapper {
	
	/**
	 * @return
	 */
	public List<Room> getAllRoom();

	/**
	 * @param room
	 * @return
	 */
	public Integer saveRoomInfo(Room room);

	/**
	 * @param room
	 * @return
	 */
	public Integer updateRoomInfo(Room room);

	/**
	 * @param room
	 * @return
	 */
	public Integer deleteRoomInfo(Integer id);

	/**
	 * @param roomId
	 * @return
	 */
	public Integer deleteRoomPic(Integer roomId);

	/**
	 * @param room
	 * @return
	 */
	public Integer saveRoomPic(Room room);

	/**
	 * @param roomId
	 * @return
	 */
	public List<RoomPic> getRoomPicList(Integer roomId);
}
