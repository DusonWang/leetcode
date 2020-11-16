package code.code;

import java.util.Arrays;

/**
 * @author duson
 * ����ĳЩ�ַ��� S�����ǽ�ִ��һЩ�滻���������µ���ĸ���滻ԭ�е���ĸ�飨��һ����С��ͬ����
 * <p>
 * ÿ���滻�������� 3 ����������ʼ���� i��Դ�� x ��Ŀ���� y����������� x ��ԭʼ�ַ��� S �е�λ�� i ��ʼ����ô���ǽ��� y �滻���ֵ� x�����û�У�����ʲô��������
 * <p>
 * �ٸ����ӣ���������� S?= ��abcd�� ����������һЩ�滻���� i = 2��x = ��cd����y = ��ffff������ô��Ϊ ��cd�� ��ԭʼ�ַ��� S �е�λ�� 2 ��ʼ�����ǽ���?��ffff�� �滻����
 * <p>
 * ������ S = ��abcd�� �ϵ���һ�����ӣ�����������滻���� i = 0��x = ��ab����y = ��eee�����Լ���һ���滻���� i = 2��x = ��ec����y = ��ffff������ô�ڶ�����������ִ���κβ�������Ϊԭʼ�ַ�����?S[2] = 'c'���� x[0] = 'e' ��ƥ�䡣
 * <p>
 * ������Щ����ͬʱ��������֤���滻ʱ�������κ��ص���?S = "abc", indexes = [0, 1],?sources = ["ab","bc"] ������Ч�Ĳ���������
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
 * �����"eeebffff"
 * ���ͣ�
 * "a" �� S �е����� 0 ��ʼ�����������滻Ϊ "eee"��
 * "cd" �� S �е����� 2 ��ʼ�����������滻Ϊ "ffff"��
 * ʾ�� 2��
 * <p>
 * ���룺S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
 * �����"eeecd"
 * ���ͣ�
 * "ab" �� S �е����� 0 ��ʼ�����������滻Ϊ "eee"��
 * "ec" û�д�ԭʼ�� S �е����� 2 ��ʼ��������û�б��滻��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 0 <=?indexes.length =?sources.length =?targets.length <= 100
 * 0?<?indexes[i]?< S.length <= 1000
 * ���������е������ַ�����Сд��ĸ��
 * ?
 * <p>
 * ͨ������2,495�ύ����6,336
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-and-replace-in-string
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FindReplaceString {


    public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
        int n = s.length();
        int[] match = new int[n];
        Arrays.fill(match, -1);
        for (int i = 0; i < indexes.length; ++i) {
            int ix = indexes[i];
            if (s.startsWith(sources[i], ix)) {
                match[ix] = i;
            }
        }
        StringBuilder ans = new StringBuilder();
        int ix = 0;
        while (ix < n) {
            if (match[ix] >= 0) {
                ans.append(targets[match[ix]]);
                ix += sources[match[ix]].length();
            } else {
                ans.append(s.charAt(ix++));
            }
        }
        return ans.toString();
    }
}
