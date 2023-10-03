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
            group.add(line);
            if (line.isEmpty()) {
                values.add(group);
                group.clear();
            }
        }
        values.add(group);


        int sum = getSum(values);

        out.println("Answer: " + sum);


    }

    private static int getSum(ArrayList<ArrayList<String>> values) {
        int sum = 0;
        for (ArrayList<String> grp : values) {
            String first = grp.get(0);
            boolean found = true;
            int count = 0;
            while(found){
                String[] fst = first.split("");
                int curr = 0;
                for(String s: grp){
                    if (!s.contains(fst[curr])) {
                        found = false;

                        break;
                    }
                }
            }


            sum += count;
        }
        return sum;
    }
}

