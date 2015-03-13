package com.thonky.xqj.mapper;

import com.thonky.xqj.model.XqjFile;

/**
 * @author hzjinwenbin
 * 
 */
public interface FileMapper {

	/**
	 * 文件信息保存到数据库
	 * 
	 * @param xqjFile
	 * @return
	 */
	public String saveFile(XqjFile xqjFile);
}
