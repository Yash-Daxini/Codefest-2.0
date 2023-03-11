
import java.io.*;
import java.util.*;


class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = null;

        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(".\\TWSP_small.txt"));

            bw = new BufferedWriter(new FileWriter(".\\OutputTWSP_small.txt"));

            int t = Integer.parseInt(br.readLine());

            List<List<Integer>> ans = new ArrayList<>();

            while (t-- > 0) {

                    String str = br.readLine();

                    str = str.trim();

                    str = str.replace("    ", ",");
                    str = str.replace("   ", ",");
                    str = str.replace("  ", ",");

                    String st [] = str.split(",");

                    int r = Integer.parseInt(st[0].trim());
                    int s = Integer.parseInt(st[1].trim());
                    int h = Integer.parseInt(st[2].trim());

                    List<Integer> temp = new ArrayList<>();

                    temp.add(r);
                    temp.add(s);
                    temp.add(h);

                    ans.add( temp );

            }

            Collections.sort( ans , new Comparator<List<Integer>>(){
                public int compare(List<Integer> list1, List<Integer> list2){
                    int result = 0;
                    for (int i = 0; i <= list1.size() - 1 && result == 0; i++) 
                    {
                        if( i == 1 && result == 0 ){
                            result = list2.get(i).compareTo(list1.get(i));    
                        }
                        else{
                            result = list1.get(i).compareTo(list2.get(i));
                        }
                    }
                    return result;
                }
            });

            for( List<Integer> a : ans ){
                bw.write( a.toString().replace("[","").replace("]","") + "\n" );
            }
        } catch (Exception e) {

        }

        br.close();
        bw.close();

    }
}