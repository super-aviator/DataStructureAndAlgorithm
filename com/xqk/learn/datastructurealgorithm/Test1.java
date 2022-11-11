package algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author 熊乾坤
 * @date 2020-10-28 8:29
 */
public class Test1 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        int lenx = obstacleGrid.length, leny = obstacleGrid[0].length;
        boolean[][] visit = new boolean[lenx][leny];
        Map<List<Integer>, List<Integer>> prev = new HashMap<>();

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(Arrays.asList(0, 0));
        while (!queue.isEmpty()) {
            List<Integer> vertex = queue.poll();
            int x = vertex.get(0), y = vertex.get(1);
            if (x == lenx - 1 && y == leny - 1) {
                System.out.println(prev);
                path(prev, vertex);
                return res;
            }
            if (!visit[x][y] && obstacleGrid[x][y] != 1) {
                visit[x][y] = true;
                if (x < lenx - 1) {
                    List<Integer> next = Arrays.asList(x + 1, y);
                    queue.offer(next);
                    prev.put(next, vertex);
                }
                if (y < leny - 1) {
                    List<Integer> next = Arrays.asList(x, y + 1);
                    queue.offer(next);
                    prev.put(next, vertex);
                }
            }
        }
        return Collections.emptyList();
    }

    public void path(Map<List<Integer>, List<Integer>> prev, List<Integer> curr) {
        int x = curr.get(0), y = curr.get(1);
        if (x != 0 || y != 0) {
            path(prev, prev.get(curr));
        }
        res.add(curr);
    }

    public static void main(String[] args) {
        Test1 t=new Test1();
        System.out.println(t.pathWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
}
