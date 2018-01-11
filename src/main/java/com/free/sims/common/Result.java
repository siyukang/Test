package com.free.sims.common;

import java.io.Serializable;

/**
 * @author liuzeke
 * @version 1.0
 */
public class Result implements Serializable {

	private static final long serialVersionUID = 1744660527214235896L;

	public transient final static String SUCCESS = "200";
	public transient final static String ERROR = "400";

	private String code;
	private String msg;
	private Object data;
	private int pageNum;
	private int pageSize;
	private long pageTotal;

	private Result() {
	}

	/**
	 * Normal response
	 * 
	 * @author liuzeke
	 * @return
	 */
	public static Result success() {
		return new Result().setCode(SUCCESS);
	}

	/**
	 * Normal response
	 * 
	 * @author liuzeke
	 * @param data
	 * @return
	 */
	public static Result success(Object data) {
		Result resultSet = new Result();
		return resultSet.setData(data).setCode(SUCCESS).processPage(resultSet);
	}

	/**
	 * Abnormal response
	 * 
	 * @author liuzeke
	 * @param msg
	 * @return
	 */
	public static Result error(String msg) {
		return new Result().setMsg(msg).setCode(ERROR);
	}

	/**
	 * @author liuzeke
	 * @param resultSet
	 * @return
	 */
	public Result processPage(final Result resultSet) {
		Page page = PageHandle.getPageAndRelease();
		if (!page.isPage())
			return resultSet;
		return resultSet.setPageNum(page.getPageNum()).setPageSize(page.getPageSize())
				.setPageTotal(page.getPageTotal());
	}

	/**
	 * @author liuzeke
	 * @return
	 */
	@Override
	public String toString() {
		return new StringBuilder().append("{").append("code:").append("\"").append(getCode()).append("\"").append(",")
				.append("msg:").append("\"").append(getMsg()).append("\"").append("}").toString();
	}

	public String getCode() {
		return code;
	}

	public Result setCode(String code) {
		this.code = code;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public Result setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public Object getData() {
		return data;
	}

	public Result setData(Object data) {
		this.data = data;
		return this;
	}

	public int getPageNum() {
		return pageNum;
	}

	public Result setPageNum(int pageNum) {
		this.pageNum = pageNum;
		return this;
	}

	public int getPageSize() {
		return pageSize;
	}

	public Result setPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	public long getPageTotal() {
		return pageTotal;
	}

	public Result setPageTotal(long pageTotal) {
		this.pageTotal = pageTotal;
		return this;
	}
}
