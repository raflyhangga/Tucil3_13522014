package Solver;

import Dictionary.Dictionary;
import Solver.WordNode.WordNode;
import java.util.*;

public class UniformSearch extends Solver {
    public UniformSearch(String start_word,String goal_word) throws Exception {
        super(start_word, goal_word);
    }

    public UniformSearch(String start_word,String goal_word, String filePath) throws Exception {
        super(start_word, goal_word,filePath);
    }
    /**
     * Fungsi untuk mendapatkan biaya untuk suatu simpul
     * */
    public Integer getCost(List<String> path) {
        return path.size();
    }

    public void getAdjacentWords(WordNode current_node){
        List<String> new_path;
        new_path = getNewPath(current_node);

        for(String word : visited_node.keySet()){
            if(!visited_node.get(word) && (Dictionary.getDistance(current_node.getWord(),word) == 1)){
                WordNode temp_node = new WordNode(word, getCost(new_path), new_path);
                queue.add(temp_node);
            }
        }
    }
}
