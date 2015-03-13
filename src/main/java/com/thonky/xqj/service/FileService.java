package com.thonky.xqj.service;

import java.io.File;

/**
 * 文件保存，下载功能
 * 
 * @author hzjinwenbin
 * 
 */
public interface FileService {

	/**
	 * 保存文件
	 * 
	 * @param buffer
	 * @param fileName
	 * @return
	 */
	public String saveFile(byte[] buffer, String fileName);

	/**
	 * 下载文件
	 * 
	 * @param id
	 * @return
	 */
	public File getFileOnDisk(String id);
}
