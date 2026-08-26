class Solution {
    public int largestAltitude(int[] gain) {
        int res = 0, curr = 0;
        for (int x : gain) {
            curr += x;
            res = Math.max(res, curr);
        }
        return res;
    }
}
