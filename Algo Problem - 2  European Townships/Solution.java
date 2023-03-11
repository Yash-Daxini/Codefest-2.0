import java.io.*;

class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = null;

        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(".\\ET_small.txt"));

            bw = new BufferedWriter(new FileWriter(".\\OutputET_small.txt"));

            int te = Integer.parseInt(br.readLine());

            while (te-- > 0) {

                int t = Integer.parseInt(br.readLine());

                double totalHours = 0;

                double totalAccentColor = 0;

                double totalNormalColor = 0;

                while( t-- > 0 ){

                    String st [] = br.readLine().split(",");

                    Integer.parseInt(st[0]);
                    int r = Integer.parseInt(st[1]);
                    int s = Integer.parseInt(st[2]);
                    int h = Integer.parseInt(st[3]);

                    double accentWalls = (h * 6 + s * 4 + r * 3) / 3.0;

                    double accentWallsHours = accentWalls * 2.5;

                    double accentWallsQuantity = accentWalls * 1.5;

                    double normalWalls = (h * 6 + s * 4 + r * 3) * 2 / 3.0;

                    double normalWallsHours = normalWalls * 3.25;

                    double normalWallsQuantity = normalWalls * 2.25;

                    totalHours += normalWallsHours + accentWallsHours;

                    totalAccentColor += accentWallsQuantity;

                    totalNormalColor += normalWallsQuantity;

                }
                
                bw.write( String.format("%.2f", totalHours) + ", " + String.format("%.2f", totalAccentColor) + ", " + String.format("%.2f", totalNormalColor) + "\n" );

            }
        } catch (Exception e) {

        }

        br.close();
        bw.close();

    }
}