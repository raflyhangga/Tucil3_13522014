package Solver;

import Dictionary.Dictionary;
import Solver.WordNode.WordNode;
import java.util.List;


public class AStar extends Solver {
    public AStar(String start_word, String end_word) throws Exception {
        super(start_word,end_word);
    }

    public AStar(String start_word, String end_word, String filePath) throws Exception {
        super(start_word,end_word,filePath);
    }

    /**
     * Fungsi untuk mendapatkan biaya untuk suatu simpul
     * */
    public Integer getCost(List<String> path, String word) {
        return Dictionary.getDistance(word,goal_word) + path.size();
    }

    public void getAdjacentWords(WordNode current_node){
        List<String> new_path;
        new_path = getNewPath(current_node);

        for(String word : visited_node.keySet()){
            if(!visited_node.get(word) && (Dictionary.getDistance(current_node.getWord(),word) == 1)){
                WordNode temp_node = new WordNode(word,getCost(new_path,word),new_path);
                this.queue.add(temp_node);
            }
        }
    }
}
