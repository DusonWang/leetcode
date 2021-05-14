package code.code;

/**
 * ���� N �����������ҳ�ʼ���յ�ˮ�ף�ÿ��ˮ������һ��ˮͰ������ˮ���� i ��ˮ���䱸��ˮͰ�������� bucket[i]��С�����������ֲ�����
 * <p>
 * ����ˮͰ��ѡ������һ��ˮͰ��ʹ����������Ϊ bucket[i]+1
 * ��ˮ����ȫ��ˮͰ����ˮ��������Զ�Ӧ��ˮ��
 * ÿ��ˮ�׶�Ӧ�����ˮ������ vat[i]������С��������Ҫ���ٴβ��������������ˮ����ˮҪ��
 * <p>
 * ע�⣺ʵ����ˮ�� �ﵽ�򳬹� �����ˮ�����������ˮҪ��
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺bucket = [1,3], vat = [6,8]
 * <p>
 * �����4
 * <p>
 * ���ͣ�
 * �� 1 �β������� bucket[0]��
 * �� 2 ~ 4 �β�����ѡ����ˮ�����������ˮҪ��
 * <p>
 * <p>
 * ʾ�� 2��
 * <p>
 * ���룺bucket = [9,0,1], vat = [0,2,2]
 * <p>
 * �����3
 * <p>
 * ���ͣ�
 * �� 1 �β�����ѡ������ bucket[1]
 * �� 2~3 �β���ѡ����ˮ�����������ˮҪ��
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= bucket.length == vat.length <= 100
 * 0 <= bucket[i], vat[i] <= 10^4
 * ͨ������2,563�ύ����15,592
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/o8SXZn
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class StoreWater {

    public int storeWater(int[] bucket, int[] vat) {
        int max = 0;
        for (int v : vat) {
            if (max < v) {
                max = v;
            }
        }
        if (max == 0) {
            return 0;
        }
        int n = bucket.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= 10000; i++) {
            int per = 0;
            int cur = i;
            for (int j = 0; j < n; j++) {
                per = (vat[j] + i - 1) / i;
                cur += Math.max(0, per - bucket[j]);
            }
            ans = Math.min(ans, cur);
        }
        return ans;
    }
}
