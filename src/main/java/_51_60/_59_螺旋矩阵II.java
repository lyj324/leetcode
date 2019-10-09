package _51_60;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/9 19:31
 */
public class _59_螺旋矩阵II {
    public static void main(String[] args) {
        print(generateMatrix(5));
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix =new int[n][n];
        int num=0;
        for (int i = 0; i < n/2+n%2; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    if(matrix[i][k]==0){
                        matrix[i][k]=++num;
                    }
                }
                rotate(matrix);
            }
        }

        return matrix;
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        //转置矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        //print(matrix);
        //上下翻转每一行
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = tmp;
            }
        }
    }
    public static void print(int[][] matrix) {
        for (int i[]:matrix) {
            for (int n:i) {
                System.out.print(n+" ");
            }
            System.out.println("");
        }
    }
}
