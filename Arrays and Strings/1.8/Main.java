/**
 * Zero Matrix: Write an algorithm such that if an element in an M x N matrix is 0, its entire row and
 * column are set to 0.
 */

public class Main {
 
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {0, 3, 2, 0}
        };
        zeroMatrix(matrix);
        printMatrix(matrix);
    }

    /** Solution using arrays to save rows and columns with zeros */
    /** Optimal solution in O(N * M) time, because is necessary to iterate through all values of the matrix */
    public static void zeroMatrix(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        for (int i = 0; i < rows.length; i++) {
            if (rows[i] == 1) {
                zeroRow(matrix, i);
            }
        }
        for (int i = 0; i < cols.length; i++) {
            if (cols[i] == 1) {
                zeroColumn(matrix, i);
            }
        }
    }

    public static void zeroColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }

    public static void zeroRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    /** Utility print matrix function */
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
