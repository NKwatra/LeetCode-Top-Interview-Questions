class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() <= 1)
            return true;
        int i = 0, j = s.length() - 1;
        boolean palindrome = true;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                palindrome = false;
                break;
            }

            i++;
            j--;

        }

        return palindrome;
    }
}