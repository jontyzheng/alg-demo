package jin;

/**
 * 从字符串中读取数字
 * 1、从第一个不是空格的字符开始读 去除前面的空格
 * 2、读取第一个符号位：
 * -：记录正负数 + 记录正数 如果是-的话先加上再追加
 * 数字：往后读到最后一个连续不是数字的位置，截取数字
 * -(45) +(43)
 */
public class NumberRead {
    public int myAtoi(String s) {
        StringBuilder builder = new StringBuilder();
        int res = 0;
        // String realS = spaceRemove(s);
        int index = 0;
        int n = s.length();
        // 跳过空格的法二：获取第一个非空格的位置 = 走到第一个不是空格的位置
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }
        if (index == n) {
            return 0;
        }
        String realS = s.substring(index, n);
        // ""
        if (realS.equals("")) {
            return 0;
        }
        boolean negative = false;
        if (s.charAt(index) == '-') {
            negative = true;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        } else if (!Character.isDigit(s.charAt(index))) {
            return 0;   // 非数字【api: Character.isDigit()】
        }
        int ans = 0;
        while (index < n && Character.isDigit(index)) {
            int digit = s.charAt(index) - '0';
            // 检查是否越界
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return negative == true ? -Integer.MAX_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            index++;
        }
        return negative == true ? -ans : ans;

        // char start = realS.charAt(0);
        // if start with -
        // if (start == 45) {
        //     builder.append('-');
        //     int startNext = 1;
        //     int i = endNumIndex(realS);
        //     // 如果下一位非数字的处理
        //     if (i <= 0) {
        //         return 0;
        //     } else {
        //         String restPart = realS.substring(startNext, i + 1);
        //         builder.append(restPart);
        //     }
        // } else if (start == 43) {
        //     // if start with +
        //     // builder.append('-');
        //     int startNext = 1;
        //     int i = endNumIndex(realS);
        //     // 如果下一位非数字的处理
        //     if (i <= 0) {
        //         return 0;
        //     } else {
        //         String restPart = realS.substring(startNext, i + 1);
        //         builder.append(restPart);
        //     }
        // } else if (start < 48 || start > 57) {
        //     // else if start with 非数字
        //     return 0;
        // } else {
        //     // else start with 数字
        //     int i = endNumIndex(realS);
        //     String wholeNum = realS.substring(0, i + 1);
        //     builder.append(wholeNum);
        // }
        // // 字符串长度最长可以达200
        // // 大数处理：若超出范围取边界值
        // String finalString = builder.toString();
        // Long value = Long.valueOf(finalString);
        // if (value <= Integer.MIN_VALUE) {
        //     res = Integer.MIN_VALUE;
        // } else if (value >= Integer.MAX_VALUE) {
        //     res = Integer.MAX_VALUE;
        // } else {
        //     res = value.intValue();
        // }
        // return res;
    }

    /**
     * 移除一个字符串前的空格
     */
    public String spaceRemove(String s) {
        String res = "";
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')
                continue;
            else {
                index = i;
                break;
            }
        }
        res = s.substring(index, s.length());
        return res;
    }

    /**
     * 从数字位截取到第一个非数字之前
     * param: 一个数字开头的字符串
     * return: 从开头位置开始到下一个非数字之前的部分
     * 返回坐标位置numEnd就好
     */
    private int endNumIndex(String s) {
        int numEnd = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < 48 || c > 57) {
                break;
            } else {
                numEnd++;
            }
        }
        return numEnd;
    }

    // 大整数


    public static void main(String[] args) {
        NumberRead man = new NumberRead();
        String s = "20000000000000000000";
        String s1 = man.spaceRemove(s);
        System.out.println(s1);
        System.out.println(man.endNumIndex(s1));
        System.out.println(s1.substring(0, man.endNumIndex(s1) + 1));

        int result = man.myAtoi(s);
        System.out.println(result);

    }

}
