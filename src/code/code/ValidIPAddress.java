package code.code;

/**
 * @author duson
 * 编写一个函数来验证输入的字符串是否是有效的 IPv4 或IPv6 地址。
 * <p>
 * IPv4地址由十进制数和点来表示，每个地址包含4个十进制数，其范围为0 -255，用(".")分割。比如，172.16.254.1；
 * <p>
 * 同时，IPv4 地址内的数不会以 0 开头。比如，地址172.16.254.01 是不合法的。
 * <p>
 * IPv6地址由8组16进制的数字来表示，每组表示16 比特。这些组数字通过 (":")分割。比如,2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。所以，2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。
 * <p>
 * 然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。比如，2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
 * <p>
 * 同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如，02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
 * <p>
 * 说明:你可以认为给定的字符串里没有空格或者其他特殊字符。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "172.16.254.1"
 * <p>
 * 输出: "IPv4"
 * <p>
 * 解释: 这是一个有效的 IPv4 地址, 所以返回 "IPv4"。
 * 示例 2:
 * <p>
 * 输入: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * <p>
 * 输出: "IPv6"
 * <p>
 * 解释: 这是一个有效的 IPv6 地址, 所以返回 "IPv6"。
 * 示例 3:
 * <p>
 * 输入: "256.256.256.256"
 * <p>
 * 输出: "Neither"
 * <p>
 * 解释: 这个地址既不是 IPv4 也不是 IPv6 地址。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-ip-address
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidIPAddress {

    public String validIPAddress(String IP) {
        if (isIPv4(IP)) {
            return "IPv4";
        } else if (isIPv6(IP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    private boolean isIPv4(String ip) {
        if (ip.length() < 7) {
            return false;
        }

        if (ip.length() > 15) {
            return false;
        }

        return isIPv4Token(ip);
    }

    private boolean isIPv6(String ip) {
        if (ip.length() < 15) {
            return false;
        }

        if (ip.length() > 39) {
            return false;
        }

        return isIPv6Token(ip);
    }

    private boolean isIPv4Token(String ip) {
        int sum = 0, dot = 0, n = ip.length();
        char[] cc = ip.toCharArray();
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && sum == 0 && cc[i] == '0' && cc[i + 1] != '.') {
                return false;
            }
            if (cc[i] == '.') {
                dot++;
                if (i > 0 && cc[i - 1] == '.' || i == 0 || i == n - 1 || sum > 255) {
                    return false;
                }
                sum = 0;
            } else if (cc[i] >= '0' && cc[i] <= '9') {
                sum = sum * 10 + cc[i] - '0';
            } else {
                return false;
            }
        }

        return dot == 3 && sum < 256;
    }

    private boolean isIPv6Token(String ip) {
        int colon = 0, n = ip.length(), count = 0;
        char[] cc = ip.toCharArray();

        if (cc[0] == '0' && cc[1] != ':') {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (cc[i] == ':') {
                colon++;
                if (i > 0 && cc[i - 1] == ':' || i == 0 || i == n - 1 || count > 4) {
                    return false;
                }
                count = 0;
            } else if ('0' <= cc[i] && cc[i] <= '9' ||
                    'a' <= cc[i] && cc[i] <= 'f' ||
                    'A' <= cc[i] && cc[i] <= 'F') {
                count++;
            } else {
                return false;
            }
        }
        return colon == 7 && count <= 4;
    }
}
