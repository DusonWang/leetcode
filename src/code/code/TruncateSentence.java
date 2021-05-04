package code.code;

/**
 * ���� ��һ�������б��б��еĵ���֮���õ����ո�������Ҳ�����ǰ����β��ո�ÿ�����ʽ��ɴ�СдӢ����ĸ��ɣ����������ţ���
 * <p>
 * ���磬"Hello World"��"HELLO" �� "hello world hello world" ���Ǿ��ӡ�
 * ����һ������ s?????? ��һ������ k?????? �����㽫 s?? �ض� ?��???ʹ�ضϺ�ľ��ӽ��� ǰ k?????? �����ʡ����� �ض� s?????? ��õ��ľ��ӡ�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "Hello how are you Contestant", k = 4
 * �����"Hello how are you"
 * ���ͣ�
 * s �еĵ���Ϊ ["Hello", "how" "are", "you", "Contestant"]
 * ǰ 4 ������Ϊ ["Hello", "how", "are", "you"]
 * ��ˣ�Ӧ������ "Hello how are you"
 * ʾ�� 2��
 * <p>
 * ���룺s = "What is the solution to this problem", k = 4
 * �����"What is the solution"
 * ���ͣ�
 * s �еĵ���Ϊ ["What", "is" "the", "solution", "to", "this", "problem"]
 * ǰ 4 ������Ϊ ["What", "is", "the", "solution"]
 * ��ˣ�Ӧ������ "What is the solution"
 * ʾ�� 3��
 * <p>
 * ���룺s = "chopper is not a tanuki", k = 5
 * �����"chopper is not a tanuki"
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 500
 * k ��ȡֵ��Χ�� [1,? s �е��ʵ���Ŀ]
 * s ���ɴ�СдӢ����ĸ�Ϳո����
 * s �еĵ���֮���ɵ����ո����
 * ������ǰ����β��ո�
 * ͨ������7,256�ύ����9,501
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/truncate-sentence
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class TruncateSentence {

    public String truncateSentence(String s, int k) {
        int cnt = 0;
        StringBuilder ans = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == ' ') {
                cnt++;
            }
            if(cnt == k) {
                break;
            }
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}
