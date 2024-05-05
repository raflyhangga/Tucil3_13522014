import Dictionary.Commands;
import Program.Program;

public class Main {
    //TODO: Untuk No Path, bikin waktu eksekusi dan node dijelajahi
    public static void main(String[] args) {
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
