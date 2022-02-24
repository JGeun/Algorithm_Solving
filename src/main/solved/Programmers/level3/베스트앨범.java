package Programmers.level3;

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Data> genresMap = new HashMap();
        for(int i=0; i<genres.length; i++){
            Data data = new Data();
            if(genresMap.containsKey(genres[i])){
                data = ((Data)genresMap.get(genres[i]));
            }
            data.pq.add(new Song(i, plays[i]));
            data.totalPlay += plays[i];
            genresMap.put(genres[i], data);
        }

        ArrayList<Data> dataList = new ArrayList();
        for(String key : genresMap.keySet())
            dataList.add(genresMap.get(key));
        Collections.sort(dataList);

        ArrayList<Integer> playOrder = new ArrayList();
        for(Data data : dataList){
            PriorityQueue<Song> pq = data.getPQ();
            for(int i=0; i<2; i++){
                if(pq.isEmpty()) break;
                playOrder.add(pq.poll().getIdx());
            }
        }

        int[] answer = new int[playOrder.size()];
        for(int i=0; i<playOrder.size(); i++) answer[i] = playOrder.get(i);
        return answer;
    }
}

class Song implements Comparable<Song>{
    private int idx;
    private int play;

    public Song(int idx, int play){
        this.idx = idx;
        this.play = play;
    }

    @Override
    public int compareTo(Song s){
        if(this.play != s.play) return s.play - this.play;
        return this.idx - s.idx;
    }

    public int getIdx(){
        return idx;
    }
}

class Data implements Comparable<Data>{
    private PriorityQueue<Song> pq;
    private int totalPlay;

    public Data(){
        pq = new PriorityQueue();
        totalPlay = 0;
    }

    @Override
    public int compareTo(Data d){
        return d.totalPlay - this.totalPlay;
    }

    public PriorityQueue<Song> getPQ(){
        return pq;
    }
    public int getTotalPlay(){
        return totalPlay;
    }
}
