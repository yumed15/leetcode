package others;



/*
* 0 0 0 1 1
* 0 0 0 1 0
* 0 0 0 0 0
* 1 0 0 0 0
* 1 1 1 0 0
*/

// int[][] matrix = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 0, 0}};

import java.util.ArrayList;

class Position {
    int row;
    int column;

    Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
public class Islands {

    int[][] visited;
    ArrayList<Position> islands = new ArrayList<>();

    void processNeighbours(int row, int column, int[][] matrix) {
        if(column>1 && matrix[row][column-1]==1 && visited[row][column-1]==0) {
            islands.add(new Position(row,column-1));
            visited[row][column-1] = 1;
        }

        if(column<matrix[0].length-1 && matrix[row][column+1]==1 && visited[row][column+1]==0) {
            islands.add(new Position(row,column+1));
            visited[row][column+1] = 1;
        }

        if(row>1 && matrix[row-1][column]==1 && visited[row-1][column]==0) {
            islands.add(new Position(row-1,column));
            visited[row-1][column] = 1;
        }

        if(row<matrix.length-1 && matrix[row+1][column]==1 && visited[row+1][column]==0) {
            islands.add(new Position(row+1,column));
            visited[row+1][column] = 1;
        }
    }

    void processAllNeighbours(int row, int column, int[][] matrix) {
        int old_size = islands.size();
        for(int i=0; i<old_size; i++) {
            processNeighbours(islands.get(i).row, islands.get(i).column, matrix);
            if(old_size!=islands.size()) {
                old_size = islands.size();
                i--;
            }
        }
    }

    public int count(int[][] matrix) {
        int count = 0;
        visited = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(visited[i][j]==0 && matrix[i][j]==1) {
                    islands.add(new Position(i,j));
                    visited[i][j]=1;
                    processAllNeighbours(i, j, matrix);
                    count++;
                }
            }
        }
        return count;
    }
}
