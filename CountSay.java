class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        StringBuilder sb = new StringBuilder();
        String prev = countAndSay(n - 1);
        int i = 0, freq = 0;
        char num = 0;
        while (i < prev.length()) {
            num = prev.charAt(i++);
            freq = 1;
            while (i < prev.length() && num == prev.charAt(i)) {
                freq++;
                i++;
            }

            sb.append(freq);
            sb.append(num);
        }

        return sb.toString();
    }
}