package _51_60;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/8 18:39
 */

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _54_螺旋矩阵 {
    /**
     * 每次输出第一行，逆时针旋转
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        List<Integer> list = spiralOrder(matrix);
        System.out.println(list);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix.length==0) {
            return list;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            list.add(matrix[0][i]);
        }
        if(matrix.length==1){
            return list;
        }
        int num=matrix.length*matrix[0].length;
        while (true){
            matrix=removeAndTurnLeft(matrix);
            for (int i = 0; i < matrix[0].length; i++) {
                list.add(matrix[0][i]);
            }
            if (list.size()==num){
                break;
            }
        }
        return list;
    }
    //新的行列长度
    public static int[] newRowAndcolumn(int row,int column){
        row--;
        row=row^column;
        column=row^column;
        row=row^column;
        int[] res={row,column};
        return res;
    }
    //去除补齐位
    public static int[][] put2(int[][] matrix,int row,int column){
        int [][] matrix2=new int[row][column];
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                if(row<column){
                    matrix2[i][j]=matrix[i-row+column][j];
                }else {
                    matrix2[i][j]=matrix[i][j];
                }
            }
        }
        return matrix2;
    }
    //n*m举证放入m*(n-1)矩阵
    public static int[][] put(int[][] matrix,int row,int column){
        int [][] matrix2=new int[row][column];
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                matrix2[i][j]=matrix[i+1][j];
            }
        }
        return matrix2;
    }
    //n*m矩阵补齐为x*x矩阵
    public static int[][] completion(int[][] matrix){
        int n=Math.max(matrix.length,matrix[0].length);
        int[][] matrix2=new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                matrix2[i][j]=matrix[i][j];
            }
        }
        return matrix2;
    }
    //转置矩阵
    public static void transpose(int[][] matrix){
        int n=matrix.length;
        for (int i = 0; i <n ; i++) {
            for (int j = i; j <n ; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
    //上下翻转矩阵
    public static void overTurn(int[][] matrix){
        int n=matrix.length;
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = tmp;
            }
        }
    }
    //打印矩阵
    public static void print(int[][] matrix){
        for (int[] nums:matrix) {
            for (int num:nums) {
                System.out.print(num+" ");
            }
            System.out.println("");
        }
    }
    //去除第一行，向左旋转90°
    private static int[][] removeAndTurnLeft(int[][] matrix) {
        int row=matrix.length,column=matrix[0].length;
        int[] ints = newRowAndcolumn(row, column);
        row=ints[0];
        column=ints[1];
        int[][] put = put(matrix,column,row);
        int[][] completion = completion(put);
        transpose(completion);
        overTurn(completion);
        int[][] ints1 = put2(completion, row, column);
        return ints1;
    }
}
