package Dictionary;

import ReadFile.*;
import java.util.Map;

public class Dictionary {
    Map<String, Boolean> words;
    int wordLength;

    public Dictionary(int length) throws Exception {
        FileScanner fs = new FileScanner();
        words = fs.getWords(length);
        this.wordLength = length;
    }

    public Dictionary(int length, String fileName) throws Exception {
        FileScanner fs = new FileScanner(fileName);
        words = fs.getWords(length);
        this.wordLength = length;
    }

    public Map<String, Boolean> getWords() {
        return words;
    }

    public static Integer getDistance(String wordA, String wordB) {
        int difference = 0;
        for(int i=0;i<wordA.length();i++){
            if(wordA.charAt(i)!=wordB.charAt(i)){
                difference++;
            }
        }
        return difference;
    }

    public static Boolean isAlphabetic(String word) {
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public static Boolean isEmptyString(String word) {
        return word.isEmpty();
    }

    public static Boolean isValidWord(String word){
        return isAlphabetic(word) && !isEmptyString(word);
    }
}
