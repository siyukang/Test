package com.free.sims.common;

/**
 * @author liuzeke
 * @version 1.0
 */
public abstract class PageHandle {

	private static final ThreadLocal<Page> PAGE_LOCAL = new ThreadLocal<Page>();

	/**
	 * Can not be inherited
	 */
	private PageHandle() {
	}

	/**
	 * @author liuzeke
	 * @return
	 */
	public static Page getPage() {
		Page page = PAGE_LOCAL.get();
		return page == null ? new Page() : page;
	}

	/**
	 * @author liuzeke
	 * @return
	 */
	public static Page getPageAndRelease() {
		try {
			Page page = PAGE_LOCAL.get();
			return page == null ? new Page() : page;
		} finally {
			PAGE_LOCAL.remove();
		}
	}

	/**
	 * @author liuzeke
	 * @param page
	 */
	public static void setPage(Page page) {
		PAGE_LOCAL.set(page);
	}
}
