package org.xkj.util;

public class PageUtil {
	public static Page createPage(int everyPage, int totalCount, int currentPage) {
		Page page = new Page();
		page.setEveryPage(everyPage);
		page.setTotalCount(totalCount);
		int totalPage = getTotalPage(everyPage, totalCount);
		page.setTotalPage(totalPage);
		page.setCurrentPage(currentPage);
		page.setBeginIndex(getBeginIndex(currentPage, everyPage));
		page.setPrePage(getPrePage(currentPage, totalPage));
		page.setNextPage(getNextPage(currentPage, totalPage));
		return page;
	}
	public static int getTotalPage(int everyPage, int totalCount) {
		int totalPage = 0;
		if(totalCount != 0 && totalCount % everyPage == 0) {
			totalPage = totalCount / everyPage;
		} else {
			totalPage = totalCount / everyPage + 1;
		}
		return totalPage;
	}
	public static int getBeginIndex(int currentPage, int everyPage) {
		return (currentPage - 1) * everyPage;
	}
	public static boolean getNextPage(int currentPage, int totalPage) {
		return currentPage == totalPage? false : true;
	}
	public static boolean getPrePage(int currentPage, int totalPage) {
		return currentPage == 1? false : true;
	}
}
