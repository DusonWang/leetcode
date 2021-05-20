package code.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * ��������� LeetCode ƽ̨�����Ľ���ʽ���� ��
 * <p>
 * ���Ǹ�����һ����һЩ���صĵ�����ɵĵ����б�ÿ�����ʶ��� 6 ����ĸ������������б��е�һ�����ʽ���ѡ�����ܡ�
 * <p>
 * ����Ե��� master.guess(word) ���µ��ʡ������µĵ���Ӧ���Ǵ�����ԭ�б����� 6 ��Сд��ĸ��ɵ������ַ�����
 * <p>
 * �˺������᷵��һ���������֣���ʾ��Ĳ²������ܵ��ʵ�׼ȷƥ�䣨ֵ��λ��ͬʱƥ�䣩����Ŀ�����⣬�����Ĳ²ⲻ�ڸ����ĵ����б��У��������� -1��
 * <p>
 * ����ÿ���������������� 10 �λ������³�������ʡ������е��ö�����ʱ��������� master.guess �ĵ��ò����� 10 �Σ�����������һ�βµ����ܣ���ô����ͨ���ò���������
 * <p>
 * ��������ʾ�������Ĳ��������⣬������ 5 ������Ĳ���������ÿ�������б��н����� 100 �����ʡ���Щ���������е�ÿ�����ʵ���ĸ���Ǵ� 'a' �� 'z'?�����ѡȡ�ģ����ұ�֤���������б��е�ÿ�����ʶ���Ψһ�ġ�
 * <p>
 * ʾ�� 1:
 * ����:?secret = "acckzz", wordlist = ["acckzz","ccbazz","eiowzz","abcczz"]
 * <p>
 * ����:
 * <p>
 * master.guess("aaaaaa") ���� -1, ��Ϊ?"aaaaaa"?���� wordlist ��.
 * master.guess("acckzz") ���� 6, ��Ϊ?"acckzz" �������ܣ�6����ĸ��ȫƥ�䡣
 * master.guess("ccbazz") ���� 3, ��Ϊ?"ccbazz"?�� 3 ��ƥ���
 * master.guess("eiowzz") ���� 2, ��Ϊ?"eiowzz"?�� 2 ��ƥ���
 * master.guess("abcczz") ���� 4, ��Ϊ?"abcczz" �� 4 ��ƥ���
 * <p>
 * ���ǵ����� 5 ��master.guess������һ�βµ������ܣ���������ͨ�����������������
 * ��ʾ���κ���ͼ�ƹ����еĽ�������������±����ʸ�ȡ����
 * <p>
 * ͨ������2,253�ύ����6,094
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/guess-the-word
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FindSecretWord {


    static class Master {
        public int guess(String word) {
            return 0;
        }
    }

    public void findSecretWord(String[] wordlist, Master master) {
        List<String> curList = Arrays.asList(wordlist);
        Random random = new Random();
        for (int g = 0; g < 10; g++) {
            int n = curList.size();
            int r = random.nextInt(n);
            String str = curList.get(r);
            int m = master.guess(str);
            if (m == 6) {
                break;
            }
            List<String> list = new ArrayList<>();
            for (String wd : curList) {
                if (wd.equals(str)) {
                    continue;
                }
                if (match(str, wd) == m) {
                    list.add(wd);
                }
            }
            curList = list;
        }
    }

    private int match(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
