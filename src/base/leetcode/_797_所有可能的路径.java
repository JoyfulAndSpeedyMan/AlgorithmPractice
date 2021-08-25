package base.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _797_所有可能的路径 {
    public static void main(String[] args) {
        _797_所有可能的路径 a797所有可能的路径 = new _797_所有可能的路径();
//        int[][] graph = {
//                {4, 3, 1},
//                {3, 2, 4},
//                {3},
//                {4},
//                {}};
        int[][] graph = {
                {1},
                {}
        };
        List<List<Integer>> paths = a797所有可能的路径.allPathsSourceTarget(graph);
        System.out.println(paths);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> dg = new ArrayList<>(graph.length);
        for (int[] ints : graph) {
            dg.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                int d = graph[i][j];
                List<Integer> ds= dg.get(d);
                ds.add(i);
            }
        }
        return allPathsSourceTarget(dg, dg.size() - 1);
    }

    public List<List<Integer>> allPathsSourceTarget(List<List<Integer>> dg, int target) {
        if(target == 0){
            List<List<Integer>> r = new LinkedList<>();
            List<Integer> e = new LinkedList<>();
            e.add(0);
            r.add(e);
            return r;
        }
        List<Integer> froms = dg.get(target);
        List<List<Integer>> result = null;
        for (int node : froms) {
            List<List<Integer>> fromResult = allPathsSourceTarget(dg, node);
            if(fromResult == null)
                continue;
            fromResult.forEach(e -> e.add(target));
            if(result != null)
                result.addAll(fromResult);
            else
                result = fromResult;
        }
        return result;
    }
}
