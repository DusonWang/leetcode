package code.code;

/**
 * @author duson
 * ����:
 * <p>
 * ����������������������� 0 �� 100 ��Χ�ڣ��㽫����Ż�����㷨��
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
