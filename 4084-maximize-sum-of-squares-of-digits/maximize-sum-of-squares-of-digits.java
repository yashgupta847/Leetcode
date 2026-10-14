class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(num == 1 && sum >= 10){
            return "";
        } else if(num == 1){
            String ans = "";
            ans += Integer.toString(sum);
            return ans;
        }
        StringBuilder ans = new StringBuilder();
        for(int i = 0 ; i < num ; i++){
            for(int j = 9 ; j >= 0 ; j--){
                if(j <= sum){
                    sum -= j;
                    ans.append(Integer.toString(j));
                    break;
                }
                // else if(sum == 0){
                //     ans.append(Integer.toString(0));
                // }
            }
        }
        if(sum != 0) return "";
        return ans.toString();
    }
}