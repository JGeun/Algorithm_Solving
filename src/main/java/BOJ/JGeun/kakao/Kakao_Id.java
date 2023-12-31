package BOJ.JGeun.kakao;

public class Kakao_Id {
	public static void main(String[] args) {
		System.out.println(new Kakao_Id().solution(".../qwefafsdfadsfadsf-.."));
	}
	public String solution(String new_id) {
        String answer = getId(new_id);
        return answer;
    }
    private String getId(String new_id){
        //1단계
        new_id = new_id.toLowerCase(); 
        
        //2단계, 3단계
        StringBuilder sb = new StringBuilder();
        boolean isGetForeDot = false;
        for(int i=0; i<new_id.length(); i++){
            char ch = new_id.charAt(i);
            if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <='z') || ch =='_' || ch == '-'){
                sb.append(new_id.substring(i,i+1));
                isGetForeDot = false;
            }
            else if(ch == '.' && !isGetForeDot){
                sb.append(new_id.substring(i,i+1));
                isGetForeDot = true;
            }
        }
        new_id = sb.toString();
        
        //4단계
        if(new_id.charAt(0) == '.')
            new_id = new_id.substring(1, new_id.length());
        else if(new_id.charAt(new_id.length()-1) == '.')
            new_id = new_id.substring(0, new_id.length()-1);
        
        //5단계
        if(new_id.equals(""))
            new_id += "a";
        
        //6단계
        if(new_id.length() >= 16)
            new_id = new_id.substring(0, 15);
        if(new_id.charAt(new_id.length()-1) == '.')
            new_id = new_id.substring(0, new_id.length()-1);
        
        //7단계
        String last = new_id.substring(new_id.length()-1,new_id.length());
        while(new_id.length() <= 2){
            new_id += last;
        }
        return new_id;
    }
}
