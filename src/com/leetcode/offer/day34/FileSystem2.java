package com.leetcode.offer.day34;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * 你需要设计一个能提供下面两个函数的文件系统：
 * <p>
 * create(path, value): 创建一个新的路径，并尽可能将值 value 与路径 path 关联，然后返回 True。如果路径已经存在或者路径的父路径不存在，则返回 False。
 * get(path): 返回与路径关联的值。如果路径不存在，则返回 -1。
 * “路径” 是由一个或多个符合下述格式的字符串连接起来形成的：在 / 后跟着一个或多个小写英文字母。
 * <p>
 * 例如 /leetcode 和 /leetcode/problems 都是有效的路径，但空字符串和 / 不是有效的路径。
 * <p>
 * 好了，接下来就请你来实现这两个函数吧！（请参考示例以获得更多信息）
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["FileSystem","create","get"]
 * [[],["/a",1],["/a"]]
 * 输出：
 * [null,true,1]
 * 解释：
 * FileSystem fileSystem = new FileSystem();
 * <p>
 * fileSystem.create("/a", 1); // 返回 true
 * fileSystem.get("/a"); // 返回 1
 * 示例 2：
 * <p>
 * 输入：
 * ["FileSystem","create","create","get","create","get"]
 * [[],["/leet",1],["/leet/code",2],["/leet/code"],["/c/d",1],["/c"]]
 * 输出：
 * [null,true,true,2,false,-1]
 * 解释：
 * FileSystem fileSystem = new FileSystem();
 * <p>
 * fileSystem.create("/leet", 1); // 返回 true
 * fileSystem.create("/leet/code", 2); // 返回 true
 * fileSystem.get("/leet/code"); // 返回 2
 * fileSystem.create("/c/d", 1); // 返回 false 因为父路径 "/c" 不存在。
 * fileSystem.get("/c"); // 返回 -1 因为该路径不存在。
 *  
 * <p>
 * 提示：
 * <p>
 * 对两个函数的调用次数加起来小于等于 10^4
 * 2 <= path.length <= 100
 * 1 <= value <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-file-system
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FileSystem2 {

    private Map<String, Integer> map;

    public FileSystem2() {
        map = new HashMap<>();
        map.put("/", -1);
        map.put("", -1);
    }

    public boolean createPath(String path, int value) {
        if (map.containsKey(path)) {
            return false;
        }
        String father = "";
        for (int i = path.length() - 1; i >= 0; i--) {
            if (path.charAt(i) == '/') {
                father = path.substring(0, i);
                break;
            }
        }
        if (!map.containsKey(father)) {
            return false;
        }
        map.put(path, value);
        return true;
    }

    public int get(String path) {
        if (!map.containsKey(path)) {
            return -1;
        }
        return map.get(path);
    }

    public static void main(String[] args) {
        //["FileSystem","createPath","createPath","get","createPath","get"]
        //[[],["/leet",1],["/leet/code",2],["/leet/code"],["/c/d",1],["/c"]]

        //[null,true,true,2,true,-1]
        //[null,true,true,2,false,-1]

        FileSystem2 fileSystem = new FileSystem2();
        fileSystem.createPath("/leet",1);
        fileSystem.createPath("/leet/code",2);
        fileSystem.get("/leet/code");
        System.out.println(fileSystem.createPath("/c/d",1));

    }
}
