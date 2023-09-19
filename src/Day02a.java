import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day02a {

    public static void main(String[]args) throws Throwable{
        Scanner infile = new Scanner(new File("day02.dat"));
        ArrayList<Integer> min = new ArrayList<>();
        ArrayList<Integer> max = new ArrayList<>();
        ArrayList<String> req = new ArrayList<>();
        ArrayList<String> pass = new ArrayList<>();

        while(infile.hasNext()){
            String[] val = infile.nextLine().split(" ");
            String[] uplo = val[0].split("-");
            min.add(Integer.parseInt(uplo[0]));
            max.add(Integer.parseInt(uplo[1]));
            req.add(val[1].substring(0,1));
            pass.add(val[2]);
        }

        int valid = 0;


        for(int i = 0; i < pass.size(); i++){
            int num = countOcc(pass.get(i),req.get(i));
            if(min.get(i)<=num && num<=max.get(i))
                valid++;
        }
        System.out.println(valid);

    }

    private static int countOcc(String p, String what){
        int count = 0;
        for(int i = 0; i < p.length(); i++){
            if(what.equals(p.substring(i,i+what.length())))
                count++;
        }
        return count;
    }
}
