package code.code;

import java.util.Arrays;

/**
 * �и���Ϸ��������Ƶ��޺��ı��ݽ�Ŀ��һ����Ҫվ����һ�˵ļ���ϡ�����ʵ�ʺ����۵Ŀ��ǣ����������Ҫ��������˰�һ������һ�㡣��֪��Ϸ��ÿ���˵���ߺ����أ����д���������޺�����ܵ������ˡ�
 * <p>
 * ʾ����
 * <p>
 * ���룺height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
 * �����6
 * ���ͣ����������������޺�����ܵ� 6 �㣺(56,90), (60,95), (65,100), (68,110), (70,150), (75,190)
 * ��ʾ��
 * <p>
 * height.length == weight.length <= 10000
 * ͨ������1,918�ύ����8,685
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/circus-tower-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class BestSeqAtIndex {

    public int bestSeqAtIndex(int[] height, int[] weight) {
        int len = height.length;
        int[][] person = new int[len][2];
        for (int i = 0; i < len; ++i) {
            person[i] = new int[]{height[i], weight[i]};
        }
        Arrays.sort(person, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[len];
        int res = 0;
        for (int[] pair : person) {
            int i = Arrays.binarySearch(dp, 0, res, pair[1]);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = pair[1];
            if (i == res) {
                ++res;
            }
        }
        return res;
    }
}
