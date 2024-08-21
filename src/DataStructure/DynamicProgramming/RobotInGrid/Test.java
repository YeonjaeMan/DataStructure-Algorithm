package DataStructure.DynamicProgramming.RobotInGrid;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        boolean[][] grid = {
                {false, false, false, false},
                {false, false, false, true},
                {true, true, false, false},
                {false, false, false, false}
        };
        Solution sol = new Solution();
        ArrayList<Point> path = sol.findPath(grid);
        if(path != null)
            for(Point p : path)
                System.out.print(p.row + "" + p.col + " -> ");
    }
}
