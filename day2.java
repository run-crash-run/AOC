import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class day2 {

    final static String PATH_TO_INPUT = "src/inputs/day2.txt";

    public static void main(String args[]){
        try{
            day2a();
            day2b();
        }
        catch(Exception e){
            System.out.println("Exception thrown: " + e.getCause() + " : " + e.getMessage());
        }
    }

    private static void day2a() throws IOException {
        // From part 1 of the question
        //Elf
        //A = rock
        //B = paper
        //C = scissors

        //Hero
        //X = Rock
        //Y = Paper
        //Z = Scissors

        //Scoring
        // Rock = 1
        // Paper = 2
        // Scissors = 3
        // Win = 6
        // Draw = 3
        // Loss = 0

        try (BufferedReader br = new BufferedReader(new FileReader(PATH_TO_INPUT))) {
            String line;        //incoming line
            int heroScore = 0;    //total score for the game for the hero

            while ((line = br.readLine()) != null) {
                //eg "A X" or "C Y"
                String villain = line.substring(0,1);
                String hero = line.substring(2,3);

                // hero always gets points based on what they chose
                int choiceScore = 0;
                int outcomeScore = 0;

                switch(hero){
                    case "X":
                        choiceScore = 1;
                        break;
                    case "Y":
                        choiceScore = 2;
                        break;
                    case "Z":
                        choiceScore = 3;
                        break;
                    default:
                    throw new IllegalArgumentException("Unexpected input: " + hero);
                }

                // figure out if hero wins, draws or loses
                int win = 6;
                int draw = 3;
                int lose = 0;

                switch(hero){
                    case "X": //Hero picked Rock
                        if("A".equals(villain)){ //Villain picked rock
                            outcomeScore = draw;
                        }
                        if("B".equals(villain)){ //Villain picked paper
                            outcomeScore = lose;
                        }
                        if("C".equals(villain)){ //Villain picked scissors
                            outcomeScore = win;
                        }
                        break;
                    case "Y": //Hero picked Paper
                        if("A".equals(villain)){ //Villain picked rock
                            outcomeScore = win;
                        }
                        if("B".equals(villain)){ //Villain picked paper
                            outcomeScore = draw;
                        }
                        if("C".equals(villain)){ //Villain picked scissors
                            outcomeScore = lose;
                        }
                        break;
                    case "Z": //Hero picked Scissors
                        if("A".equals(villain)){ //Villain picked rock
                            outcomeScore = lose;
                        }
                        if("B".equals(villain)){ //Villain picked paper
                            outcomeScore = win;
                        }
                        if("C".equals(villain)){ //Villain picked scissors
                            outcomeScore = draw;
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Unexpected input: " + hero);
                }

                heroScore += choiceScore;
                heroScore += outcomeScore;
            }

            System.out.println("Part A, total score for hero: " + heroScore);
        }
    }

    private static void day2b() throws IOException {
        // From part 2 of the question
        //Elf
        //A = rock
        //B = paper
        //C = scissors

        //Hero
        //X = need to lose
        //Y = need to draw
        //Z = need to win

        //Scoring
        // Rock = 1
        // Paper = 2
        // Scissors = 3
        // Win = 6
        // Draw = 3
        // Loss = 0

        try (BufferedReader br = new BufferedReader(new FileReader(PATH_TO_INPUT))) {
            String line;        //incoming line
            int heroScore = 0;    //total score for the game for the hero

            while ((line = br.readLine()) != null) {
                //eg "A X" or "C Y"
                String villain = line.substring(0, 1);
                String result = line.substring(2, 3);

                int roundOutcome = 0;   //depends on win, lose or draw
                int roundChoice = 0;    //depends on the choice we made

                //calculate score for the outcome
                switch(result){
                    case "X":   //we need to lose
                        roundOutcome = 0;
                        break;
                    case "Y":   //we need to draw
                        roundOutcome = 3;
                        break;
                    case "Z":   //we need to win
                        roundOutcome = 6;
                        break;
                    default:
                        throw new IllegalArgumentException("Unexpected input: " + result);
                }

                //calculate score based on the pick we need to get the result above

                //check what the villain did, check the outcome, then pick the choice

                int rock = 1;
                int paper = 2;
                int scissors = 3;

                switch (villain){
                    case "A": //villain picked rock
                        if("X".equals(result)){ //we're meant to lose
                            roundChoice = scissors;
                        }
                        if("Y".equals(result)){ //we're meant to draw
                            roundChoice = rock;
                        }
                        if("Z".equals(result)){ //we're meant to win
                            roundChoice = paper;
                        }
                        break;
                    case "B": //villain picked paper
                        if("X".equals(result)){ //we're meant to lose
                            roundChoice = rock;
                        }
                        if("Y".equals(result)){ //we're meant to draw
                            roundChoice = paper;
                        }
                        if("Z".equals(result)){ //we're meant to win
                            roundChoice = scissors;
                        }
                        break;
                    case "C": //villain picked scissors
                        if("X".equals(result)){ //we're meant to lose
                            roundChoice = paper;
                        }
                        if("Y".equals(result)){ //we're meant to draw
                            roundChoice = scissors;
                        }
                        if("Z".equals(result)){ //we're meant to win
                            roundChoice = rock;
                        }
                        break;
                }

                heroScore += roundOutcome;
                heroScore += roundChoice;
            }

            System.out.println("Part B, the total score is: " + heroScore);
        }
    }
}