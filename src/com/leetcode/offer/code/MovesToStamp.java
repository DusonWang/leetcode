package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * ����Ҫ��Сд��ĸ���һ��Ŀ���ַ���?target��?
 * <p>
 * ��ʼ��ʱ��������?target.length?��?'?'?�Ǻ���ɡ�������һ��Сд��ĸӡ��?stamp��
 * <p>
 * ��ÿ���غϣ�����Խ�ӡ�·��������ϣ����������е�ÿ����ĸ�滻Ϊӡ���ϵ���Ӧ��ĸ���������Խ���?10 * target.length? ���غϡ�
 * <p>
 * �ٸ����ӣ������ʼ����Ϊ "?????"�������ӡ�� stamp?��?"abc"����ô�ڵ�һ�غϣ�����Եõ�?"abc??"��"?abc?"��"??abc"������ע�⣬ӡ�±�����ȫ���������еı߽��ڲ��ܸ���ȥ����
 * <p>
 * �������ӡ�����У���ô����һ�����飬��������ÿ���غ��б�ӡ�µ��������ĸ��������ɡ��������ӡ�����У��ͷ���һ�������顣
 * <p>
 * ���磬��������� "ababc"��ӡ���� "abc"����ô���ǾͿ��Է��������?"?????" -> "abc??" -> "ababc" ���Ӧ�Ĵ� [0, 2]��
 * <p>
 * ���⣬�������ӡ�����У���ô��Ҫ��֤������ 10 * target.length?���غ�����ɡ��κγ��������ֵĴ𰸽��������ܡ�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺stamp = "abc", target = "ababc"
 * �����[0,2]
 * ��[1,0,2] �Լ�����һЩ���ܵĽ��Ҳ����Ϊ�𰸱����ܣ�
 * ʾ�� 2��
 * <p>
 * ���룺stamp = "abca", target = "aabcaca"
 * �����[3,0,1]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= stamp.length <= target.length <= 1000
 * stamp ��?target?ֻ����Сд��ĸ��
 * ͨ������769�ύ����2,291
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/stamping-the-sequence
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MovesToStamp {

    public int[] movesToStamp(String stamp, String target) {
        List<Integer> result = new ArrayList<>();
        char[] targetArray = target.toCharArray();
        if (!dfs(targetArray, result, stamp, targetArray.length)) {
            return new int[0];
        }
        int[] arrayResult = new int[result.size()];
        for (int i = 0; i < arrayResult.length; i++) {
            arrayResult[i] = result.get(arrayResult.length - 1 - i);
        }
        return arrayResult;
    }

    private boolean dfs(char[] array, List<Integer> result, String stamp, int left) {
        if (left == 0) {
            return true;
        }
        for (int i = 0; i < array.length - stamp.length() + 1; i++) {
            int remove = isEqual(array, i, stamp);
            if (remove > 0) {
                result.add(i);
                for (int j = 0; j < stamp.length(); j++) {
                    array[i + j] = '#';
                }
                return dfs(array, result, stamp, left - remove);
            }
        }
        return false;
    }

    private int isEqual(char[] array, int start, String stamp) {
        int remove = 0;
        for (int i = 0; i < stamp.length(); i++) {
            if (array[i + start] == '#') {
                continue;
            }
            if (array[i + start] == stamp.charAt(i)) {
                remove++;
                continue;
            }
            return -1;
        }
        return remove;
    }
}
