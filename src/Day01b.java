import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day01b {

    public static void main(String[] args) throws Throwable {
        Scanner infile = new Scanner(new File("day01.dat"));
        ArrayList<Integer> values = new ArrayList<>();
        while (infile.hasNext()) {
            values.add(infile.nextInt());
        }

        int curr = -1, sum = 0, i = 0, j = 0;
        while (sum != 2020) {
            curr++;
            for (i = curr + 1; sum !=2020 && i < values.size(); i++)
                for (j = i + 1; j < values.size(); j++) {
                    sum = values.get(curr) + values.get(i) + values.get(j);
                    if (sum == 2020){
                        System.out.println("woot");
                        break;
                    }

                }
        }
        i--;
        System.out.println(values.get(curr));
        System.out.println(values.get(i));
        System.out.println(values.get(j));

        long prod = (long)values.get(curr) * (long)values.get(i) * (long)values.get(j);
        System.out.println(prod);

    }
}
