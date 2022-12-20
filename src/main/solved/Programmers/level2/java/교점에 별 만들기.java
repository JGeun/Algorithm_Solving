import java.util.*;

class Solution {
    private PriorityQueue<Point> pList= new PriorityQueue();
    private long l=Long.MAX_VALUE, r=Long.MIN_VALUE, t=Long.MAX_VALUE, b=Long.MIN_VALUE;
    public String[] solution(int[][] line) {
        getPointContact(line);
        int xSize = (int)Math.abs(r-l)+1, ySize = (int)Math.abs(b-t)+1;

        String[] answer = new String[ySize];
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<ySize; i++){
            sb.setLength(0);
            for(int j=0; j<xSize; j++) sb.append(".");
            while(!pList.isEmpty() && (int)(pList.peek().y-t) == i){
                sb.setCharAt((int)(pList.peek().x-l),'*');
                pList.poll();
            }
            answer[ySize-i-1] = sb.toString();
        }
        return answer;
    }

    public void getPointContact(int[][] line){
        for(int i=0; i<line.length-1; i++){
            for(int j=i+1; j<line.length; j++){
                double xValue = getXValue(line[i], line[j]);
                double yValue = getYValue(line[i], line[j]);

                if(xValue == (long)xValue && yValue == (long)yValue){
                    l = Math.min((long)xValue, l);
                    r = Math.max((long)xValue, r);
                    t = Math.min((long)yValue, t);
                    b = Math.max((long)yValue, b);
                    pList.add(new Point((long)xValue, (long)yValue));
                }
            }
        }
    }

    public double getXValue(int[] l1 ,int[] l2){
        return (double)((long)l1[1]*l2[2]-(long)l1[2]*l2[1])/((long)l1[0]*l2[1]-(long)l1[1]*l2[0]);
    }

    public double getYValue(int[] l1 ,int[] l2){
        return (double)((long)l1[2]*l2[0]-(long)l1[0]*l2[2])/((long)l1[0]*l2[1]-(long)l1[1]*l2[0]);
    }

    class Point implements Comparable<Point>{
        long x, y;
        Point(long x, long y){
            this.x = x; this.y = y;
        }

        @Override
        public int compareTo(Point p){
            if(this.y < p.y) return -1;
            else if(this.y > p.y) return 1;
            else{
                if(this.x < p.x) return -1;
                else if(this.x > p.x) return 1;
                else return 0;
            }
        }
    }
}