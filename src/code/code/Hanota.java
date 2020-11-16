package code.code;

import java.util.List;

/**
 * �ھ��人ŵ�������У��� 3 �����Ӽ� N ����ͬ��С�Ĵ���Բ�̣����ӿ��Ի�������һ�����ӡ�һ��ʼ�������������϶��°������������ڵ�һ��������(��ÿһ������ֻ�ܷ��ڸ������������)���ƶ�Բ��ʱ�ܵ���������:
 * (1) ÿ��ֻ���ƶ�һ������;
 * (2) ����ֻ�ܴ����Ӷ��˻����Ƶ���һ������;
 * (3) ����ֻ�ܵ��ڱ�����������ϡ�
 * <p>
 * ���д������ջ���������Ӵӵ�һ�������Ƶ����һ�����ӡ�
 * <p>
 * ����Ҫԭ���޸�ջ��
 * <p>
 * ʾ��1:
 * <p>
 * ���룺A = [2, 1, 0], B = [], C = []
 * �����C = [2, 1, 0]
 * ʾ��2:
 * <p>
 * ���룺A = [1, 0], B = [], C = []
 * �����C = [1, 0]
 * ��ʾ:
 * <p>
 * A�����ӵ���Ŀ������14����
 * ͨ������3,908�ύ����6,188
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/hanota-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Hanota {

    public void hanota(List<Integer> a, List<Integer> b, List<Integer> c) {
        hanota(a.size(), a, b, c);
    }

    private void hanota(int n, List<Integer> a, List<Integer> b, List<Integer> c) {
        if (n == 1) {
            c.add(a.get(a.size() - 1));
            a.remove(a.get(a.size() - 1));
            return;
        }
        hanota(n - 1, a, c, b);
        c.add(a.get(a.size() - 1));
        a.remove(a.get(a.size() - 1));
        hanota(n - 1, b, a, c);
    }

}
