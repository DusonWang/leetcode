package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * ����Ҫ���һ��������֤�����֤ϵͳ��ÿһ����֤�У��û����յ�һ���µ���֤�룬�����֤���� currentTime?ʱ��֮�� timeToLive?����ڡ������֤�뱻�����ˣ���ô������ currentTime?��������֮ǰ�� currentTime?��ͬ��ʱ���ӳ�?timeToLive?�롣
 * <p>
 * ����ʵ��?AuthenticationManager?�ࣺ
 * <p>
 * AuthenticationManager(int timeToLive)?����?AuthenticationManager?������?timeToLive?������
 * generate(string tokenId, int currentTime)?���� tokenId?���ڵ�ǰʱ��?currentTime ����һ���µ���֤�롣
 * renew(string tokenId, int currentTime)?������ tokenId?�� δ����?����֤���� currentTime?ʱ�̸��¡��������?tokenId?��Ӧ����֤�벻���ڻ��ѹ��ڣ�������Ըò������������κθ��²���������
 * countUnexpiredTokens(int currentTime)?�뷵���ڸ���?currentTime?ʱ�̣�δ����?����֤����Ŀ��
 * ���һ����֤����ʱ��?t?���ڣ�����һ������ǡ����ʱ��?t?������renew?����?countUnexpiredTokens?�������������¼�?������?����������
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * ���룺
 * ["AuthenticationManager", "renew", "generate", "countUnexpiredTokens", "generate", "renew", "renew", "countUnexpiredTokens"]
 * [[5], ["aaa", 1], ["aaa", 2], [6], ["bbb", 7], ["aaa", 8], ["bbb", 10], [15]]
 * �����
 * [null, null, null, 1, null, null, null, 0]
 * <p>
 * ���ͣ�
 * AuthenticationManager authenticationManager = new AuthenticationManager(5); // ���� AuthenticationManager ������ timeToLive = 5 �롣
 * authenticationManager.renew("aaa", 1); // ʱ�� 1 ʱ��û����֤��� tokenId Ϊ "aaa" ��û����֤�뱻���¡�
 * authenticationManager.generate("aaa", 2); // ʱ�� 2 ʱ������һ�� tokenId Ϊ "aaa" ������֤�롣
 * authenticationManager.countUnexpiredTokens(6); // ʱ�� 6 ʱ��ֻ�� tokenId Ϊ "aaa" ����֤��δ���ڣ����Է��� 1 ��
 * authenticationManager.generate("bbb", 7); // ʱ�� 7 ʱ������һ�� tokenId Ϊ "bbb" ������֤�롣
 * authenticationManager.renew("aaa", 8); // tokenId Ϊ "aaa" ����֤����ʱ�� 7 ���ڣ��� 8 >= 7 ������ʱ�� 8 ��renew ���������ԣ�û����֤�뱻���¡�
 * authenticationManager.renew("bbb", 10); // tokenId Ϊ "bbb" ����֤����ʱ�� 10 û�й��ڣ����� renew ������ִ�У��� token ����ʱ�� 15 ���ڡ�
 * authenticationManager.countUnexpiredTokens(15); // tokenId Ϊ "bbb" ����֤����ʱ�� 15 ���ڣ�tokenId Ϊ "aaa" ����֤����ʱ�� 7 ���ڣ�������֤����ѹ��ڣ����Է��� 0 ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= timeToLive <= 108
 * 1 <= currentTime <= 108
 * 1 <= tokenId.length <= 5
 * tokenId?ֻ����СдӢ����ĸ��
 * ����?generate?�����ĵ��ö��������һ�޶���?tokenId?ֵ��
 * ���к��������У�currentTime?��ֵ �ϸ����?��
 * ���к����ĵ��ô����ܹ�������?2000?�Ρ�
 * ͨ������2,480�ύ����4,487
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/design-authentication-manager
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class AuthenticationManager {

    private final int timeToLive;
    private final Map<String, Integer> tokens;

    public AuthenticationManager(int timeToLive) {
        tokens = new HashMap<>();
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        tokens.put(tokenId, currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        if (tokens.containsKey(tokenId)) {
            int time = tokens.get(tokenId);
            if (currentTime - time < timeToLive) {
                tokens.put(tokenId, currentTime);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int ans = 0;
        for (Map.Entry<String, Integer> entry : tokens.entrySet()) {
            if (currentTime - entry.getValue() < timeToLive) {
                ++ans;
            }
        }
        return ans;
    }
}
