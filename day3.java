import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class day3 {
    final static String PATH_TO_INPUT = "src/inputs/day3.txt";

    public static void main(String[] args){
        try{
            day3a();
            day3b();
        }
        catch(Exception e){
            System.out.println("Exception thrown: " + e.getCause() + " : " + e.getMessage());
        }
    }

    private static void day3a() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH_TO_INPUT))) {
            int sum = 0;
            String line;

            while ((line = br.readLine()) != null) {
                String ruck1;
                String ruck2;

                //Split the string into two equal parts (rucksack1 and rucksack2)
                int halfway = (line.length() / 2);
                ruck1 = line.substring(0, halfway);
                ruck2 = line.substring(halfway);

                //Iterate over the characters in ruck1 and check are they in ruck2
                for(char character : ruck1.toCharArray()){
                    String c = Character.toString(character);

                    if(ruck2.contains(c)){
                        sum += getValue(c);
                        break; //Question says to assume only one extra item
                    }
                }
            }

            System.out.println("The total for part a is: " + sum);
        }
    }

    private static void day3b() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH_TO_INPUT))) {

            String nextLine;
            int sum = 0;

            //This time we're meant to consider three lines at a time
            while ((nextLine = br.readLine()) != null) {
                String group1 = nextLine;
                String group2 = br.readLine();
                String group3 = br.readLine();

                for(char character : group1.toCharArray()){
                    String c = Character.toString(character);

                    if(group2.contains(c) && group3.contains(c)){
                        sum += getValue(c);
                        break; //question says to assume exactly one will match per group
                    }
                }
            }

            System.out.println("The total for part b is: " + sum);
        }
    }

    //utility method for mapping the string to the value as per the info in part 1
    private static int getValue(String s){
        int value = -1;

        switch(s) {
            case "a":
                value = 1;
                break;
            case "b":
                value = 2;
                break;
            case "c":
                value = 3;
                break;
            case "d":
                value = 4;
                break;
            case "e":
                value = 5;
                break;
            case "f":
                value = 6;
                break;
            case "g":
                value = 7;
                break;
            case "h":
                value = 8;
                break;
            case "i":
                value = 9;
                break;
            case "j":
                value = 10;
                break;
            case "k":
                value = 11;
                break;
            case "l":
                value = 12;
                break;
            case "m":
                value = 13;
                break;
            case "n":
                value = 14;
                break;
            case "o":
                value = 15;
                break;
            case "p":
                value = 16;
                break;
            case "q":
                value = 17;
                break;
            case "r":
                value = 18;
                break;
            case "s":
                value = 19;
                break;
            case "t":
                value = 20;
                break;
            case "u":
                value = 21;
                break;
            case "v":
                value = 22;
                break;
            case "w":
                value = 23;
                break;
            case "x":
                value = 24;
                break;
            case "y":
                value = 25;
                break;
            case "z":
                value = 26;
                break;
            case "A":
                value = 27;
                break;
            case "B":
                value = 28;
                break;
            case "C":
                value = 29;
                break;
            case "D":
                value = 30;
                break;
            case "E":
                value = 31;
                break;
            case "F":
                value = 32;
                break;
            case "G":
                value = 33;
                break;
            case "H":
                value = 34;
                break;
            case "I":
                value = 35;
                break;
            case "J":
                value = 36;
                break;
            case "K":
                value = 37;
                break;
            case "L":
                value = 38;
                break;
            case "M":
                value = 39;
                break;
            case "N":
                value = 40;
                break;
            case "O":
                value = 41;
                break;
            case "P":
                value = 42;
                break;
            case "Q":
                value = 43;
                break;
            case "R":
                value = 44;
                break;
            case "S":
                value = 45;
                break;
            case "T":
                value = 46;
                break;
            case "U":
                value = 47;
                break;
            case "V":
                value = 48;
                break;
            case "W":
                value = 49;
                break;
            case "X":
                value = 50;
                break;
            case "Y":
                value = 51;
                break;
            case "Z":
                value = 52;
                break;
            default:
                throw new IllegalArgumentException("Unmapped Value: " + value);
        }

        return value;
    }
}