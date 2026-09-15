import java.util.*;

class Solution {

    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<Character>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // If character already exists,
            // remove characters from the left
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current character
            set.add(s.charAt(right));

            // Calculate current window length
            int currentLength = right - left + 1;

            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }

        return maxLength;
    }
}
