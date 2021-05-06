package code.code;

/**
 * ����һ������ rectangles ������ rectangles[i] = [li, wi] ��ʾ�� i �����εĳ���Ϊ li �����Ϊ wi ��
 * <p>
 * ������� k ͬʱ���� k <= li �� k <= wi ���Ϳ��Խ��� i �������гɱ߳�Ϊ k �������Ρ����磬���� [4,6] �����гɱ߳����Ϊ 4 �������Ρ�
 * <p>
 * �� maxLen Ϊ���ԴӾ�������?rectangles �зֵõ��� ��������� �ı߳���
 * <p>
 * ����ͳ���ж��ٸ������ܹ��г��߳�Ϊ maxLen �������Σ������ؾ��� ��Ŀ ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺rectangles = [[5,8],[3,9],[5,12],[16,5]]
 * �����3
 * ���ͣ��ܴ�ÿ���������г�����������α߳��ֱ��� [5,3,5,5] ��
 * ��������εı߳�Ϊ 5 �������� 3 �������зֵõ���
 * ʾ�� 2��
 * <p>
 * ���룺rectangles = [[2,3],[3,7],[4,3],[3,7]]
 * �����3
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= rectangles.length <= 1000
 * rectangles[i].length == 2
 * 1 <= li, wi <= 109
 * li != wi
 * ͨ������8,688�ύ����11,012
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-rectangles-that-can-form-the-largest-square
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CountGoodRectangles {

    public int countGoodRectangles(int[][] rectangles) {
        int max = 0;
        int count = 1;
        for (int[] rectangle : rectangles) {
            int a = Math.min(rectangle[0], rectangle[1]);
            if (a > max) {
                max = a;
                count = 1;
            } else if (a == max) {
                count++;
            }
        }
        return count;
    }
}
