import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class Day06a {
    public static void main(String[] args) throws Throwable {
        Scanner infile = new Scanner(new File("day06.dat"));
        ArrayList<ArrayList<String>> values = new ArrayList<>();
        ArrayList<String> group = new ArrayList<>();
        while (infile.hasNextLine()) {
            String line = infile.nextLine();
            if(!line.isEmpty())
                group.add(line);
            else {
                values.add(group);
 //               out.println(group);
                group = new ArrayList<>();
            }
 //           out.println(values);
        }
        values.add(group);


//        out.println(values);
        int sum = getSum(values);

        out.println("Answer: " + sum);


    }

    private static int getSum(ArrayList<ArrayList<String>> values) {
        int sum = 0;
        for (ArrayList<String> grp : values) {
            out.println(grp);
            String longest = getLongest(grp);
            int count = 0;
            String[] fst = longest.split("");
            for(int curr = 0; curr < longest.length(); curr++){
                int i;
                for(i = 0; i<grp.size();i++) {
                    out.println(longest + " " + grp.get(i));
                    if (!grp.get(i).contains(fst[curr])) {
                        break;
                    }
                }
                if(i<grp.size()) {
                    out.println("abort");
                    continue;
                }
                count++;
                out.println("curr:" +curr + " count: "+count);

            }
            sum += count;
            out.println("sum: "+sum +" count: "+count);
        }
        return sum;
    }

    public static String getLongest(ArrayList<String> list){
        String longest = list.get(0);
        for(String s: list)
            if(s.length()>longest.length()) {
                longest = s;
            }
        return longest;
    }
}

