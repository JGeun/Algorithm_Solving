import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> extMap = initExtMap();
        List<int[]> extractDataList = new ArrayList<>();
        
        int extIdx = extMap.get(ext);
        for (int i = 0; i < data.length; i++)  {
            if (data[i][extIdx] < val_ext) {
                extractDataList.add(data[i]);
            }
        }
        
        int sortIdx = extMap.get(sort_by);
        Collections.sort(extractDataList, Comparator.comparingInt(a -> a[sortIdx]));
        return extractDataList.toArray(new int[extractDataList.size()][]);
    }
    
    private Map<String, Integer> initExtMap() {
        Map<String, Integer> extMap = new HashMap<>();
        
        extMap.put("code", 0);
        extMap.put("date", 1);
        extMap.put("maximum", 2);
        extMap.put("remain", 3);
        
        return extMap;
    }
}