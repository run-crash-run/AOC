import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class day4 {
    final static String PATH_TO_INPUT = "src/inputs/day4.txt";

    public static void main(String args[]){
        try{
            day4a();
            day4b();
        }
        catch(Exception e){
            System.out.println("Exception thrown: " + e.getCause() + " : " + e.getMessage());
        }
    }

    private static void day4a() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH_TO_INPUT))) {
            int count = 0;
            String line;

            while ((line = br.readLine()) != null) {
                Range r1 = new Range();
                Range r2 = new Range();
                boolean shouldCheckSecondEntry = true;

                //parse the string to grab the min and max for each
                r1.setMin(Integer.parseInt(line.substring(0, line.indexOf("-"))));
                r1.setMax(Integer.parseInt(line.substring(line.indexOf("-") + 1, line.indexOf(","))));

                //start from after the first dash when looking for the second dash
                r2.setMin(Integer.parseInt(line.substring(line.indexOf(",") + 1, line.indexOf("-", line.indexOf("-") +1))));
                r2.setMax(Integer.parseInt(line.substring(line.indexOf("-", line.indexOf("-") +1) +1)));

                // check if range one is completely inside range two
                // first check if min value is inside the range of range two
                if(( r1.min >= r2.min ) && ( r1.min <= r2.max )){
                    //now check if the max value is inside the range of range two
                    if ((r1.max <= r2.max)) {
                        //the min is inside the range and the max stops before the end of the range
                        count += 1;
                        shouldCheckSecondEntry = false; //don't accidentally count the same data set twice
                    }
                }

                if(shouldCheckSecondEntry){
                    //check if range two is completely inside range one
                    if(( r2.min >= r1.min ) && ( r2.min <= r1.max )){
                        //now check if the max value is inside the range of range two
                        if ((r2.max <= r1.max)) {
                            //the min is inside the range and the max stops before the end of the range
                            count += 1;
                        }
                    }
                }
            }

            System.out.println("The number of intersections is: " + count);
        }
    }

    private static void day4b() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH_TO_INPUT))) {
            int numOverlaps = 0;
            String line;

            while ((line = br.readLine()) != null) {
                Range r1 = new Range();
                Range r2 = new Range();
                boolean shouldCheckSecondEntry = true;

                //parse the string to grab the min and max for each
                r1.setMin(Integer.parseInt(line.substring(0, line.indexOf("-"))));
                r1.setMax(Integer.parseInt(line.substring(line.indexOf("-") + 1, line.indexOf(","))));

                //start from after the first dash when looking for the second dash
                r2.setMin(Integer.parseInt(line.substring(line.indexOf(",") + 1, line.indexOf("-", line.indexOf("-") +1))));
                r2.setMax(Integer.parseInt(line.substring(line.indexOf("-", line.indexOf("-") +1) +1)));

                // check if range one overlaps at all with range two
                //min value r1 is inside the min and max of r2
                boolean minValueOverlaps = (r1.min >= r2.min ) && (r1.min <= r2.max);
                //max value r1 is inside the min and max of r2
                boolean maxValueOverlaps = (r1.max >= r2.min ) && (r1.max <= r2.max);

                if(minValueOverlaps || maxValueOverlaps){
                    numOverlaps += 1;
                    shouldCheckSecondEntry = false;
                }

                if(shouldCheckSecondEntry){
                    // check if range two overlaps at all with range one
                    //min value r2 is inside the min and max of r1
                    boolean minValue2Overlaps = (r2.min >= r1.min ) && (r2.min <= r1.max);
                    //max value r2 is inside the min and max of r1
                    boolean maxValue2Overlaps = (r2.max >= r1.min ) && (r2.max <= r1.max);

                    if(minValue2Overlaps || maxValue2Overlaps){
                        numOverlaps += 1;
                    }
                }
            }
            System.out.println("The number of overlaps is: " + numOverlaps);
        }
    }
}

class Range{
    int min;
    int max;

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }
}