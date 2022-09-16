import java.util.*;
class Solution {
    private ArrayList<ArrayList<Path>> pathList = new ArrayList();
    private boolean[] isGate, isSummit, isVisited;
    private int[] answer = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
    PriorityQueue<Path> pq = new PriorityQueue<>();
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        init(n, paths, gates, summits);
        Arrays.sort(summits);

        for (int i=0; i<summits.length; i++) {
            pq.clear();
            isVisited = new boolean[n+1];
            int res = findIntensity(summits[i]);
            if (answer[1] > res) {
                answer[0] = summits[i];
                answer[1] = res;
            }
        }
        return answer;
    }

    private int findIntensity(int start) {
        pq.add(new Path(start, 0));
        int intensity = -1;

        while (!pq.isEmpty()) {
            Path path = pq.poll();
            if(isVisited[path.pos]) continue;
            isVisited[path.pos] = true;
            intensity = Math.max(intensity, path.intensity);

            if (isGate[path.pos]) return intensity;

            for (Path nextPath : pathList.get(path.pos)) {
                if(!isSummit[nextPath.pos] && !isVisited[nextPath.pos]) {
                    pq.add(nextPath);
                }
            }
        }
        return intensity;
    }

    private void init(int n, int[][] paths, int[] gates, int[] summits) {
        isGate = new boolean[n+1];
        isSummit = new boolean[n+1];

        for(int gate : gates)
            isGate[gate] = true;
        for (int summit : summits)
            isSummit[summit] = true;

        for (int i=0; i<=n; i++) pathList.add(new ArrayList());
        for (int i=0; i<paths.length; i++) {
            pathList.get(paths[i][0]).add(new Path(paths[i][1], paths[i][2]));
            pathList.get(paths[i][1]).add(new Path(paths[i][0], paths[i][2]));
        }
    }

    class Path implements Comparable<Path>{
        int pos, intensity;

        public Path(int pos, int intensity) {
            this.pos = pos;
            this.intensity = intensity;
        }

        @Override
        public int compareTo(Path p) {
            if(this.intensity != p.intensity) return this.intensity - p.intensity;
            return this.pos - p.pos;
        }
    }
}