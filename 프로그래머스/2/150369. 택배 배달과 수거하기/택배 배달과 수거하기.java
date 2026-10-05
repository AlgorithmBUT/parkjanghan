class Solution {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        long delivery = 0;
        long pickup = 0;

        for (int i = n - 1; i >= 0; i--) {

            delivery += deliveries[i];
            pickup += pickups[i];

            if (delivery == 0 && pickup == 0) {
                continue;
            }

            long count = Math.max(
                (delivery + cap - 1) / cap,
                (pickup + cap - 1) / cap
            );

            answer += count * (i + 1) * 2;

            delivery -= count * cap;
            pickup -= count * cap;
        }

        return answer;
    }
}