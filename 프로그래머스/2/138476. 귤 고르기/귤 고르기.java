import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> mp = new HashMap<>();

		for (int i = 0; i < tangerine.length; i++) {
			int tang = tangerine[i];
			if (mp.containsKey(tang)) {
				mp.put(tang, mp.get(tang) + 1);
			} else {
				mp.put(tang, 1);
			}
		}
		
		List<int[]> list = new ArrayList<>();
		
		for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
			list.add(new int[] {e.getKey(), e.getValue()});
		}
		
		list.sort((a, b) -> {
			return a[1] - b[1];
		});

		int answer = 0;
        
		for (int i = list.size() - 1; i >= 0; i--) {
			// System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
			if (k > list.get(i)[1]) {
				answer++;
				k -= list.get(i)[1];
			} else {
				answer++;
				break;
			}
		}
		
		System.out.println(answer);
        
        return answer;
    }
}