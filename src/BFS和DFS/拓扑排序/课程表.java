package BFS和DFS.拓扑排序;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 课程表 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjs = new List[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            adjs[i] = new ArrayList<>();
        }
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            adjs[prerequisites[i][1]].add(prerequisites[i][0]);
            indegrees[prerequisites[i][0]]++;
        }
        List<Integer> zeroInDegrees = new LinkedList<>();
        for (int i = 0; i < indegrees.length; ++i) {
            if (indegrees[i] == 0) {
                zeroInDegrees.add(i);
            }
        }
        int zeroInDegreesCount = 0;
        while (!zeroInDegrees.isEmpty()) {
            int coursei = zeroInDegrees.remove(0);
            zeroInDegreesCount++;
            for (Integer coursej : adjs[coursei]) {
                indegrees[coursej]--;
                if (indegrees[coursej] == 0) {
                    zeroInDegrees.add(coursej);
                }
            }
        }
        return zeroInDegreesCount == numCourses;
    }
}
