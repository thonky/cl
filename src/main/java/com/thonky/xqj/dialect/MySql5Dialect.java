package com.thonky.xqj.dialect;

/**
 * The Class MySql5Dialect.
 */
public class MySql5Dialect extends Dialect {

	public String getPageSql(String sql, int offset, int limit) {
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(sql.replaceAll("[\r\n]", " ").replaceAll("\\s{2,}", " "));
		sqlBuf.append(" LIMIT ").append(offset).append(", ").append(limit);
		return sqlBuf.toString();
	}

}
