package PepLevel2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxScoreOfWords {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        if(words.length == 0){
            return 0;  
        }
        int[] maxScore = new int[1];
        List<String> subsets = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : letters){
            int count = map.getOrDefault(ch, 0);
            map.put(ch, count+1);
        }
        getMaxScore(words, letters, score, subsets, map, maxScore, 0);
        return maxScore[0];
    }
    public void getMaxScore(String[] words, char[] letters, int[] score, List<String> subsets, 
                            Map<Character, Integer> map, int[] maxScore, int idx){
        if(idx == words.length){
            Map<Character, Integer> tempMap = new HashMap<>(map);
            int currScore = 0;
            for(String str : subsets){
                char[] chArr = str.toCharArray();
                for(char ch : chArr){
                    if (tempMap.getOrDefault(ch, 0) == 0) {
                        return;  // Invalid subset, skip
                    }
                    tempMap.put(ch, tempMap.get(ch) - 1);
                    currScore += score[ch - 'a'];
                }
            }
            maxScore[0] = Math.max(maxScore[0], currScore);
            return;
        }

        //not include
        getMaxScore(words, letters, score, subsets, map, maxScore, idx+1);
        //include
        subsets.add(words[idx]);
        getMaxScore(words, letters, score, subsets, map, maxScore, idx+1);
        subsets.remove(subsets.size()-1);
    }
}