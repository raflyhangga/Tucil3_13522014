package Exception;

public class WordSizeNotEqualException extends Exception {
    public WordSizeNotEqualException(){
        super("Start word length does not match Goal Word length");
    }
}
