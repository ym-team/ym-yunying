package com.hmn.ym.utils;

import org.apache.ibatis.session.RowBounds;

public class RowBoundsUtil {

	public static RowBounds of(int pageNum, int pageSize) {
		return new RowBounds((pageNum - 1) * pageSize, pageSize);
	}
}
