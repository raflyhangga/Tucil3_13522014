package Dictionary;

import ReadFile.*;
import java.util.Map;

public class Dictionary {
    Map<String, Boolean> words;
    int wordLength;

    /**
     * Constructor
     * */
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

    /**
     * Fungsi untuk mengembalikan dictionary
     * @return Map of string and booleans
     * */
    public Map<String, Boolean> getWords() {
        return words;
    }

    /**
     * Fungsi untuk menghitung selisih dua kata
     * @return nilai selisih kata
     * */
    public static Integer getDistance(String wordA, String wordB) {
        int difference = 0;
        for(int i=0;i<wordA.length();i++){
            if(wordA.charAt(i)!=wordB.charAt(i)){
                difference++;
            }
        }
        return difference;
    }

    /**
     * Fungsi untuk mengecek apakah suatu kata merupakan alfabetik
     * @return true jika alfabetik, else jika lain
     * */
    public static Boolean isAlphabetic(String word) {
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Fungsi untuk mengecek apakah string kosong
     * @return true jika string kosong
     * */
    public static Boolean isEmptyString(String word) {
        return word.isEmpty();
    }


    /**
     * Fungsi untuk mengecek apakah string valid
     * @return true jika alfabetik dan tidak kosong
     * */
    public static Boolean isValidWord(String word){
        return isAlphabetic(word) && !isEmptyString(word);
    }
}
