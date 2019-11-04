package com.leetcode.offer.code;

import java.util.*;

/**
 * @author duson
 * 设计一个内存文件系统，模拟以下功能：
 * <p>
 * ls： 以字符串的格式输入一个路径。如果它是一个文件的路径，那么函数返回一个列表，仅包含这个文件的名字。如果它是一个文件夹的的路径，那么返回该 文件夹内 的所有文件和子文件夹的名字。你的返回结果（包括文件和子文件夹）应该按字典序排列。
 * <p>
 * mkdir：输入一个当前不存在的 文件夹路径 ，你需要根据路径名创建一个新的文件夹。如果有上层文件夹路径不存在，那么你也应该将它们全部创建。这个函数的返回类型为 void 。
 * <p>
 * addContentToFile： 输入字符串形式的 文件路径 和 文件内容 。如果文件不存在，你需要创建包含给定文件内容的文件。如果文件已经存在，那么你需要将给定的文件内容 追加 在原本内容的后面。这个函数的返回类型为 void 。
 * <p>
 * readContentFromFile： 输入 文件路径 ，以字符串形式返回该文件的 内容 。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入:
 * ["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
 * [[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
 * <p>
 * 输出:
 * [null,[],null,null,["a"],"hello"]
 * <p>
 * 解释:
 * <p>
 *  
 * <p>
 * 注意:
 * <p>
 * 你可以假定所有文件和文件夹的路径都是绝对路径，除非是根目录 / 自身，其他路径都是以 / 开头且 不 以 / 结束。
 * 你可以假定所有操作的参数都是有效的，即用户不会获取不存在文件的内容，或者获取不存在文件夹和文件的列表。
 * 你可以假定所有文件夹名字和文件名字都只包含小写字母，且同一文件夹下不会有相同名字的文件夹或文件。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-in-memory-file-system
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FileSystem {

    static class MyFile {

        public Map<String, MyFile> map = new HashMap<>();

        public boolean file = false;

        public String content = "";
    }

    private MyFile myFile;

    public FileSystem() {
        myFile = new MyFile();
    }

    public List<String> ls(String path) {
        MyFile t = myFile;
        List<String> list = new ArrayList<>();
        if (!"/".equals(path)) {
            String[] d = path.split("/");
            for (int i = 1; i < d.length; i++) {
                t = t.map.get(d[i]);
            }
            if (t.file) {
                list.add(d[d.length - 1]);
                return list;
            }
        }
        list = new ArrayList<>(t.map.keySet());
        Collections.sort(list);
        return list;
    }

    public void mkdir(String path) {
        MyFile t = myFile;
        String[] d = path.split("/");
        for (int i = 1; i < d.length; i++) {
            if (!t.map.containsKey(d[i])) {
                t.map.put(d[i], new MyFile());
            }
            t = t.map.get(d[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        MyFile t = myFile;
        String[] d = filePath.split("/");
        int len = d.length - 1;
        for (int i = 1; i < len; i++) {
            t = t.map.get(d[i]);
        }
        if (!t.map.containsKey(d[len])) {
            t.map.put(d[len], new MyFile());
        }
        t = t.map.get(d[len]);
        t.file = true;
        t.content += content;
    }

    public String readContentFromFile(String filePath) {
        MyFile t = myFile;
        String[] d = filePath.split("/");
        for (int i = 1; i < d.length - 1; i++) {
            System.out.println(d[i]);
            t = t.map.get(d[i]);
        }
        return t.map.get(d[d.length - 1]).content;
    }

    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
//      ["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
//[[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]

        fileSystem.ls("/");
        fileSystem.mkdir("/a/b/c");
        fileSystem.addContentToFile("/a/b/c/d", "hello");
        fileSystem.ls("/");
        fileSystem.readContentFromFile("/a/b/c/d");
    }
}
