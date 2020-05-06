package com.leetcode.offer.code;


import java.util.ArrayList;
import java.util.List;

/**
 * ���Ǹ��������������� A?��?B��ÿ�����ʶ���һ��Сд��ĸ��
 * <p>
 * ���ڣ����?b �е�ÿ����ĸ�������� a �У������ظ����ֵ���ĸ����ô�Ƶ��� b �ǵ��� a ���Ӽ��� ���磬��wrr�� �� ��warrior�� ���Ӽ��������� ��world�� ���Ӽ���
 * <p>
 * ����� B �е�ÿһ������?b��b ���� a ���Ӽ�����ô���ǳ�?A �еĵ��� a ��ͨ�õġ�
 * <p>
 * ����԰�����˳�����б���ʽ����?A �����е�ͨ�õ��ʡ�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
 * �����["facebook","google","leetcode"]
 * ʾ�� 2��
 * <p>
 * ���룺A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
 * �����["apple","google","leetcode"]
 * ʾ�� 3��
 * <p>
 * ���룺A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
 * �����["facebook","google"]
 * ʾ�� 4��
 * <p>
 * ���룺A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
 * �����["google","leetcode"]
 * ʾ�� 5��
 * <p>
 * ���룺A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
 * �����["facebook","leetcode"]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= A.length, B.length <= 10000
 * 1 <= A[i].length, B[i].length?<= 10
 * A[i]?��?B[i]?ֻ��Сд��ĸ��ɡ�
 * A[i]?�����еĵ��ʶ��Ƕ�һ�޶��ģ�Ҳ����˵������?i != j?ʹ��?A[i] == A[j]��
 * ͨ������3,282�ύ����8,058
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/word-subsets
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class WordSubsets {

    public List<String> wordSubsets(String[] A, String[] B) {
        int[] maxFreq = new int[26];
        for(String s : B){
            int[] temp = getFreq(s);
            for(int i = 0; i < 26; i++){
                maxFreq[i] = Math.max(maxFreq[i], temp[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for(String str : A){
            boolean flag = true;
            int[] temp = getFreq(str);
            for(int i = 0; i < 26; i++){
                if(maxFreq[i] > temp[i]){
                    flag = false;
                    break;
                }
            }
            if(flag) {
                result.add(str);
            }
        }
        return result;
    }

    private int[] getFreq(String s){
        int[] result = new int[26];
        for(char c : s.toCharArray()){
            result[c - 'a']++;
        }
        return result;
    }
}
