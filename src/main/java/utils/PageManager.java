package utils;

import com.microsoft.playwright.Page;

public class PageManager {
    private static final ThreadLocal<Page> threadLocalPage = new ThreadLocal<>();

    public static Page getPage() {
        return threadLocalPage.get();
    }

    public static void setPage(Page page) {
        threadLocalPage.set(page);
    }

    public static void removePage() {
        threadLocalPage.remove();
    }
}
