package code.code;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ���۹�˾��Ա����ʹ��Ա���������칫�ҵ��š�ÿ��һ��Ա��ʹ��һ������Ա����������ϵͳ���¼��Ա�������ֺ�ʹ��ʱ�䡣���һ��Ա����һСʱʱ����ʹ��Ա�����Ĵ������ڵ������Σ����ϵͳ���Զ�����һ�� ����?��
 * <p>
 * �����ַ�������?keyName?��?keyTime ������?[keyName[i], keyTime[i]]?��Ӧһ���˵����ֺ�����?ĳһ�� ��ʹ��Ա������ʱ�䡣
 * <p>
 * ʹ��ʱ��ĸ�ʽ�� 24Сʱ��?������?"HH:MM"?���ȷ�˵?"23:51" ��?"09:49"?��
 * <p>
 * ���㷵��ȥ�غ���յ�ϵͳ�����Ա�����֣������ǰ� �ֵ�������?����󷵻ء�
 * <p>
 * ��ע��?"10:00" - "11:00"?��Ϊһ��Сʱʱ�䷶Χ�ڣ���?"23:51" - "00:10"?������ΪһСʱ�ڣ���Ϊϵͳ��¼����ĳһ���ڵ�ʹ�������
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"], keyTime = ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
 * �����["daniel"]
 * ���ͣ�"daniel" ��һСʱ��ʹ���� 3 ��Ա������"10:00"��"10:40"��"11:00"����
 * ʾ�� 2��
 * <p>
 * ���룺keyName = ["alice","alice","alice","bob","bob","bob","bob"], keyTime = ["12:01","12:00","18:00","21:00","21:20","21:30","23:00"]
 * �����["bob"]
 * ���ͣ�"bob" ��һСʱ��ʹ���� 3 ��Ա������"21:00"��"21:20"��"21:30"����
 * ʾ�� 3��
 * <p>
 * ���룺keyName = ["john","john","john"], keyTime = ["23:58","23:59","00:01"]
 * �����[]
 * ʾ�� 4��
 * <p>
 * ���룺keyName = ["leslie","leslie","leslie","clare","clare","clare","clare"], keyTime = ["13:00","13:20","14:00","18:00","18:51","19:30","19:49"]
 * �����["clare","leslie"]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= keyName.length, keyTime.length <= 105
 * keyName.length == keyTime.length
 * keyTime ��ʽΪ?"HH:MM"?��
 * ��֤?[keyName[i], keyTime[i]]?�γɵĶ�Ԫ��?������ͬ?��
 * 1 <= keyName[i].length <= 10
 * keyName[i]?ֻ����СдӢ����ĸ��
 * ͨ������3,028�ύ����7,376
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class AlertNames {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            List<String> times = map.computeIfAbsent(keyName[i], k -> new ArrayList<>());
            times.add(keyTime[i]);
        }
        List<String> warnList = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            String name = entry.getKey();
            List<String> times = entry.getValue();
            if (checkIfNeedWarning(times)) {
                warnList.add(name);
            }
        }
        warnList.sort(null);
        return warnList;
    }

    private boolean checkIfNeedWarning(List<String> times) {
        if (times.size() < 3) {
            return false;
        }
        int[] timeInMinutes = new int[times.size()];
        int i = 0;
        for (String time : times) {
            timeInMinutes[i++] = (time.charAt(0) - '0') * 10 * 60 + (time.charAt(1) - '0') * 60 + (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
        }
        Arrays.sort(timeInMinutes);
        for (i = 2; i < timeInMinutes.length; i++) {
            if (timeInMinutes[i - 2] + 60 >= timeInMinutes[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //["daniel","daniel","daniel","luis","luis","luis","luis"]
        //["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]

        AlertNames alertNames = new AlertNames();
        String[] keyName = new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"};
        String[] keyTime = new String[]{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};
        alertNames.alertNames(keyName, keyTime);
    }
}
