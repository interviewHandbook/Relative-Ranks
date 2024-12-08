package com.interviewprep.leetcode.easy.relativeranks;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FirstApproach {

	public static void main(String[] args) {
		
		int[] score = {4,3,2,1, 5};
		
		FirstApproach fa = new FirstApproach();
		String[] placements = fa.findRelativeRanks(score);
		

	}

	
	public String[] findRelativeRanks(int[] score) {

		String[] placements = new String[score.length];
		
		// convert to Integer array
		Integer[] sortedScore = new Integer[score.length];
		Arrays.setAll(sortedScore, i -> score[i]);
		
		// sort in descending order
		Arrays.sort(sortedScore, Collections.reverseOrder());
		
		// push the scores and the corresponding indices into a HashMap
		Map<Integer, Integer> scoreMap = new HashMap<Integer, Integer>();
		for(int i=0; i<score.length; i++) {

			scoreMap.put(sortedScore[i], i);
		}

		int index = 0;
		
		// now assign the placements
		for(int i = 0; i < score.length; i++) {

			index = scoreMap.get(score[i]);

			if(index == 0) {

				placements[i] = "Gold Medal";
			}
			else if(index == 1) {

				placements[i] = "Silver Medal";
			}
			else if(index == 2) {

				placements[i] = "Bronze Medal";
			}
			else {

				placements[i] = "" + (index+1) + "";

			}
		}

		return placements;

	}
}
