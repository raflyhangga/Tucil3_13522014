package Program;

import Dictionary.*;
import Solver.*;
import Solver.WordNode.WordNode;
import Exception.*;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;


public class Program {
    private final String initial_string;
    private final String final_string;

    public Program() {
        Commands.clearConsole();
        System.out.println("========= Word Ladder Solver =========");
        System.out.print("Input your initial word\n=> ");
        this.initial_string = Commands.stringInput();
        System.out.print("Input your goal Word\n=> ");
        this.final_string = Commands.stringInput();
    }

    public void run() {
        try {
            System.out.println("Choose your algorithm below:");
            System.out.println("1. Uniform Cost Search");
            System.out.println("2. Greedy Best Search");
            System.out.print("3. A* Algorithm\n=> ");
            int choice = Commands.intInput();
            String customDictionary;

            Solver sv;
            while(true){
                try {
                    customDictionary = Commands.fileInput();
                    switch (choice) {
                        case 1 : sv = new UniformSearch(initial_string, final_string,customDictionary); break;
                        case 2 : sv = new GreedyBest(initial_string, final_string,customDictionary); break;
                        case 3 : sv = new AStar(initial_string, final_string,customDictionary); break;
                        default: throw new Exception();
                    }
                    break;
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                } catch(WordSizeNotEqualException ignored){

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    switch (choice) {
                        case 1 : sv = new UniformSearch(initial_string,final_string); break;
                        case 2 : sv = new GreedyBest(initial_string,final_string); break;
                        case 3 : sv = new AStar(initial_string,final_string); break;
                        default: throw new Exception();
                    }
                    break;
                }
            }

            Instant start = Instant.now();
            WordNode result;
            try{
                result = sv.solve();
            } catch (SolutionNotFoundException err){
                Instant end = Instant.now();
                Commands.printResult(Duration.between(start,end),sv.getNodeAmount());
                return;
            }
            Instant end = Instant.now();
            Commands.printResult(result, Duration.between(start,end),sv.getNodeAmount());
        } catch(Exception e) {
            System.out.println("====== Error ======");
            System.out.println(e.getMessage());
        }
    }
}
