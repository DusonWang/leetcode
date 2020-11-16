package code.code;

/**
 * ����������Ϸ��the game of master mind�����淨���¡�
 * <p>
 * �������4���ۣ�ÿ���۷�һ������ɫ�����Ǻ�ɫ��R������ɫ��Y������ɫ��G������ɫ��B�������磬�����������RGGB 4�֣���1Ϊ��ɫ����2��3Ϊ��ɫ����4Ϊ��ɫ������Ϊ�û�������ͼ�³���ɫ��ϡ�����ȷ�������ܻ��YRGB��Ҫ�ǲ¶�ĳ���۵���ɫ������һ�Ρ����С���Ҫ��ֻ�¶���ɫ����λ�´��ˣ�����һ�Ρ�α���С���ע�⣬�����С��������롰α���С���
 * <p>
 * ����һ����ɫ���solution��һ���²�guess����дһ�����������ز��к�α���еĴ���answer������answer[0]Ϊ���еĴ�����answer[1]Ϊα���еĴ�����
 * <p>
 * ʾ����
 * <p>
 * ���룺 solution="RGBY",guess="GGRR"
 * ����� [1,1]
 * ���ͣ� ����1�Σ�α����1�Ρ�
 * ��ʾ��
 * <p>
 * len(solution) = len(guess) = 4
 * solution��guess������"R","G","B","Y"��4���ַ�
 * ͨ������1,440�ύ����2,870
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/master-mind-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * @author duson
 */
public class MasterMind {

    public int[] masterMind(String solution, String guess) {
        int[] ans = new int[2];
        int[] flag = new int[26];
        for (int i = 0; i < 4; i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                ans[0]++;
            }
            if (flag[solution.charAt(i) - 'A'] < 0) {
                ans[1]++;
            }
            flag[solution.charAt(i) - 'A']++;
            if (flag[guess.charAt(i) - 'A'] > 0) {
                ans[1]++;
            }
            flag[guess.charAt(i) - 'A']--;
        }
        ans[1] -= ans[0];
        return ans;
    }
}
