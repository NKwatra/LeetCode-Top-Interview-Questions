class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> plusOneNum = new ArrayList<>();
        int carry = 0, sum = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            sum += digits[i] + carry;
            carry = sum / 10;
            sum %= 10;
            plusOneNum.add(sum);
            sum = 0;
        }

        if (carry != 0)
            plusOneNum.add(carry);

        Collections.reverse(plusOneNum);
        int[] ans = new int[plusOneNum.size()];
        for (int i = 0; i < ans.length; i++)
            ans[i] = plusOneNum.get(i);
        return ans;
    }
}