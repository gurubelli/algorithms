package com.gurubelli.surya.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PrintItenary {

	private void printItinerary(HashMap<String, String> dataSet) {
		String start = null;
		for (HashMap.Entry<String, String> entry : dataSet.entrySet()) {
			if (!dataSet.containsValue(entry.getKey())) {
				start = entry.getKey();
				break;
			}
		}
		if (start == null) {
			System.out.println("Invalid input");
		}
		String to = dataSet.get(start);
		while (to != null) {
			System.out.println(start + " -> " + to);
			start = to;
			to = dataSet.get(to);
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		HashMap<String, String> dataSet = new HashMap<>();
		dataSet.put("Chennai", "Banglore");
		dataSet.put("Bombay", "Delhi");
		dataSet.put("Goa", "Chennai");
		dataSet.put("Delhi", "Goa");
		PrintItenary itinerary = new PrintItenary();
		itinerary.printItinerary(dataSet);
	}

	public List<String> reconstruct(String[][] itinerary) {
		HashMap<String, String> graph = new HashMap<>();
		HashSet<String> relation = new HashSet<>();
		for (String[] it : itinerary) {
			graph.put(it[0], it[1]);
			relation.add(it[1]);
		}

		String start = "";
		for (String[] it : itinerary) {
			if (!relation.contains(it[0])) {
				start = it[0];
			}
		}
		if ("".equals(start)) {
			return new ArrayList<String>();
		}
		List<String> rst = new ArrayList<>();
		rst.add(start);
		while (graph.containsKey(start)) {
			start = graph.get(start);
			rst.add(start);
		}
		return rst;
	}
}
