package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * ����ʽ�ֻ��ϣ��û�ͨ�����ּ������룬�ֻ����ṩ����Щ������ƥ��ĵ����б�ÿ������ӳ�䵽0��4����ĸ������һ���������У�ʵ��һ���㷨������ƥ�䵥�ʵ��б����õ�һ�ź�����Ч���ʵ��б�ӳ������ͼ��ʾ��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: num = "8733", words = ["tree", "used"]
 * ���: ["tree", "used"]
 * ʾ�� 2:
 * <p>
 * ����: num = "2", words = ["a", "b", "c", "d"]
 * ���: ["a", "b", "c"]
 * ��ʾ��
 * <p>
 * num.length <= 1000
 * words.length <= 500
 * words[i].length == num.length
 * num�в������ 0, 1 ����������
 * ͨ������1,649�ύ����2,356
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/t9-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * @author duson
 */
public class GetValidT9Words {

    public List<String> getValidT9Words(String num, String[] words) {
        List<String> res = new ArrayList<>();
        char[] map = {'2', '2', '2', '3', '3', '3', '4', '4', '4', '5', '5', '5', '6', '6', '6', '7', '7', '7', '7', '8', '8', '8', '9', '9', '9', '9'};
        for (String word : words) {
            int index = 0;
            boolean flag = true;
            for (char c : word.toCharArray()) {
                char n = map[c - 'a'];
                if (n != num.charAt(index++)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(word);
            }
        }
        return res;
    }
}
