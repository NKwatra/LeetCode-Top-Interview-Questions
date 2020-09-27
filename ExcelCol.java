class Solution {
    public int titleToNumber(String s) {
        if (s.length() == 0)
            return 0;
        int columnNumber = 0, factor = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int num = s.charAt(i) - 64;
            columnNumber += (num * factor);
            factor *= 26;
        }

        return columnNumber;
    }
}