package others;

import java.util.HashSet;

// Problem 73
// https://leetcode.com/problems/set-matrix-zeroes

public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> columns = new HashSet<>();
        HashSet<Integer> rows = new HashSet<>();

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j]==0) {
                    columns.add(j);
                    rows.add(i);
                }
            }
        }

        for(int i=0; i< matrix.length; i++)
            for(int j=0; j<matrix[0].length; j++)
                if(columns.contains(j) || rows.contains(i))
                    matrix[i][j] = 0;
    }

    public void setZeroes2(int[][] matrix) {
        boolean ok_r = false;
        boolean ok_c = false;

        for(int i=0; i<matrix.length; i++)
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j]==0) {
                    if(i == 0) ok_r = true;
                    if(j == 0) ok_c = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }

        for(int i=1; i<matrix.length; i++)
            for(int j=1; j<matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j]=0;
            }

        if(ok_c) {
            for(int i=0; i<matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        if(ok_r){
            for(int i=0; i<matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}



