package Solver;

import Dictionary.Dictionary;
import Solver.WordNode.WordNode;
import java.util.List;


public class GreedyBest extends Solver {

    public GreedyBest(String start_word, String end_word) throws Exception {
        super(start_word,end_word);
    }

    public Integer getCost(String word){
        return Dictionary.getDistance(word,goal_word);
    }

    public void getAdjacentWords(WordNode current_node){
        List<String> new_path;
        new_path = getNewPath(current_node);

        for(String word : visited_node.keySet()){
            if(!visited_node.get(word) && (Dictionary.getDistance(current_node.getWord(),word) == 1)){
                WordNode temp_node = new WordNode(word,getCost(word),new_path);
                this.queue.add(temp_node);
            }
        }
    }

}
