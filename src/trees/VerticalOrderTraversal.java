package trees;

import java.util.*;

// problem 987
public class VerticalOrderTraversal {
    // map<column<row,value>>
    HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> col_map = new HashMap<>();

    public int traverse(TreeNode root, int row, int col) {
        if (root==null) return 1;

        if(!col_map.containsKey(col)) {
            HashMap<Integer, ArrayList<Integer>> row_map = new HashMap<>();
            row_map.put(row, new ArrayList<>(List.of(root.val)));
            col_map.put(col, row_map);
        }
        else {
            HashMap<Integer, ArrayList<Integer>> rows = col_map.get(col);
            if(!rows.containsKey(row)) {
                rows.put(row, new ArrayList<>(List.of(root.val)));
            } else {
                ArrayList<Integer> aux = rows.get(row);
                aux.add(root.val);
                rows.put(row, aux);
            }
            col_map.put(col, rows);
        }

        return 1 + Math.max(traverse(root.left, row+1, col-1),traverse(root.right, row+1, col+1));
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        int height = traverse(root, 0, 0);

        for(int i=-height; i<height; i++){
            if(col_map.containsKey(i)) {
                List<Integer> rows_added = new ArrayList<>();
                for (Map.Entry<Integer, ArrayList<Integer>> map : col_map.get(i).entrySet()) {
                    ArrayList<Integer> row = map.getValue();
                    Collections.sort(row);
                    rows_added.addAll(row);
                }
                res.add(rows_added);
            }
        }

        return res;
    }
}
