import java.util.Scanner;

public class MyParser {

    public static void main(String[] args) {
        int num = 1; int count = 0;
        while (count < 10) {
            System.out.print(num++ + ". Input a set to test if its format is correct: ");
            String in = new Scanner(System.in).nextLine();
            boolean state = true; //Turns false when the set is invalid
            int bracketCount = 0; //Keeps track of bracket pairs
            int i = 0; //int to count tokens from the string

            if (in.startsWith("{") && in.endsWith("}")) {
                scan:
                for (; i < in.length(); i++) {
                    switch (in.charAt(i)) {
                        case '{': //Tallies start brackets
                            bracketCount++;
                            break;
                        case '}': //Removes a tally for every end bracket to make pairs
                            bracketCount--;
                            if (bracketCount == 0) //If the first bracket is used prematurely end the loop
                                break scan;
                            if(i < in.length()-1)
                                if(in.charAt(i+1) == '{' || in.charAt(i+1) == 'n')
                                    state = false;
                            break;
                        case ',': //Validates that the char before/after the comma is the correct bracket or a 'n'
                            if (!(in.charAt(i - 1) == '}' && in.charAt(i + 1) == 'n' || in.charAt(i - 1) == 'n' && in.charAt(i + 1) == 'n' ||
                                    in.charAt(i - 1) == 'n' && in.charAt(i + 1) == '{' || in.charAt(i - 1) == '}' && in.charAt(i + 1) == '{'))
                                state = false;
                            break;
                        case 'n': //Checks to validate that the chars around the 'n' are correct
                            if (in.charAt(i - 1) == 'n' || in.charAt(i + 1) == 'n' || in.charAt(i + 1) == '{')
                                state = false;
                            break;
                        default:
                            state = false;
                            break;
                    }
                }
                if (bracketCount == 0 && i != in.length() - 1) //If the loop ends prematurely the set is invalid
                    state = false;
            } else
                state = false;
            if (state && bracketCount == 0) //Outputs the validation
                System.out.println("Correct\n");
            else
                System.out.println("Incorrect Set Form . . . \n");
            count++;
        }
    }
}






























