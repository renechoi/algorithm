package os.page.fifo;

import java.util.LinkedList;
import java.util.Queue;

public class FIFOPageReplacement {
    public static void main(String[] args) {
        int[] pageReferences = {2, 3, 1, 4, 2, 5, 3, 4, 1, 5}; // 페이지 참조 시퀀스
        int pageFrameCounts = 3; // 페이지 프레임의 개수

        int pageFaults = performFIFO(pageReferences, pageFrameCounts);
        System.out.println("페이지 부재 발생 횟수: " + pageFaults);
    }

    public static int performFIFO(int[] pageReferences, int pageFrameCounts) {
        Queue<Integer> pageFrame = new LinkedList<>(); // 페이지 프레임을 관리하기 위한 큐
        int pageFaults = 0; // 페이지 부재 횟수

        for (int page : pageReferences) {
            if (!isPageExist(pageFrame, page)) {
                handlePageFault(pageFrame, pageFrameCounts, page);
                pageFaults++;
            }
        }

        return pageFaults;
    }

    public static void handlePageFault(Queue<Integer> pageFrame, int pageFrameCounts, int page) {
        if (isPageFrameFull(pageFrame, pageFrameCounts)) {
            int evictedPage = pageFrame.poll(); // 가장 오래된 페이지 제거
            System.out.println("페이지 " + evictedPage + "를 교체합니다.");
        }
        pageFrame.offer(page); // 새 페이지 추가
    }

    private static boolean isPageFrameFull(Queue<Integer> pageFrame, int pageFrameCounts) {
        return pageFrame.size() >= pageFrameCounts;
    }

    private static boolean isPageExist(Queue<Integer> pageFrame, int page) {
        return pageFrame.contains(page);
    }

}



