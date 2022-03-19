package Programmers.Kakao_Winter_Intership_2019;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Long, Long> roomMap = new HashMap();
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for(int i=0; i<room_number.length; i++){
            answer[i] = findEmptyRoom(room_number[i]);
        }

        return answer;
    }

    private long findEmptyRoom(long room_number){
        if(!roomMap.containsKey(room_number)){
            roomMap.put(room_number, room_number+1);
            return room_number;
        }

        long emptyRoom = findEmptyRoom(roomMap.get(room_number));
        roomMap.put(room_number, emptyRoom);
        return emptyRoom;
    }
}
