package code.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ����ַ��� s �� ������ ������ͬ�ַ� Ƶ�� ��ͬ��������ͳ� s �� �����ַ��� ��
 * <p>
 * ����һ���ַ��� s������ʹ s ��Ϊ �����ַ��� ��Ҫɾ���� ��С �ַ�����
 * <p>
 * �ַ������ַ��� Ƶ�� �Ǹ��ַ����ַ����еĳ��ִ��������磬���ַ��� "aab" �У�'a' ��Ƶ���� 2���� 'b' ��Ƶ���� 1 ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "aab"
 * �����0
 * ���ͣ�s �Ѿ��������ַ�����
 * ʾ�� 2��
 * <p>
 * ���룺s = "aaabbbcc"
 * �����2
 * ���ͣ�����ɾ������ 'b' , �õ������ַ��� "aaabcc" ��
 * ��һ�ַ�ʽ��ɾ��һ�� 'b' ��һ�� 'c' ���õ������ַ��� "aaabbc" ��
 * ʾ�� 3��
 * <p>
 * ���룺s = "ceabaacb"
 * �����2
 * ���ͣ�����ɾ������ 'c' �õ������ַ��� "eabaab" ��
 * ע�⣬ֻ��Ҫ��ע����ַ�������Ȼ���ڵ��ַ���������Ƶ��Ϊ 0 ���ַ�����Բ��ơ���
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 105
 * s ����СдӢ����ĸ
 * ͨ������5,765�ύ����11,448
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-deletions-to-make-character-frequencies-unique
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinDeletions {

    public int minDeletions(String s) {
        char[] array = s.toCharArray();
        int[] count = new int[26];
        for (char a : array) {
            count[a - 'a']++;
        }
        int ans = 0;
        Arrays.sort(count);
        for (int i = 24; i >= 0; i--) {
            if (count[i] != 0) {
                while (count[i] >= count[i + 1] && count[i] != 0) {
                    count[i]--;
                    ans++;
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        MinDeletions minDeletions = new MinDeletions();
//        System.out.println(minDeletions.minDeletions("aab"));
//        System.out.println(minDeletions.minDeletions("aaabbbcc"));
//        System.out.println(minDeletions.minDeletions("ceabaacb"));
        System.out.println(minDeletions.minDeletions("abcabc"));

    }
}
