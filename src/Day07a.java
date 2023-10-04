import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day07a {
    public static void main(String[]args) throws Throwable{

        Scanner infile = new Scanner(new File("small.dat"));
        ArrayList<String> values = new ArrayList<>();
        ArrayList<Bag> bags = new ArrayList<>();
        while(infile.hasNext()){
            values.add(infile.nextLine());
        }

        int bigID = -1;
        for(String val:values){
            String[] breaker = val.split(" bags contain ");
            Bag b = new Bag(breaker[0],breaker[1]);
            bags.add(b);
        }



        System.out.println("Answer: " + bigID);

    }
}


class Bag {
    private String color;
    private ArrayList<Bag> list;

    public Bag(String c, String l){
        color = c;
        list = new ArrayList<>();
        addBags(l);
    }

    public void addBags(String l){
        String[] bags = l.split(", ");
        if(bags[0].contains("no other"))
            return;
        for(String b:bags){
            String[] breakdown = b.split(" ");
            String ba = breakdown[1]+ " " + breakdown[2];
            list.add(new Bag(ba,""));
        }
    }
    public String getColor(){
        return color;
    }
}
