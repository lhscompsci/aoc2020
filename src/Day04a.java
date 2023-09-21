import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Day04a {

    public static void main(String[] args) throws Throwable {
        Scanner infile = new Scanner(new File("day04.dat"));
        String[] fields = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid", "cid"};
        ArrayList<String> values = new ArrayList<>();
        String val = "";
        while (infile.hasNext()) {
            String temp = infile.nextLine();
            if (temp.equals("")) {
                values.add(val);
                System.out.println(val);
                val = "";
            } else
                val = val + temp + " ";
        }

        int validCount = 0;
        for (String pass : values) {

//            for( int i = 0; i < fields.size()-1; i++){
            if (pass.contains(fields[0]) &&
                    pass.contains(fields[1]) &&
                    pass.contains(fields[2]) &&
                    pass.contains(fields[3]) &&
                    pass.contains(fields[4]) &&
                    pass.contains(fields[5]) &&
                    pass.contains(fields[6]))
                validCount++;

//            }
        }
        System.out.println("Answer: " + validCount);

    }

//    private static Map<String, String> processToMap(String temp) {
//    }
}

