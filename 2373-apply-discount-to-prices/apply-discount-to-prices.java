class Solution {
    public String discountPrices(String s, int discount) {
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '$') {
                if (i >= 1 && s.charAt(i - 1) != ' ') {
                    st.append(s.charAt(i));
                    continue;
                }
                int start = i;
                int l = i + 1;
                StringBuilder p = new StringBuilder();

                while (l < s.length() && Character.isDigit(s.charAt(l))) {
                    p.append(s.charAt(l));
                    l++;
                }
                if (p.length() > 0 && (l == s.length() || s.charAt(l) == ' ')) {
                    double price = Double.parseDouble(p.toString());
                    double newPrice = price * (100 - discount) / 100.0;
                    st.append("$");
                    st.append(String.format("%.2f", newPrice));
                    i = l - 1;
                } else {
                    st.append(s.charAt(i));
                }
            } else {
                st.append(s.charAt(i));
            }
        }

        return st.toString();
    }
}