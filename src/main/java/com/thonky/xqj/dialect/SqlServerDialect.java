package com.thonky.xqj.dialect;

/**
 * The Class SqlServerDialect.
 */
public class SqlServerDialect extends Dialect {

	public String getPageSql(String sql, int skipResults, int maxResults) {
		if (skipResults < 0) {
			skipResults = 0;
		}
		if (maxResults < 0) {
			maxResults = 0;
		}
		StringBuffer pagesql = new StringBuffer();
		if (skipResults / maxResults == 0) {
			pagesql.append("SELECT TOP ").append(skipResults)
					.append("* FROM (");
			pagesql.append(sql).append(") AS a ORDER BY a.id");
		} else {
			pagesql.append("SELECT TOP ").append(skipResults)
					.append("* FROM (");
			pagesql.append(sql).append(") AS a WHERE a.id NOT IN (");
			pagesql.append("select top ")
					.append(maxResults * (skipResults / maxResults))
					.append("* FROM (");
			pagesql.append(sql).append(") AS b WHERE b.id) ORDER BY a.id");
		}
		return pagesql.toString();
	}

}
