package BOJ.JGeun.p5500;

import java.util.Scanner;

public class BOJ5543 {
	static final int BURGER_NUMBER = 3;
    static final int DRINK_NUMBER = 2;
    
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] burger = new int[3];
        int[] drink = new int[2];

        for(int i=0; i<BURGER_NUMBER; i++)
            burger[i] = sc.nextInt();

        for(int i=0; i<DRINK_NUMBER; i++)
            drink[i] = sc.nextInt();

        int min_bug = burger[0];
        for(int i=1; i<BURGER_NUMBER; i++){
            if(min_bug > burger[i])
                min_bug = burger[i];
        }

        int min_dri = drink[0];
        if(min_dri > drink[1])
            min_dri = drink[1];

        System.out.println(min_bug+min_dri-50);
    }
}
