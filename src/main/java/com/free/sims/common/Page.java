package com.free.sims.common;

/**
 * @author liuzeke
 * @version 1.0
 */
public class Page {

	private int pageNum;
	private int pageSize;
	private long pageTotal;
	private long total;
	private int start;
	private int end;
	private boolean isPage;

	public Page() {
	}

	public Page(int pageNum, int pageSize) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.start = pageSize * (pageNum - 1);
		this.end = pageSize * pageNum;
		this.isPage = true;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(long pageTotal) {
		this.pageTotal = pageTotal;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		if (!isPage)
			return;
		this.total = total;
		long count = total / pageSize;
		this.pageTotal = count < 1 ? 1 : (total % pageSize == 0 ? count : count + 1);
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public boolean isPage() {
		return isPage;
	}

	public void setPage(boolean isPage) {
		this.isPage = isPage;
	}
}
