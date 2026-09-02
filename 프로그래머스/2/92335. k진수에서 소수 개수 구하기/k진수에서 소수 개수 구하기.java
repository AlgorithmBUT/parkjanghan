class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String[] num = Integer.toString(n,k).split("0");

        for (int i=0; i<num.length; i++){
          if (num[i].isEmpty()){
            continue;
          } 

          if(isPrime(num[i])){
            answer++;
          }
        }

        return answer;
    }

    static boolean isPrime(String n){
      long num = Long.parseLong(n);

      if (num==1) return false;

      for (int i=2; i<=(int) Math.sqrt(num); i++){
        if (num%i==0) return false;
      }

      return true;
    }
}