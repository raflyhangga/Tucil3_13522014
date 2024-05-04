package Solver.WordNode;

import java.util.List;

public record WordNode(String word, Integer totalCost, List<String> paths) {
}
