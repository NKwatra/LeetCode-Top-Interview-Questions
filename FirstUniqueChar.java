class Solution {
    public int firstUniqChar(String s) {
        long[] freq = new long[26];
        Arrays.fill(freq, -1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (freq[ch - 'a'] == -1)
                freq[ch - 'a'] = i;
            else
                freq[ch - 'a'] = s.length();
        }

        for (char ch : s.toCharArray()) {
            if (freq[ch - 'a'] >= 0 && freq[ch - 'a'] < s.length())
                return (int) freq[ch - 'a'];
        }

        return -1;

    }
}