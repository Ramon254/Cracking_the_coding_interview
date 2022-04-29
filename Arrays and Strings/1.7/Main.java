/**
 * Rotate Matrix: Given an image represented by an N x N matrix, where each pixel in the image is represented
 * by an integer, write a method to rotate the image by 90 degrees. Can you do this in place?.
 */

public class Main {
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        rotate(matrix);
        printMatrix(matrix);
    }

    /** Solution rotating the values in place */
    /** Optimal solution in O(N^2) time, because is necessary to iterate through all values of the matrix */
    public static void rotate(int[][] matrix) {
        if (matrix.length <= 0 || matrix.length != matrix[0].length) return;
        int n = matrix.length;
        int layers = (n % 2 == 0) ? (n / 2) : (n / 2) + 1;
        n -= 1;
        for (int i = 0; i < layers; i++) {
            int offset = 0;
            for (int j = i; j < n; j++) {
                int change = 0, aux = 0;
                // Top
                change = matrix[i][j];
                aux = matrix[j][n];
                matrix[j][n] = change;
                // Right
                change = aux;
                aux = matrix[n][n - offset];
                matrix[n][n - offset] = change;
                // Bottom
                change = aux;
                aux = matrix[n - offset][i];
                matrix[n - offset][i] = change;
                // Left
                change = aux;
                matrix[i][j] = change;
                offset++;
            }
            n--;
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
