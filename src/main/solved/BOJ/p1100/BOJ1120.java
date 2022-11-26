import java.util.Scanner;

class Main{
    static String X, Y;
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        X=sc.next(); Y=sc.next();

        int count, Min=50;
        for(int i=0; i<=Y.length()-X.length(); i++){
            count=0;
            String sub = Y.substring(i,i+X.length());
            for(int j=0; j<X.length(); j++)
                if(X.charAt(j)!=sub.charAt(j))
                    count+=1;
            if(Min>count)
                Min=count;
        }
        System.out.println(Min);
    }
}