import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day08a {
    public static void main(String[]args) throws Throwable{

        Scanner infile = new Scanner(new File("small8.dat"));
        ArrayList<Integer> steps = new ArrayList<>();
        ArrayList<Cmd> cmds = new ArrayList<>();
        while(infile.hasNext()){
            String cmd = infile.next();
            int val = infile.nextInt();
            cmds.add(new Cmd(cmd,val));
        }

        int sum = 0;
        int step = 0;

        while(!steps.contains(step)){


        }


        System.out.println("Answer: " + sum);

    }
}


class Cmd {
    private String cmd;
    private int val;

    public Cmd(String c, int v){
        cmd = c;
        val = v;
    }

    public int getVal(){
        return val;
    }
    public String getCmd(){
        return cmd;
    }
}
