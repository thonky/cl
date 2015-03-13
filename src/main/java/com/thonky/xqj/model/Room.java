package com.thonky.xqj.model;

import java.util.List;

public class Room {

	private Integer id;

	private String name;

	private String typeName;

	private String statusName;

	private List<RoomPic> picList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public List<RoomPic> getPicList() {
		return picList;
	}

	public void setPicList(List<RoomPic> picList) {
		this.picList = picList;
	}

}
