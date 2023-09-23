import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day05a {
    public static void main(String[]args) throws Throwable{
        Scanner infile = new Scanner(new File("day05.dat"));
        ArrayList<String> values = new ArrayList<>();
        while(infile.hasNext()){
            values.add(infile.next());
        }

        int bigID = -1;
        for(String seat:values){
// process boarding codes into seat IDs

        }
        System.out.println("Answer: " + bigID);

    }
}

