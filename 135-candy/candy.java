class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 1)
            return 1;
        int[] ans = new int[ratings.length];
        Arrays.fill(ans, 1);
        if (ratings[1] < ratings[0]) {
            ans[0] = 2;
        } else {
            ans[0] = 1;
        }

        if (ratings[ratings.length - 1] > ratings[ratings.length - 2]) {
            ans[ratings.length - 1] = 2;
        } else {
            ans[ratings.length - 1] = 1;
        }
        for (int i = 1; i < ratings.length - 1; i++) {
            if (ratings[i - 1] < ratings[i] && ratings[i + 1] < ratings[i]) {
                ans[i] = Math.max(ans[i - 1], ans[i + 1]) + 1;
            } else if (ratings[i] > ratings[i - 1]) {
                ans[i] = 1 + ans[i - 1];
            } else if (ratings[i] > ratings[i + 1]) {
                ans[i] = 1 + ans[i + 1];
            } else {
                ans[i] = 1;
            }
        }

        for (int i = ans.length - 2; i > 0; i--) {
            if (ratings[i] > ratings[i - 1] && ratings[i] > ratings[i + 1]) {
                ans[i] = Math.max(ans[i + 1], ans[i - 1]) + 1;
            } else if (ratings[i] > ratings[i - 1]) {
                ans[i] = 1 + ans[i - 1];
            } else if (ratings[i] > ratings[i + 1]) {
                ans[i] = 1 + ans[i + 1];
            } else {
                ans[i] = 1;
            }
        }

        if(ratings[0] > ratings[1]){
            ans[0] = 1 + ans[1];
        } 
        if(ratings[ratings.length - 1] > ratings[ratings.length - 2]){
            ans[ratings.length-1] = 1 + ans[ratings.length-2];
        }

        int a = 0;
        for (int i = 0; i < ratings.length; i++) {
            a += ans[i];
        }
        return a;
    }
}