import java.io.*;


class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = null;

        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(".\\TMW_large.txt"));

            bw = new BufferedWriter(new FileWriter(".\\OutputTMW_large.txt"));

            int t = Integer.parseInt(br.readLine());

            while (t-- > 0) {

                String s = br.readLine();

                s = s.toLowerCase();
                s = s.replace(" ", "");
                s = s.replace("one", "1");
                s = s.replace("two", "2");
                s = s.replace("three", "3");
                s = s.replace("four", "4");
                s = s.replace("five", "5");
                s = s.replace("six", "6");
                s = s.replace("seven", "7");
                s = s.replace("eight", "8");
                s = s.replace("nine", "9");
                s = s.replace("plus", "+");
                s = s.replace("substract", "-");
                s = s.replace("multiple", "*");
                s = s.replace("division", "/");
                s = s.replace("equals", "=");

                String strs[] = s.split("=");

                double res = Character.getNumericValue(strs[0].charAt(0));

                for (int i = 1; i < strs[0].length() - 1; i += 2) {
                    char opr = strs[0].charAt(i);
                    char opd = strs[0].charAt(i + 1);

                    if (opr == '+')
                        res += opd - '0';
                    else if (opr == '-')
                        res -= opd - '0';
                    else if (opr == '*')
                        res *= opd - '0';
                    else if (opr == '/')
                        res /= opd - '0';

                }

                if (res == Double.valueOf(strs[1]) * 1.0) {
                    bw.write(true + "\n");
                } else {
                    bw.write(false + "\n");
                }

            }
        } catch (Exception e) {

        }

        br.close();
        bw.close();

    }
}