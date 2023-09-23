import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class Day04a {

    public static void main(String[] args) throws Throwable {
        Scanner infile = new Scanner(new File("day04.dat"));
        String[] fields = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid", "cid"};
        ArrayList<String> values = new ArrayList<>();
        StringBuilder val = new StringBuilder();
        while (infile.hasNextLine()) {
            String temp = infile.nextLine();
            if (temp.isEmpty()) {
                values.add(val.toString());

                val = new StringBuilder();
            } else
                val.append(temp).append(" ");
        }
        values.add(val.toString());

        int validCount = getValidCount(values, fields);
        System.out.println("Answer: " + validCount);

    }

    private static int getValidCount(ArrayList<String> values, String[] fields) {
        int validCount = 0;
        for (String pass : values) {
            if (pass.contains(fields[0]) &&
                    pass.contains(fields[1]) &&
                    pass.contains(fields[2]) &&
                    pass.contains(fields[3]) &&
                    pass.contains(fields[4]) &&
                    pass.contains(fields[5]) &&
                    pass.contains(fields[6]) &&
                    validFields(pass))
                validCount++;

//            }
        }
        return validCount;
    }

    private static boolean validFields(String pass) {


        return true;
    }

}

