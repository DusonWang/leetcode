package code.code;

/**
 * @author duson
 * ����һ���ַ���?s?���ַ����ġ�����������Ϊ��ֻ����һ���ַ�����ǿ����ַ����ĳ��ȡ�
 * <p>
 * ���㷵���ַ�����������
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "leetcode"
 * �����2
 * ���ͣ����ַ��� "ee" ����Ϊ 2 ��ֻ�����ַ� 'e' ��
 * ʾ�� 2��
 * <p>
 * ���룺s = "abbcccddddeeeeedcba"
 * �����5
 * ���ͣ����ַ��� "eeeee" ����Ϊ 5 ��ֻ�����ַ� 'e' ��
 * ʾ�� 3��
 * <p>
 * ���룺s = "triplepillooooow"
 * �����5
 * ʾ�� 4��
 * <p>
 * ���룺s = "hooraaaaaaaaaaay"
 * �����11
 * ʾ�� 5��
 * <p>
 * ���룺s = "tourist"
 * �����1
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 500
 * s?ֻ����СдӢ����ĸ��
 * ͨ������1,721�ύ����3,011
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/consecutive-characters
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxPower {

    public int maxPower(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();
        char char1 = chars[0];
        int maxCount = 1;
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (char1 == chars[i]) {
                count++;
            } else {
                char1 = chars[i];
                count = 1;
            }
            if (count >= maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }
}
