package ReadFile;

import java.io.File;
import java.util.*;

public class FileScanner {
    String filePath;
    File file;
    Scanner sc;

    public FileScanner() throws Exception{
        this.filePath = "../../../asset/dictionary.txt";
        file = new File(filePath);
        sc = new Scanner(file);
    }

    public FileScanner(String filePath) throws Exception{
        this.filePath = "../../../asset/"+filePath;
        file = new File(this.filePath);
        sc = new Scanner(file);
    }

    public Map<String,Boolean> getWords(int length){
        Map<String,Boolean> words = new HashMap<>();
        while(sc.hasNextLine()){
            String word = sc.nextLine();
            if(word.length()==length){
                words.put(word.toLowerCase(),false);
            }
        }

        return words;
    }

    
}
