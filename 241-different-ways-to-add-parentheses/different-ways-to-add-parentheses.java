class Solution {
    public boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*');
    }

    public List<Integer> getDiffWays(int i, int j, String expression) {
        int len = j - i + 1;
        List<Integer> res = new ArrayList<>();
        if (len <= 2) {
            res.add(Integer.parseInt(expression.substring(i, i + len)));
            return res;
        }
        for (int ind = i; ind <= j; ind++) {
            if (isOperator(expression.charAt(ind))) {
                char op = expression.charAt(ind);
                List<Integer> left = getDiffWays(i, ind - 1, expression);
                List<Integer> right = getDiffWays(ind + 1, j, expression);
                for (int l : left) {
                    for (int r : right) {
                        if (op == '+') {
                            res.add(l + r);
                        } else if (op == '-') {
                            res.add(l - r);
                        } else if (op == '*') {
                            res.add(l * r);
                        }
                    }
                }
            }
        }
        return res;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        return getDiffWays(0, n - 1, expression);
    }
}