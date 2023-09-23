import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class Day04b {

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
    ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
    eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
    hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
    hgt (Height) - a number followed by either cm or in:
        If cm, the number must be at least 150 and at most 193.
        If in, the number must be at least 59 and at most 76.
    iyr (Issue Year) - four digits; at least 2010 and at most 2020.
    pid (Passport ID) - a nine-digit number, including leading zeroes.
    cid (Country ID) - ignored, missing or not.*/
    private static boolean validFields(String pass) {
        String[] broke = pass.split(" ");
        String[] eyes = "amb blu brn gry grn hzl oth".split(" ");
        Arrays.sort(broke);
        if(broke[1].contains("cid"))
            broke[1] = "z"+broke[1];
        Arrays.sort(broke);
        int birthYr = Integer.parseInt(broke[0].split(":")[1]);
        if(birthYr<1920 || birthYr>2002)
            return false;

        String eyeClr = broke[1].split(":")[1];
        Predicate<String> same = Predicate.isEqual(eyeClr);
        if(Arrays.stream(eyes).noneMatch(same))
            return false;

        int expYr = Integer.parseInt(broke[2].split(":")[1]);
        if(expYr<2020 || expYr>2030)
            return false;

        String hair = broke[3].split(":")[1];
        if(!hair.matches("^#([A-Fa-f0-9]{6})$"))
            return false;

        String heightStr = broke[4].split(":")[1];
        String unit = heightStr.substring(heightStr.length()-2);
        if(heightStr.length()<3)
            return false;
        int height = Integer.parseInt(heightStr.substring(0,heightStr.length()-2));
        if(unit.equals("in") && (height<59 || height>76))
            return false;
        if(unit.equals("cm") && (height<150 || height>193))
            return false;

        int isYr = Integer.parseInt(broke[5].split(":")[1]);
        if(isYr<2010 || isYr>2020)
            return false;

        String pasp = broke[6].split(":")[1];
        if(!pasp.matches("^([0-9]{9})$"))
            return false;

        return true;
    }

}

