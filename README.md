# Word Ladder Solver

## 💫 Project Overiew

This repository contains an implementation of a ⭐***Word Ladder Solver***⭐ using three different search algorithms: **Uniform Cost Search**, **Greedy Best Search**, and **A Star**. Word Ladder is a word game where the player transforms one word into another by changing one letter at a time, creating a chain of words with each consecutive word differing by a single letter.

## 📋 Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Algorithms](#algorithms)
- [Contributor](#contributor)

## ✨ Introduction

The Word Ladder Solver is a Java-based project aimed at finding the shortest path between two words by changing one letter at a time, such that each intermediate word is also a valid word in the dictionary.

## ✏️ Features

- **Word Ladder Generation:** Given a start word and an end word, the program generates the shortest word ladder between them.
- **Multiple Algorithms:** Provides implementations for three different search algorithms:
    - Uniform Cost Search
    - Greedy Best Search
    - A Star (A*) Search
- **Custom Dictionary Support:** Users can specify their custom word dictionary for word validation.

## 🛠️ Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/raflyhangga/Tucil3_13522014
   ```

2. Navigate into the project directory:

   ```bash
   cd Tucil3_13522014
   ```

3. Build project:
    ```
   // For UNIX Machine
   ./build.sh
   
   // For Windows Machine
   ./buid.bat
   ```
   

### 🏃🏻‍♂️ Usage

To use the Word Ladder Solver, follow these steps:

1. **Run the program:**

   ```
   // For UNIX Machine
   ./run.sh
   
   // For Windows Machine
   ./run.bat
   ```

## 📖 Algorithms

### Uniform Cost Search

Uniform Cost Search explores the node with the lowest cost from the start node. It gradually moves outward, visiting neighboring nodes until the goal is found.

### Greedy Best Search

Greedy Best Search selects the node that appears to be the best option at each step based on a heuristic function. It aims to reach the goal quickly but may not necessarily find the shortest path.

### A Star (A*) Search

A* Search combines the advantages of both Uniform Cost Search and Greedy Best Search by considering both the cost to reach the node and an estimate of the cost from the current node to the goal.


## 🧑🏻 Contributor
| Contributors                     	| NIM      	|
|----------------------------------	|----------	|
| Raden Rafly Hanggaraksa Budiarto 	| 13522014 	|
