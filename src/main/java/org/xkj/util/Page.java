package org.xkj.util;

public class Page {
	private int everyPage; // 每页显示记录数
	private int totalPage; // 总页数
	private int totalCount; // 总记录数
	private int currentPage; // 当前页面
	private int beginIndex; // 起始位置
	private boolean nextPage; // 是否有下一页
	private boolean prePage; // 是否有上一页

	public int getEveryPage() {
		return everyPage;
	}

	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	public boolean isNextPage() {
		return nextPage;
	}

	public void setNextPage(boolean nextPage) {
		this.nextPage = nextPage;
	}

	public boolean isPrePage() {
		return prePage;
	}

	public void setPrePage(boolean prePage) {
		this.prePage = prePage;
	}

}
