package jin;

import java.util.Arrays;

public class SodokuOrNot {

    public boolean isValidSudoku(char[][] board) {
        boolean sudokuFlag = true;
        for (int i = 0; i < board.length; i++) {
            // 扫描行
            char[] row = Arrays.copyOf(board[i], board[i].length); // 用替身去排序判断（原数组）
            // System.out.println("行？" + Arrays.toString(board[i]));
            if (isRepeat(row)) {
                sudokuFlag = false;
                break;
            }
            // 扫描列
            char[] col = new char[9];
            for (int j = 0; j < board[i].length; j++) {
                col[j] = board[j][i];    // 调换行列c
            }
            // System.out.println("列？" + Arrays.toString(col));
            if (isRepeat(col)) {
                sudokuFlag = false;
                break;
            }
        }
        if (sudokuFlag) {
            // 扫描块
            char[] field1 = arrField(board, 0, 0);
            char[] field2 = arrField(board, 0, 3);
            char[] field3 = arrField(board, 0, 6);
            char[] field4 = arrField(board, 3, 0);
            char[] field5 = arrField(board, 3, 3);
            char[] field6 = arrField(board, 3, 6);
            char[] field7 = arrField(board, 6, 0);
            char[] field8 = arrField(board, 6, 3);
            char[] field9 = arrField(board, 6, 6);
            if (isRepeat(field1) || isRepeat(field2) || isRepeat(field3) ||
                    isRepeat(field4) || isRepeat(field5) || isRepeat(field6) ||
                    isRepeat(field7) || isRepeat(field8) || isRepeat(field9)) {
                sudokuFlag = false;
            }
        }
        return sudokuFlag;
    }

    // 验证一个数组是否有重复的数据
    public boolean isRepeat(char[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if ( arr[i] != '.' && arr[i] == arr[i + 1]) {    // arr[i] != '.'  . 之间相同也需要排除
                return true;
            }
        }
        return false;
    }

    // 传一个起点坐标，返回一个以该坐标往右下9*9域内的值组成的行数组
    public char[] arrField(char[][] arr, int startRow, int startCol) {
        // 总是返回1*9的数组
        char[] fieldArr = new char[9];
        int cnt = 0;
        /**
         * startRow/startCol：起点坐标
         * cnt：行数组计数器
         * */
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                char item = arr[i][j];
                fieldArr[cnt++] = item;
            }
        }
        return fieldArr;
    }

    public static void main(String[] args) {
        char[] a1 = {'8', '3', '.', '.', '7', '.', '.', '.', '.'};
        char[] a2 = {'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        char[] a3 = {'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        char[] a4 = {'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        char[] a5 = {'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        char[] a6 = {'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        char[] a7 = {'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        char[] a8 = {'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        char[] a9 = {'.', '.', '.', '.', '8', '.', '.', '7', '9'};
        // System.out.println("空格的ascii码：" + (int) ' ');
        char[][] test = {a1, a2, a3, a4, a5, a6, a7, a8, a9};
        SodokuOrNot kid = new SodokuOrNot();
        boolean sudokuFlag = kid.isValidSudoku(test);
        System.out.println("'---'" + sudokuFlag);
        char[] field1 = kid.arrField(test, 0, 0);
        char[] field2 = kid.arrField(test, 0, 3);
        char[] field3 = kid.arrField(test, 0, 6);
        char[] field4 = kid.arrField(test, 3, 0);
        char[] field5 = kid.arrField(test, 3, 3);
        char[] field6 = kid.arrField(test, 3, 6);
        char[] field7 = kid.arrField(test, 6, 0);
        char[] field8 = kid.arrField(test, 6, 3);
        char[] field9 = kid.arrField(test, 6, 6);
        // System.out.println(Arrays.toString(field1));
        // System.out.println(Arrays.toString(field2));
        // System.out.println(Arrays.toString(field3));
        // System.out.println(Arrays.toString(field4));
        // System.out.println(Arrays.toString(field5));
        // System.out.println(Arrays.toString(field6));
        // System.out.println(Arrays.toString(field7));
        // System.out.println(Arrays.toString(field8));
        // System.out.println(Arrays.toString(field9));
    }
}
/**
 * 行：board[i]
 * 列：board[i][]
 * 子块：3*3
 * [5, 3, ., 6, ., ., ., 9, 8]
 * [., 7, ., 1, 9, 5, ., ., .]
 * [., ., ., ., ., ., ., 6, .]
 * [8, ., ., 4, ., ., 7, ., .]
 * [., 6, ., 8, ., 3, ., 2, .]
 * [., ., 3, ., ., 1, ., ., 6]
 * [., 6, ., ., ., ., ., ., .]
 * [., ., ., 4, 1, 9, ., 8, .]
 * [2, 8, ., ., ., 5, ., 7, 9]
 * 执行用时： 2 ms , 在所有 Java 提交中击败了 62.69% 的用户
 * 内存消耗： 38.8 MB , 在所有 Java 提交中击败了 5.04% 的用户
 */