import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class day1 {
    final static String PATH_TO_INPUT = "src/inputs/day1.txt";

    public static void main(String args[]){
        try{
            day1a();
            day1b();
        }
        catch(Exception e){
            System.out.println("Exception thrown: " + e.getCause() + " : " + e.getMessage());
        }
    }

    private static void day1a() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH_TO_INPUT))) {
            ArrayList<Elf> elves = new ArrayList<Elf>();
            Elf elf = new Elf();
            String line;

            while ((line = br.readLine()) != null) {
                if ("".equals(line)){
                    //Line break in the input denotes a new elf
                    elves.add(elf);
                    elf = new Elf();
                }
                else{
                    elf.addCalories(Integer.parseInt(line));
                }
            }

            int max = -1;

            //Find the solution (The elf with the most calories)
            for (Elf e : elves){
                if(e.getTotalCalories() > max){
                    max = e.getTotalCalories();
                }
            }

            System.out.println("===================================");
            System.out.println("The answer for day1a is: " + max);
        }
    }

    private static void day1b() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH_TO_INPUT))) {
            ArrayList<Elf> elves = new ArrayList<Elf>();
            ArrayList<Integer> values = new ArrayList <Integer>();

            Elf elf = new Elf();
            String line;

            while ((line = br.readLine()) != null) {
                if ("".equals(line)){
                    //Add the total for sorting later
                    values.add(elf.getTotalCalories());

                    //Line break denotes a new elf
                    elves.add(elf);
                    elf = new Elf();
                }
                else{
                    elf.addCalories(Integer.parseInt(line));
                }
            }

            //Find the solution (The elves with the top 3 most calories)
            Collections.sort(values);

            System.out.println("===================================");
            System.out.println("For day1b:");
            System.out.println("The 1st most calories is: " + values.get(values.size() -1));
            System.out.println("The 2nd most calories is: " + values.get(values.size() -2));
            System.out.println("The 3rd most calories is: " + values.get(values.size() -3));
            System.out.println("===================================");
        }
    }
}

class Elf{
    int totalCalories;

    public int getTotalCalories() {
        return totalCalories;
    }

    public void addCalories(int calories){
        this.totalCalories += calories;
    }
}