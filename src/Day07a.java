import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day07a {
    public static void main(String[]args) throws Throwable{

        Scanner infile = new Scanner(new File("small.dat"));
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


class Bag {
    private String color;
    private ArrayList<Bag> list;

    public Bag(String c){
        color = c;
        list = new ArrayList<>();
    }

    public void addBags(String l){
        String[] bags = l.split(", ");
        if(bags[0].contains("no other"))
            return;

    }
}
