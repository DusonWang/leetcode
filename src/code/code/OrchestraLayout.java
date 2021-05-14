package code.code;

/**
 * ĳ���ŵ��ݳ����ؿ����� num * num �Ķ�ά���� grid�����Ͻ�����Ϊ [0,0])��ÿ��λ��վ��һλ��Ա�����Ź��� 9 ���������������Ϊ 1~9��ÿλ��Ա���� 1 ��������
 * <p>
 * Ϊ��֤���ֻ��Ч������Ավλ����Ϊ���� grid ���Ͻǿ�ʼ˳ʱ������������ѭ���� 1��2��...��9 ѭ���ظ����С����統 num = 5 ʱ��վλ��ͼ��ʾ
 * <p>
 * <p>
 * <p>
 * �뷵��λ�ڳ������� [Xpos,Ypos] �ĳ�Ա����������š�
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺num = 3, Xpos = 0, Ypos = 2
 * <p>
 * �����3
 * <p>
 * ���ͣ�
 * <p>
 * <p>
 * ʾ�� 2��
 * <p>
 * ���룺num = 4, Xpos = 1, Ypos = 2
 * <p>
 * �����5
 * <p>
 * ���ͣ�
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= num <= 10^9
 * 0 <= Xpos, Ypos < num
 * ͨ������3,012�ύ����20,168
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/SNJvJP
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class OrchestraLayout {

    public int orchestraLayout(int num, int xPos, int yPos) {
        long layer = Math.min(Math.min(Math.min(xPos, yPos), num - 1 - xPos), num - 1 - yPos);
        long res = (4L * num - 4L * layer) * layer % 9;
        if (xPos == layer) {
            res = (res + yPos - layer + 1) % 9;
        } else if (yPos == layer) {
            res = (res + (num - 2 * layer) + (num - 2 * layer - 1) + (num - 2 * layer - 1) + num - layer - xPos - 1) % 9;
        } else if (xPos == num - 1 - layer) {
            res = (res + (num - 2 * layer) + (num - 2 * layer - 1) + num - layer - yPos - 1) % 9;
        } else {
            res = (res + (num - 2 * layer) + xPos - layer) % 9;
        }
        if (res == 0) {
            return 9;
        }
        return (int) res;
    }
}
