import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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

/*    You can continue to ignore the cid field, but each other field has strict rules about what values are valid for automatic validation:

    byr (Birth Year) - four digits; at least 1920 and at most 2002.
    iyr (Issue Year) - four digits; at least 2010 and at most 2020.
    eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
    hgt (Height) - a number followed by either cm or in:
    If cm, the number must be at least 150 and at most 193.
    If in, the number must be at least 59 and at most 76.
    hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
            ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
            pid (Passport ID) - a nine-digit number, including leading zeroes.
    cid (Country ID) - ignored, missing or not.*/
    private static boolean validFields(String pass) {
        String[] broke = pass.split(" ");
        Arrays.sort(broke);
        if(broke[0].charAt(0)=='b')
            return false;
return true;
    }

}

