package Program;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import Dictionary.*;
import Solver.Solver;
import Solver.WordNode.WordNode;
import Solver.*;


public class Program {
    private final String initial_string;
    private final String final_string;

    public Program() {
        Commands.clearConsole();
        Scanner sc = new Scanner(System.in);
        System.out.println("\n========= Word Ladder Solver =========");
        System.out.print("Input your initial word\n=> ");
        this.initial_string = Commands.stringInput();
        System.out.print("Input your goal Word\n=> ");
        this.final_string = Commands.stringInput();
    }

    // TODO: Tambahin waktu eksekusi dan jumlah node visit
    public void run() {
        try {
            System.out.println("Choose your algorithm below:");
            System.out.println("1. Uniform Cost Search");
            System.out.println("2. Greedy Best Search");
            System.out.print("3. A* Algorithm\n=> ");
            int choice = Commands.intInput();
            Solver sv = switch (choice) {
                case 1 -> new UniformSearch(initial_string, final_string);
                case 2 -> new GreedyBest(initial_string, final_string);
                case 3 -> new AStar(initial_string, final_string);
                default -> throw new Exception("Invalid choice");
            };
            Instant start = Instant.now();
            WordNode result = sv.solve();
            Instant end = Instant.now();
            Commands.printResult(result, Duration.between(start,end),sv.getNodeAmount());
        } catch(Exception e) {
            System.out.println("====== HASIL ======");
            System.out.println(e.getMessage());
        }
    }



}
