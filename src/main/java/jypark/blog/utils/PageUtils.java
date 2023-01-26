package jypark.blog.utils;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

/**
 * 페이지네이션 유틸리티 클래스
 */
public class PageUtils {

    public final static int DEFAULT_PAGE_SIZE = 5;

    public static PageRequest pageOf(Pageable pageable) {
        return pageOf(pageable.getPageNumber(), "id", Direction.DESC);
    }

    /**
     * 페이지
     * @param page
     * @return
     */
    public static PageRequest pageOf(int page) {
        return pageOf(page, "id", Direction.DESC);
    }

    /**
     * 페이지와 정렬 컬럼
     * @param page
     * @param property
     * @return
     */
    public static PageRequest pageOf(int page, String property) {
        return pageOf(page, property, Direction.DESC);
    }

    /**
     * 페이지와 정렬 컬럼, 정렬방식
     * @param page
     * @param property
     * @param direction
     * @return
     */
    public static PageRequest pageOf(int page, String property, Direction direction) {
        if(page < 0) {
            page = 0;
        }
        PageRequest pageRequest = PageRequest.of(page, DEFAULT_PAGE_SIZE,
            Sort.by(direction, property));
        return pageRequest;
    }

    /**
     * 페이지와 사이즈 선택
     * @param page
     * @param size
     * @return
     */
    public static PageRequest pageOf(int page, int size) {
        if(page < 0) {
            page = 0;
        }
        PageRequest pageRequest = PageRequest.of(page, size,
            Sort.by(Direction.DESC, "id"));
        return pageRequest;
    }

    /**
     * 페이지의 총 갯수
     * @param totalCount
     * @return
     */
    public static long getPageTotalSize(long totalCount) {
        return getPageTotalSize(totalCount, DEFAULT_PAGE_SIZE);
    }

    public static long getPageTotalSize(long totalCount, long pageSize) {
        return (totalCount / pageSize) + 1;
    }

    /**
     * 화면에서 사용자가 선태갈 수 있는 페이지 리스트 구하기
     * @param currentPage
     * @param totalCount
     * @return
     */
    public static List<Long> getPageNumbers(long currentPage, long totalCount) {
        return getPageNumbers(currentPage, totalCount, DEFAULT_PAGE_SIZE);
    }

    public static List<Long> getPageNumbers(long currentPage, long totalCount, int pageSize) {
        List<Long> list = new ArrayList<>();
        final long pageTotalSize = getPageTotalSize(totalCount, pageSize);
        for(long page = currentPage - 1; (page < currentPage + 2) && (page <= pageTotalSize); page++) {
            list.add(page);
        }
        return list.stream().filter(l -> l > 0).toList();
    }

    public static Pageable getRecentPageable() {
        return pageOf(0, "publishAt", Direction.DESC);
    }
}
