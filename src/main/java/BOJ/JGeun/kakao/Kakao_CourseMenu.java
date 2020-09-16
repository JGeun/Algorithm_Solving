package BOJ.JGeun.kakao;

import java.util.*;

public class Kakao_CourseMenu {
	int[] visit;
    int maxCount;
    ArrayList<String> makeCourse = new ArrayList<>();
    ArrayList<String> orderTemp = new ArrayList<>();
    public static void main(String[] args) {
        String[] ret = new Kakao_CourseMenu().solution(new String[] { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" },
            new int[] { 2, 3, 4 });
        for (String s : ret)
          System.out.println(s);
      }
    public String[] solution(String[] orders, int[] course) {  
        for (int i = 0; i < course.length; i++) {
			maxCount = 0;
			for (int j = 0; j < orders.length; j++) {
				if (course[i] > orders[j].length())
					continue;
				visit = new int[course[i] + 1];
				visit[0] = -1;
				getCourseOrder(orders, orders[j], 0);
			}
			for (int k = 0; k < orderTemp.size(); k++) {
				if (!makeCourse.contains(orderTemp.get(k)))
					makeCourse.add(orderTemp.get(k));
			}
		}
		Collections.sort(makeCourse);
        
       String[] answer = new String[makeCourse.size()];
        for(int i=0; i<makeCourse.size(); i++)
            answer[i] = makeCourse.get(i);
        return answer;
    }
    
    private void getCourseOrder(String[] orders, String order,int d){
        if (d == visit.length - 1) {
			String course = "";
			for (int i = 1; i < visit.length; i++)
				course += Character.toString(order.charAt(visit[i]));
			int count = orders.length;
			for (int i = 0; i < orders.length; i++) {
				for (int j = 0; j < course.length(); j++) {
					char ch = course.charAt(j);
					boolean isGetChar = false;
					for (int k = 0; k < orders[i].length(); k++) {
						if (orders[i].charAt(k) == ch) {
							isGetChar = true;
							break;
						}
					}
					if (!isGetChar) {
						count -= 1;
						break;
					}
				}
			}
			char[] charArray = course.toCharArray();
			Arrays.sort(charArray);
			course = String.valueOf(charArray);
			
			if (count >= 2) {
				if (maxCount < count) {
					maxCount = count;
					orderTemp.clear();
					if (!orderTemp.contains(course))
						orderTemp.add(course);
				} else if (maxCount == count)
					if (!orderTemp.contains(course))
						orderTemp.add(course);
			}
			return;
        }
        for (int i = visit[d] + 1; i < order.length(); i++) {
			visit[d + 1] = i;
			getCourseOrder(orders, order, d + 1);
		}
        return;
    }
}
