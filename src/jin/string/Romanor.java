package jin.string;

/**
 * 判断一个整数有几位数可以构造字符串再位数
 * */
public class Romanor {

    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        String tmpNum = num + "";
        int length = tmpNum.length();
        switch (length) {
            // 3999
            case 4: {
                if (num == 1000) {
                    return "M";
                }
                int forthDigit = num / 1000;    // 获取4位数上的数字
                String forth = forth(forthDigit);// 按照4位数的规则转换返回
                builder.append(forth);  // 转化后拿过来拼接
                num = num - forthDigit * 1000;  // 999
                int thirdDigit = num / 100; // 接着获取3位数上的数字
                String third = third(thirdDigit);   // 按照3位数的规则去转换成对应的罗马数字, 后面同理
                builder.append(third);
                num = num - thirdDigit * 100;   // 99
                int secondDigit = num / 10;
                String second = second(secondDigit);
                builder.append(second);
                num = num % 10;   //9
                String single = singleDigit(num);
                builder.append(single);
            }
            break;
            // 577
            case 3: {
                if (num == 100) {
                    return "C";
                }
                int thirdDigit = num / 100; // 5
                String third = third(thirdDigit);
                builder.append(third);
                // num = thirdDigit;
                num = num - thirdDigit * 100; // 77
                int secondDigit = num / 10; //7
                String second = second(secondDigit);
                builder.append(second);
                // num = secondDigit;
                num = num % 10;// 7
                int singleDigit = num / 1;
                String single = singleDigit(singleDigit);
                builder.append(single);
                break;
            }
            // 57
            case 2: {
                if (num == 10) {
                    return "X";
                }
                int secondDigit = num / 10; //5
                String second = second(secondDigit);
                builder.append(second);
                num = num % 10; //7
                String single = singleDigit(num);
                builder.append(single);
                break;
            }
            // 5
            case 1: {
                String single = singleDigit(num);
                builder.append(single);
            }
            break;
            default:
                return "error";
        }
        return builder.toString();
    }

    // 从4位数开始, 1000是M 2000是2个M 3000是3个M
    public String forth(int digit) {
        StringBuilder builder = new StringBuilder();
        if (digit > 3) {
            return "error";
        } else {
            while (digit > 0) {
                builder.append("M");
                digit--;
            }
        }
        return builder.toString();
    }

    // 3位数开始, 900是CM(1000-100) 800是500+300(DCCC) 500是D 400是500-100(CD) 300到后面一依次是CCC、CC、C
    public String third(int num) {
        StringBuilder builder = new StringBuilder();
        if (num == 9) {
            builder.append("CM");
        } else if (num >= 5) {
            builder.append("D");
            int delta = num - 5;
            while (delta > 0) {
                builder.append("C");
                delta--;
            }
        } else if (num == 4) {
            builder.append("CD");
        } else {
            while (num > 0) {
                builder.append("C");
                num--;
            }
        }
        return builder.toString();
    }

    // 2位数开始, 90是100-10(XC) 80是50+30(LXXX) 70是50+2个L 50(L) 40是50-1个L(XL) 30到10依次是XXX、XX、X
    public String second(int num) {
        StringBuilder builder = new StringBuilder();
        if (num == 9) {
            builder.append("XC");
        } else if (num >= 5) {
            builder.append("L");
            int delta = num - 5;
            while (delta > 0) {
                builder.append("X");
                delta--;
            }
        } else if (num == 4) {
            builder.append("XL");
        } else {
            while (num > 0) {
                builder.append("X");
                num--;
            }
        }
        return builder.toString();
    }

    // 个位数开始 除了9较为特殊是10-1 IX 中间的都是 X加上差数个I 4是IV 3后面都是III、II、I
    public String singleDigit(int num) {
        StringBuilder builder = new StringBuilder();
        if (num > 9)
            return "error";
        switch (num) {
            case 0:
                return "";
            case 1:
            case 2:
            case 3:
                return IRepeat(num);
            case 4:
                return "IV";
            case 5:
            case 6:
            case 7:
            case 8:
                int delta = num - 5;
                builder.append("V");
                while (delta > 0) {
                    builder.append("I");
                    delta--;
                }
                break;
            case 9:
                return "IX";
            default:
                return "error";
        }
        return builder.toString();
    }

    public String IRepeat(int num) {
        StringBuilder builder = new StringBuilder();
        while (num > 0) {
            builder.append("I");
            num--;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Romanor romanor = new Romanor();
        String singleDigitTest = romanor.intToRoman(60);
        System.out.println(singleDigitTest);
    }
}
// 执行用时： 9 ms , 在所有 Java 提交中击败了 11.56% 的用户
// https://leetcode-cn.com/problems/integer-to-roman/
