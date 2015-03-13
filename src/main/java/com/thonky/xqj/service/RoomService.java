package com.thonky.xqj.service;

import java.util.List;

import com.thonky.xqj.model.Room;

/**
 * @author hzjinwenbin
 * 
 */
public interface RoomService {

	/**
	 * 保存基础信息
	 * 
	 * @param vo
	 * @return
	 */
	public Integer saveRoomInfo(Room vo);

	/**
	 * 删除
	 * 
	 * @param roomId
	 * @return
	 */
	public Integer deleteRoom(Integer roomId);

	/**
	 * 更新
	 * 
	 * @param vo
	 * @return
	 */
	public Integer updateRoomInfo(Room vo);
	
	/**
	 * @return
	 */
	public List<Room> queryAllRoom();

}
