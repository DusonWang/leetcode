package code.code;

/**
 * @author duson
 * 0,1,,n-1��n�������ų�һ��ԲȦ��������0��ʼ��ÿ�δ����ԲȦ��ɾ����m�����֡�������ԲȦ��ʣ�µ����һ�����֡�
 * <p>
 * ���磬0��1��2��3��4��5���������һ��ԲȦ��������0��ʼÿ��ɾ����3�����֣���ɾ����ǰ4������������2��0��4��1��������ʣ�µ�������3��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ����: n = 5, m = 3
 * ���:?3
 * ʾ�� 2��
 * <p>
 * ����: n = 10, m = 17
 * ���:?2
 * ?
 * <p>
 * ���ƣ�
 * <p>
 * 1 <= n?<= 10^5
 * 1 <= m <= 10^6
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LastRemaining {

    public int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
