import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class day6 {
    final static String PATH_TO_INPUT = "src/inputs/day6.txt";

    public static void main(String args[]){
        try{
            day6a();
            day6b();
        }
        catch(Exception e){
            System.out.println("Exception thrown: " + e.getCause() + " : " + e.getMessage());
        }
    }

    private static void day6a() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH_TO_INPUT))) {
            String signal =  br.readLine(); //Note: only one line of input for this one

            int signalLength = 4;
            int answer = -1;

            for(int position = 0; position < signal.length(); position++){
                String currentString;

                //slice four characters from current position
                currentString = signal.substring(position, position + signalLength);

                //order the string for comparison
                char[] currentAsCharArray = currentString.toCharArray();
                Arrays.sort(currentAsCharArray);
                String sortedString = new String(currentAsCharArray);

                //check if any of the characters match
                boolean firstAndSecondMatch = sortedString.substring(0,1).equals(sortedString.substring(1,2));
                boolean secondAndThirdMatch = sortedString.substring(1,2).equals(sortedString.substring(2,3));
                boolean thirdAndFourthMatch = sortedString.substring(2,3).equals(sortedString.substring(3,4));

                if(firstAndSecondMatch || secondAndThirdMatch || thirdAndFourthMatch){
                    //do nothing, just keep going
                }
                else{
                    answer = position + 4;
                    break;
                }
            }

            System.out.println("The signal was found at: " + answer);
        }
    }

    private static void day6b() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH_TO_INPUT))) {
            String signal =  br.readLine(); //Note: only one line of input for this one

            int signalLength = 14;
            int answer = -1;

            for(int position = 0; position < signal.length(); position++){
                String currentString;

                //slice four characters from current position
                currentString = signal.substring(position, position + signalLength);

                //order the string for comparison
                char[] currentAsCharArray = currentString.toCharArray();
                Arrays.sort(currentAsCharArray);
                String sortedString = new String(currentAsCharArray);

                // check if any of the characters match
                boolean firstAndSecondMatch = sortedString.substring(0,1).equals(sortedString.substring(1,2));
                boolean secondAndThirdMatch = sortedString.substring(1,2).equals(sortedString.substring(2,3));
                boolean thirdAndFourthMatch = sortedString.substring(2,3).equals(sortedString.substring(3,4));
                boolean fourthAndFifthMatch = sortedString.substring(3,4).equals(sortedString.substring(4,5));
                boolean fifthAndSixthMatch = sortedString.substring(4,5).equals(sortedString.substring(5,6));
                boolean sixthAndSeventhMatch = sortedString.substring(5,6).equals(sortedString.substring(6,7));
                boolean seventhAndEightMatch = sortedString.substring(6,7).equals(sortedString.substring(7,8));
                boolean eightAndNinthMatch = sortedString.substring(7,8).equals(sortedString.substring(8,9));
                boolean ninthAndTenthMatch = sortedString.substring(8,9).equals(sortedString.substring(9,10));
                boolean tenthAndEleventhMatch = sortedString.substring(9,10).equals(sortedString.substring(10,11));
                boolean eleventhAndTwelfthMatch = sortedString.substring(10,11).equals(sortedString.substring(11,12));
                boolean twelfthAndThirteenthMatch = sortedString.substring(11,12).equals(sortedString.substring(12,13));
                boolean thirteenthAndFourteenthMatch = sortedString.substring(12,13).equals(sortedString.substring(13,14));

                if(firstAndSecondMatch || secondAndThirdMatch || thirdAndFourthMatch ||
                   fourthAndFifthMatch || fifthAndSixthMatch  || sixthAndSeventhMatch ||
                   seventhAndEightMatch || eightAndNinthMatch || ninthAndTenthMatch ||
                   tenthAndEleventhMatch || eleventhAndTwelfthMatch || twelfthAndThirteenthMatch ||
                   thirteenthAndFourteenthMatch ){
                    //do nothing, just keep going
                }
                else{
                    answer = position + 14;
                    break;
                }
            }

            System.out.println("The signal was found at: " + answer);
        }
    }
}