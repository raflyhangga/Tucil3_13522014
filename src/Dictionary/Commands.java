package Dictionary;

import Solver.WordNode.WordNode;
import java.time.Duration;
import java.util.Scanner;

public class Commands {
    /**
     * Fungsi untuk mendapatkan string dari input. String akan direturn apabila alfabetik dan tidak kosong
     * @return string
     * */
    public static String stringInput(){
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        while(!Dictionary.isValidWord(word)){
            System.out.print("ERROR!, Invalid input, please try again\n=> ");
            word = sc.nextLine();
        }

        return word;
    }

    /**
     * Fungsi untuk mendapatkan string untuk file input. String akan direturn apabila alfabetik dan tidak kosong
     * @exception Exception berisi pesan "You choose the default dictionary"
     * */
    public static String fileInput() throws Exception {
        System.out.println("Do you have your custom dictionary? (y/n)");
        if(boolInput()) {
            System.out.print("Enter your custom dictionary (Put your .txt file in asset folder, insert without the .txt): \n=> ");
            return stringInput() + ".txt";
        } else {
            throw new Exception("You choose the default dictionary");
        }
    }

    /**
     * Fungsi untuk mendapatkan integer dari input. integer akan direturn apabila alfabetik dan tidak kosong
     * @return integer
     * */
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

    /**
     * Fungsi untuk mendapatkan boolean dari input boolean akan direturn apabila input berisikan Y atau N
     * @return true jika input Y dan false jika input N dengan tidak memerhatikan kapital
     * */
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

    /**
     * Fungsi untuk mendapatkan result
     * */
    public static void printResult(WordNode result, Duration duration, Integer visited_nodes){
        Commands.clearConsole();
        System.out.println("=============== HASIL ===============");
        System.out.println("found solution with minimal path " + (WordNode.countPath(result)-1));
        System.out.println("with execution time "+duration.toMillis()+" millisecond and "+visited_nodes+" node visited");
        System.out.println("<== Path ==>");

        for(String path: WordNode.getPaths(result)){
            System.out.println(path);
        }
    }

    /**
     * Fungsi untuk mendapatkan result jika tidak ada solusi
     * */
    public static void printResult(Duration duration, Integer visited_nodes){
        Commands.clearConsole();
        System.out.println("=============== HASIL ===============");
        System.out.println("NO SOLUTION FOUND!!!");
        System.out.println("Traversed path with execution time "+duration.toMillis()+" millisecond and "+visited_nodes+" node visited");
    }

    /**
     * Fungsi untuk mendireksi kursor konsol
     * */
    public static void clearConsole()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
