import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day01a {

    public static void main(String[]args) throws Throwable{
        Scanner infile = new Scanner(new File("day01.dat"));
        ArrayList<Integer> values = new ArrayList<>();
        while(infile.hasNext()){
            values.add(infile.nextInt());
        }

        int curr = -1, sum = 0, i=0;
        while(sum != 2020){
            curr++;
            for( i = curr + 1; i < values.size(); i++){
                sum = values.get(curr) + values.get(i);
                if(sum == 2020)
                    break;
            }
        }
        System.out.println(values.get(curr)*values.get(i));

    }
}
