class Solution {
    public int minCost(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if(Arrays.equals(nums1 , nums2)) return 0;
        HashMap<Integer , Integer > hs = new HashMap<>();
        for(int x : nums1) hs.put(x , hs.getOrDefault(x , 0)+1);
        for(int x : nums2) hs.put(x , hs.getOrDefault(x , 0)-1);
        long diff = 0;
        for(int v : hs.values()){
            if(Math.abs(v)%2!=0) return -1;
            diff += Math.abs(v);
        }
        // int ct = 0;
        // for(int i = 0 ; i < nums1.length ;i++){
        //     if(nums1[i] != nums2[i]) ct++;
        // }
        return (int)(diff/4);
    }
}