package Karat;

/*
Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique positive integer identifier.

For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:

1   2    4   15
 \ /   / | \ /
  3   5  8  9
   \ / \     \
    6   7    11


3--->2
4--3
9--2
8--1
5--1

Sample input/output (pseudodata):

parentChildPairs = [
    (1, 3), (2, 3), (3, 6), (5, 6), (15, 9),
    (5, 7), (4, 5), (4, 8), (4, 9), (9, 11)
]


Write a function that takes this data as input and returns two collections: one containing all individuals with zero known parents, and one containing all individuals with exactly one known parent.


Output may be in any order:

findNodesWithZeroAndOneParents(parentChildPairs) => [
  [1, 2, 4, 15],       // Individuals with zero parents
  [5, 7, 8, 11]        // Individuals with exactly one parent
]

n: number of pairs in the input

*/


import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class FindParent {


    public List<List<Integer>> findNodesWithZeroAndOneParents(int[][] parentChilds) {
        List<Integer> listOfZeros = new ArrayList<>();
        Set<Integer> listOfOnes = new HashSet();
        Map<Integer, Integer> mapWithOne = new HashMap<>();
        for (int i = 0; i < parentChilds.length; i++) {
            int child = parentChilds[i][1];
            int parent = parentChilds[i][0];
            if (mapWithOne.containsKey(child)) {
                mapWithOne.put(child, mapWithOne.get(child) + 1);
                listOfOnes.add(parent);
            } else {
                mapWithOne.put(child, 1);
               // listOfZeros.add(parent);
            }

        }

        // [1, 2, 4, 15],       // Individuals with zero parents
        //[5, 7, 8, 11]        // Individuals with exactly one parent
        //Map -> Stream -> Filter -> Map


        //return new ArrayList(parentWithNoChildrens, parentWithOneChildren);
        List<Integer> parentWithNoChildrens = mapWithOne.entrySet().stream()
                .filter(map1 -> map1.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        for (int i = 0; i < parentChilds.length; i++) {
            if (!mapWithOne.containsKey(parentChilds[i][0]) && !listOfZeros.contains(parentChilds[i][0])) {
                listOfZeros.add(parentChilds[i][0]);
            }
        }

        List l = new ArrayList();
        l.add(parentWithNoChildrens);
        l.add(listOfZeros);

        return l;
    }


    public static void main(String[] argv) {
        FindParent s = new FindParent();
        int[][] parentChildPairs = new int[][]{
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {15, 9}, {5, 7},
                {4, 5}, {4, 8}, {4, 9}, {9, 11}
        };
        System.out.println(s.findNodesWithZeroAndOneParents(parentChildPairs));

    }
}


