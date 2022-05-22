import java.util.*;

class Solution {
    private Map<String, String> idMap = new HashMap();

    public String[] solution(String[] record) {
        List<String[]> records = new ArrayList(record.length);
        for(String r : record) {
            String[] content = r.split(" ");
            if(!content[0].equals("Leave"))
                idMap.put(content[1], content[2]);
            if(!content[0].equals("Change"))
                records.add(content);
        }

        String[] answer = new String[records.size()];
        for(int i=0; i<records.size(); i++) {
            String[] content = records.get(i);
            String nickName = idMap.get(content[1]);
            answer[i] = content[0].equals("Enter") ?
                nickName + "님이 들어왔습니다." :
                nickName + "님이 나갔습니다.";
        }

        return answer;
    }
}