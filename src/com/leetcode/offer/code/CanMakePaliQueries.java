package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * ����һ���ַ���?s�������?s?���Ӵ����м�⡣
 * <p>
 * ÿ�μ�⣬�����Ӵ������Ա�ʾΪ?queries[i] = [left, right, k]�����ǿ��� �������� �Ӵ�?s[left], ..., s[right]��������ѡ�� ��� k?���滻���κ�СдӢ����ĸ��?
 * <p>
 * ����������������У��Ӵ����Ա�ɻ�����ʽ���ַ�������ô�����Ϊ?true��������Ϊ?false��
 * <p>
 * ���ش�����?answer[]������?answer[i]?�ǵ�?i?�������Ӵ�?queries[i]?�ļ������
 * <p>
 * ע�⣺���滻ʱ���Ӵ��е�ÿ����ĸ��������Ϊ ������ ����м�����Ҳ����˵�����?s[left..right] = "aaa"?��?k = 2������ֻ���滻���е�������ĸ�������⣬�κμ�ⶼ�����޸�ԭʼ�ַ��� s��������Ϊÿ�μ�ⶼ�Ƕ����ģ�
 * <p>
 * ?
 * <p>
 * ʾ����
 * <p>
 * ���룺s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
 * �����[true,false,false,true,true]
 * ���ͣ�
 * queries[0] : �Ӵ� = "d"�����ġ�
 * queries[1] :?�Ӵ� = "bc"�����ǻ��ġ�
 * queries[2] :?�Ӵ� = "abcd"��ֻ�滻 1 ���ַ��Ǳ䲻�ɻ��Ĵ��ġ�
 * queries[3] :?�Ӵ� = "abcd"�����Ա�ɻ��ĵ� "abba"�� Ҳ���Ա�� "baab"�������������� "bacd"��Ȼ��� "cd" �滻Ϊ "ab"��
 * queries[4] :?�Ӵ� = "abcda"�����Ա�ɻ��ĵ� "abcba"��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length,?queries.length?<= 10^5
 * 0 <= queries[i][0] <= queries[i][1] <?s.length
 * 0 <= queries[i][2] <= s.length
 * s ��ֻ��СдӢ����ĸ
 * ͨ������2,966�ύ����13,363
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/can-make-palindrome-from-substring
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CanMakePaliQueries {

    public List<Boolean> canMakePaliQueries(String s, int[][] qs) {
        int[] cnt = new int[s.length() + 1];
        int i = 0;
        for (char c : s.toCharArray()) {
            cnt[i + 1] = cnt[i++] ^ (1 << (c - 'a'));
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] q : qs) {
            int sum = (q[1] - q[0]) % 2;
            sum += Integer.bitCount(cnt[q[1] + 1] ^ cnt[q[0]]);
            res.add(sum / 2 <= q[2]);
        }
        return res;
    }
}
