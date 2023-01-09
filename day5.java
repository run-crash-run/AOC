import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class day5 {

    //Note, file was modified to remove the starting stacks
    final static String PATH_TO_INPUT = "src/inputs/day5.txt";
    static HashMap<Integer, String> stacks = new HashMap<Integer, String>();

    public static void main(String args[]){
        try{
            day5a();
            day5b();
        }
        catch(Exception e){
            System.out.println("Exception thrown: " + e.getCause() + " : " + e.getMessage());
        }
    }

    private static void day5a() throws IOException {
        setUpStacks();
        try (BufferedReader br = new BufferedReader(new FileReader(PATH_TO_INPUT))) {
            String line;

            while ((line = br.readLine()) != null) {
                //Question dictates he starting stacks
                final int START = 5;

                int move;
                int from;
                int to;

                //Parse the move part of the string relative to the word from
                move = Integer.parseInt(line.substring(START, line.indexOf(" from")));

                //Parse the from part of the string
                from = Integer.parseInt(line.substring(line.indexOf(" from ") + " from ".length(), line.indexOf(" to")));

                //Parse the to part of the string
                to = Integer.parseInt(line.substring(line.indexOf(" to ") + " to ".length()));

                moveUsingPartOneLogic(move, from, to);
            }

            //The solution asks for the last letter in each stack
            String stack1, stack2, stack3, stack4, stack5, stack6, stack7, stack8, stack9;

            stack1 = getItemOnTop(1);
            stack2 = getItemOnTop(2);
            stack3 = getItemOnTop(3);
            stack4 = getItemOnTop(4);
            stack5 = getItemOnTop(5);
            stack6 = getItemOnTop(6);
            stack7 = getItemOnTop(7);
            stack8 = getItemOnTop(8);
            stack9 = getItemOnTop(9);

            System.out.println("The crates on top of each are: " + stack1 + stack2 + stack3 + stack4 + stack5 + stack6 + stack7 + stack8 + stack9);
        }
    }

    private static void day5b() throws IOException {
        setUpStacks();

        try (BufferedReader br = new BufferedReader(new FileReader(PATH_TO_INPUT))) {
            String line;

            while ((line = br.readLine()) != null) {
                final int START = 5;

                int move;
                int from;
                int to;

                //Parse the move part of the string relative to the word from
                move = Integer.parseInt(line.substring(START, line.indexOf(" from")));

                //Parse the from part of the string
                from = Integer.parseInt(line.substring(line.indexOf(" from ") + " from ".length(), line.indexOf(" to")));

                //Parse the to part of the string
                to = Integer.parseInt(line.substring(line.indexOf(" to ") + " to ".length()));

                moveUsingPartTwoLogic(move, from, to);
            }

            //The solution asks for the last letter in each stack
            String stack1, stack2, stack3, stack4, stack5, stack6, stack7, stack8, stack9;

            stack1 = getItemOnTop(1);
            stack2 = getItemOnTop(2);
            stack3 = getItemOnTop(3);
            stack4 = getItemOnTop(4);
            stack5 = getItemOnTop(5);
            stack6 = getItemOnTop(6);
            stack7 = getItemOnTop(7);
            stack8 = getItemOnTop(8);
            stack9 = getItemOnTop(9);

            System.out.println("The crates on top of each are: " + stack1 + stack2 + stack3 + stack4 + stack5 + stack6 + stack7 + stack8 + stack9);

        }
    }

    private static void setUpStacks(){
        // Starting values are given in the input to the question
        // the integer is the stack number given in the question
        // the string is the representation of the items in the stack
        // left of the string corresponds to the bottom of the stack
        // ie the first stack has V on the bottom and W on the top

        stacks.put(1, "VCDRZGBW");
        stacks.put(2, "GWFCBSTV");
        stacks.put(3, "CBSNW");
        stacks.put(4, "QGMNJVCP");
        stacks.put(5, "TSLFDHB");
        stacks.put(6, "JVTWMN");
        stacks.put(7, "PFLCSTG");
        stacks.put(8, "BDZ");
        stacks.put(9, "MNZW");
    }

    private static void moveUsingPartOneLogic(int numToMove, int from, int to){
        //as many times as is specified move the letter from the end of the first string to the second

        for(int i = 1; i<=numToMove; i++){
            String fromStack = stacks.get(from);
            String toStack = stacks.get(to);

            //get the last letter (the one on top)
            String itemInMotion = fromStack.substring(fromStack.length() -1, fromStack.length());

            //update the stack to remove the last letter
            stacks.put(from, fromStack.substring(0, fromStack.length() -1));

            //update the target stack to now have the new letter on top
            stacks.put(to, toStack + itemInMotion);
        }
    }

    private static void moveUsingPartTwoLogic(int numToMove, int from, int to){
        //this time we move the number specified in the input and preserve order
        String fromStack = stacks.get(from);
        String toStack = stacks.get(to);

        //get as many crates as were specified last letter (starting from the top / end)
        String cratesInMotion = fromStack.substring(fromStack.length() -numToMove, fromStack.length());

        //update the stack to remove those crates
        stacks.put(from, fromStack.substring(0, fromStack.length() -numToMove));

        //update the target stack to add the crates we took from the stack above
        stacks.put(to, toStack + cratesInMotion);
    }

    private static String getItemOnTop(int stack){
        String crates = stacks.get(stack);
        return stacks.get(stack).substring(crates.length() -1);
    }
}