class Solution {
    public void moveZeroes(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                q.add(nums[i]);
        }
        int i = 0 ;
        while(!q.isEmpty()){
            int a = q.poll();
            nums[i] = a;
            i++;
        }
        for(int j = i ; j < nums.length ; j++){
            nums[j] = 0;
        }

    }
}