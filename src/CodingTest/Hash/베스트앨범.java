package CodingTest.Hash;

import java.util.*;

// 프로그래머스 고득점 알고리즘 Kit 해시 5번
/*
1. key     | value
   classic | 1450    --> Collections.sort()
   pop     | 3100

2. key     | value
           | key | value
   classic |  0  | 500
           |  2  | 150      --> Collections.sort()
           |  3  | 800
   pop     |  1  | 600      --> Collections.sort()
           |  4  | 2500
 */
public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> plays_total = new HashMap<>();
        Map<String, Map<Integer, Integer>> plays_index = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            if(!plays_total.containsKey(genres[i])) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                plays_total.put(genres[i], plays[i]);
                plays_index.put(genres[i], map);
            } else {
                plays_total.put(genres[i], plays_total.get(genres[i]) + plays[i]);
                plays_index.get(genres[i]).put(i, plays[i]);
            }
        }
        List<String> keySet = new ArrayList(plays_total.keySet());
        Collections.sort(keySet, (s1, s2) -> plays_total.get(s2) - plays_total.get(s1));
        for(String key : keySet) {
            Map<Integer, Integer> map = plays_index.get(key);
            List<Integer> index = new ArrayList(map.keySet());
            Collections.sort(index, (s1, s2) -> map.get(s2) - map.get(s1));
            answer.add(index.get(0));
            if(map.size() > 1) {
                answer.add(index.get(1));
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
