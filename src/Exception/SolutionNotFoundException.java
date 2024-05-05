package Exception;

public class SolutionNotFoundException extends Exception{
    public SolutionNotFoundException(){
        super("There is no solution available");
    }
}
