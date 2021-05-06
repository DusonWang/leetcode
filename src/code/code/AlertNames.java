package code.code;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 力扣公司的员工都使用员工卡来开办公室的门。每当一个员工使用一次他的员工卡，安保系统会记录下员工的名字和使用时间。如果一个员工在一小时时间内使用员工卡的次数大于等于三次，这个系统会自动发布一个 警告?。
 * <p>
 * 给你字符串数组?keyName?和?keyTime ，其中?[keyName[i], keyTime[i]]?对应一个人的名字和他在?某一天 内使用员工卡的时间。
 * <p>
 * 使用时间的格式是 24小时制?，形如?"HH:MM"?，比方说?"23:51" 和?"09:49"?。
 * <p>
 * 请你返回去重后的收到系统警告的员工名字，将它们按 字典序升序?排序后返回。
 * <p>
 * 请注意?"10:00" - "11:00"?视为一个小时时间范围内，而?"23:51" - "00:10"?不被视为一小时内，因为系统记录的是某一天内的使用情况。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"], keyTime = ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
 * 输出：["daniel"]
 * 解释："daniel" 在一小时内使用了 3 次员工卡（"10:00"，"10:40"，"11:00"）。
 * 示例 2：
 * <p>
 * 输入：keyName = ["alice","alice","alice","bob","bob","bob","bob"], keyTime = ["12:01","12:00","18:00","21:00","21:20","21:30","23:00"]
 * 输出：["bob"]
 * 解释："bob" 在一小时内使用了 3 次员工卡（"21:00"，"21:20"，"21:30"）。
 * 示例 3：
 * <p>
 * 输入：keyName = ["john","john","john"], keyTime = ["23:58","23:59","00:01"]
 * 输出：[]
 * 示例 4：
 * <p>
 * 输入：keyName = ["leslie","leslie","leslie","clare","clare","clare","clare"], keyTime = ["13:00","13:20","14:00","18:00","18:51","19:30","19:49"]
 * 输出：["clare","leslie"]
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= keyName.length, keyTime.length <= 105
 * keyName.length == keyTime.length
 * keyTime 格式为?"HH:MM"?。
 * 保证?[keyName[i], keyTime[i]]?形成的二元对?互不相同?。
 * 1 <= keyName[i].length <= 10
 * keyName[i]?只包含小写英文字母。
 * 通过次数3,028提交次数7,376
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
