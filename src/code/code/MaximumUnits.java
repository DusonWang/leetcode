package code.code;

import java.util.Arrays;

/**
 * ���㽫һЩ����װ�� һ������ �ϡ�����һ����ά���� boxTypes ������ boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ��
 * <p>
 * numberOfBoxesi ������ i �����ӵ�������
 * numberOfUnitsPerBoxi ������ i?ÿ�����ӿ���װ�صĵ�Ԫ������
 * ���� truckSize ��ʾ�����Ͽ���װ�� ���� �� ������� ��ֻҪ�������������� truckSize ����Ϳ���ѡ����������װ�������ϡ�
 * <p>
 * ���ؿ�������װ��?��Ԫ �� ��� ������
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
 * �����8
 * ���ͣ����ӵ�������£�
 * - 1 ����һ������ӣ����溬 3 ����Ԫ��
 * - 2 ���ڶ�������ӣ�ÿ�����溬 2 ����Ԫ��
 * - 3 ������������ӣ�ÿ�����溬 1 ����Ԫ��
 * ����ѡ���һ��͵ڶ�����������ӣ��Լ��������һ�����ӡ�
 * ��Ԫ���� = (1 * 3) + (2 * 2) + (1 * 1) = 8
 * ʾ�� 2��
 * <p>
 * ���룺boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
 * �����91
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= boxTypes.length <= 1000
 * 1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
 * 1 <= truckSize <= 106
 * ͨ������8,235�ύ����11,817
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-units-on-a-truck
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaximumUnits {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> (o2[1] - o1[1]));
        int ans = 0;
        for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
            int num = Math.min(truckSize, boxTypes[i][0]);
            truckSize -= num;
            ans += num * boxTypes[i][1];
        }
        return ans;
    }
}
