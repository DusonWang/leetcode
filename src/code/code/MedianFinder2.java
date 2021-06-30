package code.code;


/**
 * ����:
 * <p>
 * ����������� 99% ���������� 0 �� 100 ��Χ�ڣ��㽫����Ż�����㷨��
 *
 * @author duson
 */
public class MedianFinder2 {

    private final int[] count;
    private int total;
    private int more;

    public MedianFinder2() {
        count = new int[101];
        total = 0;
        more = 0;
    }

    public void addNum(int num) {
        if (num <= 100) {
            count[num]++;
        } else {
            more++;
        }
        total++;
    }

    public double findMedian() {
        int temp = total - more * 2;
        if ((temp & 1) == 0) {
            return (findKthNumber(more + temp / 2) + findKthNumber(more + temp / 2 + 1)) / 2.0;
        } else {
            return findKthNumber(more + temp / 2 + 1);
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
