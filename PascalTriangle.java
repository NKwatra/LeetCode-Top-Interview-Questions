class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0)
            return ans;
        ans.add(new ArrayList<Integer>());
        ans.get(0).add(1);
        if (numRows == 1)
            return ans;
        ans.add(new ArrayList<>());
        ans.get(1).add(1);
        ans.get(1).add(1);
        for (int i = 2; i < numRows; i++) {
            ans.add(new ArrayList<>());
            for (int j = 0; j <= ans.get(i - 1).size(); j++) {
                if (j == 0 || j == ans.get(i - 1).size())
                    ans.get(i).add(1);
                else {
                    int num1 = ans.get(i - 1).get(j - 1);
                    int num2 = ans.get(i - 1).get(j);
                    ans.get(i).add(num1 + num2);
                }
            }
        }

        return ans;
    }
}