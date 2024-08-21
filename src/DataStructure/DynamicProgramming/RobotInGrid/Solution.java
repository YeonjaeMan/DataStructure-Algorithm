package DataStructure.DynamicProgramming.RobotInGrid;

import java.util.ArrayList;

// Q : A robot is sitting on the upper left corner of a grid.
//     The robot can only move in two directions, right and down.
//     certain cells are "off limits" such that the robot cannot step on them.
//     Design and algorithm to find a path for the robot from the top left to the bottom right.
public class Solution {
    public ArrayList<Point> findPath(boolean[][] grid) {
        // null 체크
        if(grid == null || grid.length == 0) {
            return null;
        }
        // 경로를 저장할 객체 생성
        ArrayList<Point> path = new ArrayList<>();
        // 재귀 호출
        if(findPath(grid, grid.length - 1, grid[0].length - 1, path)) {
            return path;
        } else {
            return null;
        }
    }

    private boolean findPath(boolean[][] grid, int row, int col, ArrayList<Point> path) {
        // 범위를 벗어나거나 막혀있을 경우 false 반환
        if(!isInRange(grid, row, col) || grid[row][col]) {
            return false;
        }
        // 시작지점에 도착하거나, 왼쪽 영역부터 이동해서 확인하고, 아니면 오른쪽 영역으로 이동
        if((row == 0 && col == 0) || findPath(grid, row, col - 1, path) || findPath(grid, row - 1, col, path)) {
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }
        return false;
    }

    private boolean isInRange(boolean[][] grid, int row, int col) {
        return row >= 0 && row <= grid.length - 1 && col >= 0 && col <= grid[row].length - 1;
    }
}
