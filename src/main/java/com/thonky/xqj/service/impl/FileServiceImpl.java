package com.thonky.xqj.service.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.thonky.xqj.mapper.FileMapper;
import com.thonky.xqj.model.XqjFile;
import com.thonky.xqj.service.FileService;
import com.thonky.xqj.util.LoggerUtil;

@Service
public class FileServiceImpl implements FileService {

	@Value("#commonProperties['file.basePath']")
	private static String basePath = "";

	@Autowired
	private FileMapper fileMapper;

	@PostConstruct
	public void init() throws IOException {
		File file = new File(basePath);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	@Override
	public String saveFile(byte[] buffer, String fileName) {
		ByteArrayInputStream inputStream = null;
		try {
			inputStream = new ByteArrayInputStream(buffer);
			return saveFile(inputStream, fileName);
		} catch (Exception e) {
			LoggerUtil.error("文件保存失败！");
			return null;
		} finally {
			closeInputStream(inputStream);
		}
	}

	/**
	 * @param inputStream
	 * @param fileName
	 * @return
	 */
	private String saveFile(InputStream inputStream, String fileName) {
		String id = generateUUID();
		String fileType = getFileType(fileName);
		XqjFile xqjFile = new XqjFile();
		xqjFile.setId(id);
		xqjFile.setFileName(fileName);
		xqjFile.setFileType(fileType);
		FileOutputStream outputStream = null;
		try {
			File file = new File(basePath, id);
			if (!file.exists()) {
				file.createNewFile();
			}
			outputStream = new FileOutputStream(file);
			byte[] buffer = new byte[1024];
			int count = 0;
			long totalCount = 0;
			while ((count = inputStream.read(buffer)) > 0) {
				totalCount += count;
				outputStream.write(buffer, 0, count);
				outputStream.flush();
			}
			// 设置大小
			xqjFile.setFileSize(String.valueOf(totalCount));
			// 保存数据库
			fileMapper.saveFile(xqjFile);
		} catch (Exception e) {
			LoggerUtil.error("保存文件失败!");
			return null;
		} finally {
			closeOutputStream(outputStream);
		}
		return id;
	}

	@Override
	public File getFileOnDisk(String id) {
		return null;
	}

	/**
	 * 生成UUID
	 * 
	 * @return
	 */
	private String generateUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 获取文件后缀
	 * 
	 * @param fileName
	 * @return
	 */
	private String getFileType(String fileName) {
		int i = fileName.lastIndexOf('.');
		String fileType = fileName.substring(i);
		return fileType;
	}

	/**
	 * 关闭输入流
	 * 
	 * @param inputStream
	 */
	private void closeInputStream(InputStream inputStream) {
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				// throw new FilerException("关闭文件流");
			}
		}
	}

	/**
	 * 关闭输出流
	 * 
	 * @param outputStream
	 */
	private void closeOutputStream(OutputStream outputStream) {
		if (outputStream != null) {
			try {
				outputStream.close();
			} catch (IOException e) {
				// throw new FileException("关闭文件流", e);
			}
		}
	}
}
