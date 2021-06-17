package code.code;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * ����һ���������� heights ����ʾ������ĸ߶ȡ�����һЩש�� bricks ������ ladders ��
 * <p>
 * ��ӽ����� 0 ��ʼ�ọ́����������Ľ������ƶ����ڼ���ܻ��õ�ש������ӡ�
 * <p>
 * ���ӽ����� i �ƶ��������� i+1���±� �� 0 ��ʼ ��ʱ��
 * <p>
 * �����ǰ������ĸ߶� ���ڻ���� ��һ������ĸ߶ȣ�����Ҫ���ӻ�ש��
 * �����ǰ�����ĸ߶� С�� ��һ�������ĸ߶ȣ�������ʹ�� һ������ �� (h[i+1] - h[i]) ��ש��
 * �������ѷ�ʽʹ�ø��������Ӻ�ש�飬��������Ե������Զ��������±꣨�±� �� 0 ��ʼ ����
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * ���룺heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
 * �����4
 * ���ͣ��ӽ����� 0 ����������԰��˷�������ọ́�
 * - ��ʹ��ש������ӵ��ｨ���� 1 ����Ϊ 4 >= 2
 * - ʹ�� 5 ��ש�鵽�ｨ���� 2 �������ʹ��ש������ӣ���Ϊ 2 < 7
 * - ��ʹ��ש������ӵ��ｨ���� 3 ����Ϊ 7 >= 6
 * - ʹ��Ψһ�����ӵ��ｨ���� 4 �������ʹ��ש������ӣ���Ϊ 6 < 9
 * �޷�Խ�������� 4 ����Ϊû�и���ש������ӡ�
 * ʾ�� 2��
 * <p>
 * ���룺heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
 * �����7
 * ʾ�� 3��
 * <p>
 * ���룺heights = [14,3,19,3], bricks = 17, ladders = 0
 * �����3
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= heights.length <= 105
 * 1 <= heights[i] <= 106
 * 0 <= bricks <= 109
 * 0 <= ladders <= heights.length
 * ͨ������5,637�ύ����12,316
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/furthest-building-you-can-reach
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FurthestBuilding {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int len = heights.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < len - 1; i++) {
            if (heights[i] >= heights[i + 1]) {
                continue;
            }
            int diff = heights[i + 1] - heights[i];
            if (bricks >= diff) {
                queue.offer(diff);
                bricks -= diff;
            } else if (ladders-- > 0) {
                int maxDiff = !queue.isEmpty() ? queue.peek() : 0;
                if (diff < maxDiff) {
                    bricks += queue.poll();
                    bricks -= diff;
                    queue.offer(diff);
                }
            } else {
                return i;
            }
        }
        return len - 1;
    }

    public static void main(String[] args) {
        FurthestBuilding furthestBuilding = new FurthestBuilding();
        System.out.println(furthestBuilding.furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1));
        System.out.println(furthestBuilding.furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2));
        System.out.println(furthestBuilding.furthestBuilding(new int[]{14, 3, 19, 3}, 17, 0));

    }
}
