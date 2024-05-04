package Dictionary;

import Solver.WordNode.WordNode;

import java.time.Duration;
import java.util.Scanner;

public class Commands {
    public static String stringInput(){
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        while(!Dictionary.isValidWord(word)){
            System.out.print("ERROR!, Invalid input, please try again\n=> ");
            word = sc.nextLine();
        }

        return word;
    }

    public static int intInput() {
        Scanner sc = new Scanner(System.in);
        int number;
        do {
            try {
                System.out.print("(Enter a number between 1 and 3) ");
                number = sc.nextInt();
                if (number < 1 || number > 3) {
                    throw new IllegalArgumentException("Number must be between 1 and 3");
                }
                break;
            } catch (Exception e) {
                System.out.println("ERROR! invalid input, Please try again.");
                sc.nextLine();
            }
        } while (true);
        return number;
    }

    public static Boolean boolInput(){
        while(true){
            System.out.print("=> ");
            String word = stringInput();
            if(word.equalsIgnoreCase("Y")){
                return true;
            } else if(word.equalsIgnoreCase("N")){
                return false;
            } else {
                System.out.println("Invalid choice, try again!");
            }

        }
    }

    public static void printResult(WordNode result, Duration duration, Integer visited_nodes){
        Commands.clearConsole();
        System.out.println("=============== HASIL ===============");
        System.out.println("found solution with minimal path " + result.getPaths().size());
        System.out.println("with execution time "+duration.toMillis()+" millisecond and "+visited_nodes+" node visited");
        System.out.println("<== Path ==>");

        result.appendPath(result.getWord());
        for(String path: result.getPaths()){
            System.out.println(path);
        }
    }

    public static void clearConsole()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
