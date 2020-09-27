class Solution {
    public int romanToInt(String s) {
        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> value = new HashMap<>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };

        HashMap<Character, Integer> Priority = new HashMap<>() {
            {
                put('I', 1);
                put('V', 2);
                put('X', 3);
                put('L', 4);
                put('C', 5);
                put('D', 6);
                put('M', 7);
            }
        };

        if (s.length() == 1)
            return value.getOrDefault(s.charAt(0), 0);

        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (Priority.get(s.charAt(i)) >= Priority.get(s.charAt(i + 1)))
                ans += value.get(s.charAt(i));
            else
                ans -= value.get(s.charAt(i));
        }

        ans += value.get(s.charAt(s.length() - 1));
        return ans;
    }
}