import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day03b {

    public static void main(String[]args) throws Throwable{
        Scanner infile = new Scanner(new File("day03.dat"));
        ArrayList<String[]> map = new ArrayList<>();

        while(infile.hasNext()){
            map.add(infile.nextLine().split(""));
        }

        int treeCount = 0, right = 3, down = 1;
        long product = 1;
        product *= treeCounter(map,1,1);
        product *= treeCounter(map,3,1);
        product *= treeCounter(map,5,1);
        product *= treeCounter(map,7,1);
        product *= treeCounter(map,1,2);

        System.out.println("Answer: " + product);

    }

    private static int treeCounter(ArrayList<String[]> map, int right, int down){
        int treeCount = 0, row = 0, col = 0;

        while(row < map.size()-1){
            row += down;
            col += right;
            if(col >= map.get(row).length)
                col -= map.get(row).length;
            if(map.get(row)[col].equals("#"))
                treeCount++;

        }
        return treeCount;
    }

}

