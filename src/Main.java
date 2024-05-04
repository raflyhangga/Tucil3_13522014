import Dictionary.Commands;
import Program.Program;

public class Main {
    public static void main(String[] args) {
        //TODO: Clear screen when initialize program and custom dictionary support
        boolean choice = true;
        while(choice){
            Program mainprogram = new Program();
            mainprogram.run();
            System.out.println("Insert another prompt? (y/n)");
            choice = Commands.boolInput();
        }
        System.out.println("Program terminated, thank you for playing!");
    }
}
