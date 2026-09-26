class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        return ans(endTime.split(":")) - ans(startTime.split(":"));
    }
    public int ans(String[] str) {
        int cnt = 0;
        cnt += Integer.parseInt(str[0]) * 3600;
        cnt += Integer.parseInt(str[1]) * 60;
        cnt += Integer.parseInt(str[2]);
        return cnt;
    }
}