package BOJ.JGeun.kakao;

public class Kakao_Recruit {
	//answer에서 하나씩 빼는 형식으로 가보자.
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        String[][] content = getInfo(info);
        String[][] queryList = getQuery(query);

        for(int i=0; i<queryList.length; i++){
            for(int j=0; j<content.length; j++){
                if((queryList[i][0].equals("-") || queryList[i][0].equals(content[j][0]))
                   && (queryList[i][2].equals("-") || queryList[i][2].equals(content[j][1]))
                   && (queryList[i][4].equals("-") || queryList[i][4].equals(content[j][2]))
                   && (queryList[i][6].equals("-") || queryList[i][6].equals(content[j][3])))
                    if(Integer.parseInt(content[j][4]) >= Integer.parseInt(queryList[i][7]))
                            answer[i]+=1;

            }
        }
        return answer;
    }
    private String[][] getInfo(String[] info){
        String[][] content = new String[info.length][];
       for(int i=0; i<info.length; i++)
           content[i] = info[i].split(" ");
       return content;
    }

    private String[][] getQuery(String[] query){
       String[][] queryList = new String[query.length][];
       for(int i=0; i<query.length; i++)
           queryList[i] = query[i].split(" ");

       return queryList;
    }
}
