package com.leetcode.offer.code;


import java.util.ArrayList;
import java.util.List;

/**
 * 我们给出两个单词数组 A?和?B。每个单词都是一串小写字母。
 * <p>
 * 现在，如果?b 中的每个字母都出现在 a 中，包括重复出现的字母，那么称单词 b 是单词 a 的子集。 例如，“wrr” 是 “warrior” 的子集，但不是 “world” 的子集。
 * <p>
 * 如果对 B 中的每一个单词?b，b 都是 a 的子集，那么我们称?A 中的单词 a 是通用的。
 * <p>
 * 你可以按任意顺序以列表形式返回?A 中所有的通用单词。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
 * 输出：["facebook","google","leetcode"]
 * 示例 2：
 * <p>
 * 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
 * 输出：["apple","google","leetcode"]
 * 示例 3：
 * <p>
 * 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
 * 输出：["facebook","google"]
 * 示例 4：
 * <p>
 * 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
 * 输出：["google","leetcode"]
 * 示例 5：
 * <p>
 * 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
 * 输出：["facebook","leetcode"]
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length, B.length <= 10000
 * 1 <= A[i].length, B[i].length?<= 10
 * A[i]?和?B[i]?只由小写字母组成。
 * A[i]?中所有的单词都是独一无二的，也就是说不存在?i != j?使得?A[i] == A[j]。
 * 通过次数3,282提交次数8,058
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
