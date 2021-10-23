package jin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * YearDaysCount：
 */
public class YearDaysCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请依次输入砍瓜年月日，每输入一次换行继续输入：");
        int yearFrom = scanner.nextInt();
        int monFrom = scanner.nextInt();
        int dayFrom = scanner.nextInt();
        System.out.println("请输入今天的年月日，每输入依次换行继续输入：");
        int yearEnd = scanner.nextInt();
        int monEnd = scanner.nextInt();
        int dayEnd = scanner.nextInt();

        // 头年截至天数：tmpCurDays
        int tmpCurDays = curDays(monFrom, dayFrom);
        if (yearDays(yearFrom) == 365)
            tmpCurDays -= 1;

        // 尾年截至天数：tmpEndYearDays
        int tmpEndYearDays = curDays(monEnd, dayEnd);
        if (yearDays(yearEnd) == 365)
            tmpEndYearDays -= 1;
        // 中间年数：middleDays
        int middleDays = middleDays(yearFrom, yearEnd);
        int yearDaysFrom = yearDays(yearFrom);
        int realCurDays = yearDaysFrom - tmpCurDays;
        int res = realCurDays + middleDays + tmpEndYearDays;
        System.out.println("截至今天，华强卖瓜累计天数：" + res);

    }

    /**
     * 中间年和天数
     * */
    static int middleDays(int startYear, int endYear) {
        int middleDays = 0;
        int[] middleYearArr = new int[endYear - startYear];
        for (int i = startYear + 1, yearCount = 0; i <= endYear; i++, yearCount++) {
            middleYearArr[yearCount] = i;
            int yearDays = yearDays(middleYearArr[yearCount]);
            middleDays += yearDays;
        }
        return middleDays;
    }



    /**
     * 判断年的总天数
     */
    static int yearDays(int year) {
        if (year % 4 == 0 && year % 100 != 0)
            return 366;
        else if (year % 400 == 0)
            return 366;
        else
            return 365;
    }

    /**
     * 判断月的总天数
     */
    static int monDays(int mon) {
        int monDays = 0;
        switch (mon) {
            case 1:
            case 3:
            case 4:
            case 7:
            case 8:
            case 10:
            case 12:
                monDays = 31;
                break;
            case 2:
                monDays = 29;
                break;
            default:
                monDays = 30;
        }
        return monDays;
    }

    /**
     * 计算当前截至某月某日有几天
     */
    static int curDays(int mon, int day) {
        List<Integer> olderMon = new ArrayList<>();
        // olderMon：用来装小月
        for (int i = 1; i < mon; i++) {
            olderMon.add(i);
        }
        int cnt = 0;
        // cnt：用来累计小月的天数和
        for (int i = 1; i <= olderMon.size(); i++) {
            int dayInMon = monDays(olderMon.get(i - 1));
            cnt += dayInMon;
        }
        int curDays = cnt + day;
        return curDays;
    }
}
