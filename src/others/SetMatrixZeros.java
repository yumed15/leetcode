package others;

import java.util.HashSet;

// problem 73
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
}



