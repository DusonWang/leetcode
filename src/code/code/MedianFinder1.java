package code.code;

/**
 * @author duson
 * 进阶:
 * <p>
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 */
public class MedianFinder1 {

    private final int[] count;
    private int total;

    public MedianFinder1() {
        count = new int[101];
        total = 0;
    }

    public void addNum(int num) {
        count[num]++;
        total++;
    }

    public double findMedian() {
        if ((total & 1) == 0) {
            return (findKthNumber(total / 2) + findKthNumber(total / 2 + 1)) / 2.0;
        } else {
            return findKthNumber(total / 2 + 1);
        }
    }

    private int findKthNumber(int k) {
        int index = 0;
        for (int i = 0; i < 101; i++) {
            index += count[i];
            if (index >= k) {
                return i;
            }
        }
        return -1;
    }
}
