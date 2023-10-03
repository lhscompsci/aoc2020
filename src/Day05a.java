import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;

public class Day05a {
    public static void main(String[] args) throws Throwable {
        Scanner infile = new Scanner(new File("day05.dat"));
        ArrayList<String> values = new ArrayList<>();
        while (infile.hasNext()) {
            values.add(infile.next());
        }

        int[][] seatMap = new int[128][8];
        int bigID = -1;
        for (String seat : values) {
// process boarding codes into seat IDs
            String[] vals = seat.split("");
            int high = 127, low = 0, row = -1, col = -1;
            for (int i = 0; i < 7; i++) {
                if (vals[i].equals("F")){
                    high = (high + low+1) / 2 - 1;
//                    out.println("h:"+high);
                }
                else{
                    low = (high + low + 1) / 2 ;
//                    out.println("l:"+low);
                }
            }
            row = (vals[6].equals("F")?low:high);
//            out.println("row:"+row);
            high = 7;
            low = 0;
            for(int i = 7; i< vals.length; i++){
                if (vals[i].equals("L")){
                    high = (high + low + 1) / 2 - 1;
//                    out.println("h:"+high);
                }
                else{
                    low = (high + low + 1) / 2 ;
//                    out.println("l:"+low);
                }
            }
            col = (vals[9].equals("L")?low:high);
//            out.println("col:"+col);
            int seatVal = row * 8 + col;
            seatMap[row][col] = seatVal;
//            System.out.println("seatID: " + seatVal);
            if(seatVal>bigID)
                bigID = seatVal;
        }

        for(int[] arr: seatMap){
            for(int seat: arr)
                out.printf("%4d",seat);
            out.println();
        }

        System.out.println("Answer: " + bigID);


    }
}

