package code.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * �� N λ���Ѳμ���΢�������۾ٰ��ˡ��Կۻ��ѡ����»�����췽�ṩ�� 2*N ����Ŀ���������� questions ��ÿ�����ֶ�Ӧ��ÿ����Ŀ���漰��֪ʶ�����͡�
 * ��ÿλ����ѡ��ͬ��һ�⣬�뷵�ر�ѡ�� N ����Ŀ���ٰ���������֪ʶ�����͡�
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺questions = [2,1,6,2]
 * <p>
 * �����1
 * <p>
 * ���ͣ��� 2 λ������ 4 ����Ŀ��ѡ�� 2 �⡣
 * ��ѡ�����֪ʶ������Ϊ 2 ����Ŀʱ����ʱ��һ��֪ʶ������
 * ������ٰ��� 1 ��֪ʶ�����͡�
 * <p>
 * ʾ�� 2��
 * <p>
 * ���룺questions = [1,5,1,3,4,5,2,5,3,3,8,6]
 * <p>
 * �����2
 * <p>
 * ���ͣ��� 6 λ������ 12 ����Ŀ��ѡ����Ŀ����Ҫѡ�� 6 �⡣
 * ѡ�����֪ʶ������Ϊ 3��5 ����Ŀ��������ٰ��� 2 ��֪ʶ�����͡�
 * <p>
 * ��ʾ��
 * <p>
 * questions.length == 2*n
 * 2 <= questions.length <= 10^5
 * 1 <= questions[i] <= 1000
 * ͨ������724�ύ����1,017
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/WqXACV
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class HalfQuestions {

    public int halfQuestions(int[] questions) {
        int ans = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : questions) {
            if (freq.containsKey(i)) {
                freq.put(i, freq.get(i) + 1);
            } else {
                freq.put(i, 1);
            }
        }
        Integer[] freqs = freq.values().toArray(new Integer[0]);
        Arrays.sort(freqs);
        int n = questions.length / 2;
        for (int i = freqs.length - 1; i >= 0; i--) {
            if (n > 0) {
                n -= freqs[i];
                ans += 1;
            }
        }
        return ans;
    }
}
