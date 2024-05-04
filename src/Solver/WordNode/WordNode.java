package Solver.WordNode;

import java.util.List;

public class WordNode {
    String word;
    Integer totalCost;
    List<String> paths;

    public WordNode(String word, Integer totalCost, List<String> paths){
        this.word = word;
        this.totalCost = totalCost;
        this.paths = paths;
    }

    public String getWord() {
        return word;
    }

    public Integer getTotalCost() {
        return totalCost;
    }

    public List<String> getPaths() {
        return paths;
    }

    public void appendPath(String path){
        paths.add(path);
    }
}
