package code.code;

/**
 * �������һ�����Խ����ַ��� command �� Goal ������ ��command �� "G"��"()" ��/�� "(al)" ��ĳ��˳����ɡ�Goal �������Ὣ "G" ����Ϊ�ַ��� "G"��"()" ����Ϊ�ַ��� "o" ��"(al)" ����Ϊ�ַ��� "al" ��Ȼ�󣬰�ԭ˳�򽫾����͵õ����ַ������ӳ�һ���ַ�����
 * <p>
 * �����ַ��� command ������ Goal ������ �� command �Ľ��ͽ����
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺command = "G()(al)"
 * �����"Goal"
 * ���ͣ�Goal ��������������Ĳ���������ʾ��
 * G -> G
 * () -> o
 * (al) -> al
 * ������ӵõ��Ľ���� "Goal"
 * ʾ�� 2��
 * <p>
 * ���룺command = "G()()()()(al)"
 * �����"Gooooal"
 * ʾ�� 3��
 * <p>
 * ���룺command = "(al)G(al)()()G"
 * �����"alGalooG"
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= command.length <= 100
 * command �� "G"��"()" ��/�� "(al)" ��ĳ��˳�����
 * ͨ������13,977�ύ����16,840
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/goal-parser-interpretation
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Interpret {

    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); ++i) {
            if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') {
                    sb.append('o');
                    i++;
                } else {
                    sb.append("al");
                    i += 3;
                }
                continue;
            }
            sb.append('G');
        }
        return sb.toString();
    }
}
