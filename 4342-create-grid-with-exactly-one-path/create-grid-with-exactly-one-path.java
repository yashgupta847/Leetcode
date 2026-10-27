class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];
        if(m == 1){
            String s = "";
            for(int i = 0 ; i < n ; i++){
                s += '.';
            }
            ans[0] = s;
            return ans ;
        }
        int k = 0;
        for(int i = 0 ; i < m-1 ; i++){
            String s = "";
            for(int j = 0 ; j < 1 ; j++){
                s += '.';
            }
            for(int j = 1 ; j < n ; j++){
                s += '#';
            }
            ans[k++] = s;
        }
        for(int i = m-1 ; i < m ; i++){
            String s = "";
            for(int j = 0 ; j < n ; j++){
                s += '.';
            }
            ans[m-1] = s;
        }
        return ans;
    }
}