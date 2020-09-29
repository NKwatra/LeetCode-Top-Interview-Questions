class Solution {
    public int calculate(String s) {
        if (s.length() == 0)
            return 0;
        if (s.length() == 1)
            return Integer.parseInt(s);
        List<String> tokens = generateTokens(s);
        List<String> newTokens = evaluateMultiplications(tokens);
        long ans = 0;
        for (int i = 0; i < newTokens.size(); i++) {
            if (newTokens.get(i).equals("+") || newTokens.get(i).equals("-")) {
                ans = newTokens.get(i).equals("-") ? ans - Integer.parseInt(newTokens.get(++i))
                        : ans + Integer.parseInt(newTokens.get(++i));
            } else {
                ans += Integer.parseInt(newTokens.get(i));
            }
        }

        return (int) ans;
    }

    public List<String> evaluateMultiplications(List<String> tokens) {
        List<String> newTokens = new ArrayList<>();
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            if (token.equals("*") || token.equals("/")) {
                int num1 = Integer.parseInt(newTokens.get(newTokens.size() - 1));
                newTokens.remove(newTokens.size() - 1);
                int num2 = Integer.parseInt(tokens.get(++i));
                boolean multiply = token.equals("*");
                newTokens.add(String.valueOf(multiply ? num1 * num2 : num1 / num2));
            } else {
                newTokens.add(token);
            }
        }

        return newTokens;
    }

    public List<String> generateTokens(String s) {
        List<String> tokens = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '+':
                    if (sb.length() > 0) {
                        tokens.add(sb.toString());
                        sb.delete(0, sb.length());
                    }
                    tokens.add("+");
                    break;
                case '-':
                    if (sb.length() > 0) {
                        tokens.add(sb.toString());
                        sb.delete(0, sb.length());
                    }
                    tokens.add("-");
                    break;
                case '*':
                    if (sb.length() > 0) {
                        tokens.add(sb.toString());
                        sb.delete(0, sb.length());
                    }
                    tokens.add("*");
                    break;
                case '/':
                    if (sb.length() > 0) {
                        tokens.add(sb.toString());
                        sb.delete(0, sb.length());
                    }
                    tokens.add("/");
                    break;
                case ' ':
                    continue;
                default:
                    sb.append(s.charAt(i));
            }
        }

        if (sb.length() > 0)
            tokens.add(sb.toString());

        return tokens;
    }
}