class Solution {
    public int lengthOfLongestSubstring(String s) {
        int head = 0;
        int tail = 0;
        int longest = 0;
        String temp = "";

        if(s.length() < 2){
            return s.length();
        }

        while (tail < s.length()){
            if(temp.contains(String.valueOf(s.charAt(tail)))){
                if(longest < tail-head){
                    longest = tail-head;
                }
                temp = "";
                head += 1;
                tail = head;
            }
            temp += s.charAt(tail);
            tail += 1;
        }

        if(longest < tail-head){
            longest = tail-head;
        }
        return longest;
    }
}

## What i thought of in the first time, is that getting 1 head and 1 tail to track the String. get a tempStr to record down also. If the char is not in the tempStr, add it in, otherwise, reset the tempStr and move the head to next char. This method is quite dumb. Its already O(N^2).

## Better solution
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
