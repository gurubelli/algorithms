package com.gurubelli.surya.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	public static class Interval {
		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	static List<Interval> merge(List<Interval> intervals) {

		Collections.sort(intervals, new IntervalComparator());

		// Two approaches .. one is using stack
		// Another one using list
		List<Interval> result = new ArrayList<>();
		Interval prev = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval current = intervals.get(i);
			if (prev.end >= current.start) {
				prev.end = Math.max(prev.end, current.end);
			} else {
				result.add(prev);
				prev = current;
			}
		}

		result.add(prev);

		return result;

	}

	static class IntervalComparator implements Comparator<Interval> {

		@Override
		public int compare(Interval o1, Interval o2) {
			// TODO Auto-generated method stub
			return (o1.start - o2.start);
		}

	}

	public static void main(String[] args) {

		// [[2,3],[2,2],[3,3],[1,3],[5,7],[2,2],[4,6]]
		List<Interval> list = new ArrayList<>();
		Interval interval = new Interval(2, 3);
		list.add(interval);
		list.add(new Interval(2, 2));
		list.add(new Interval(3, 3));
		list.add(new Interval(1, 3));
		list.add(new Interval(5, 7));
		list.add(new Interval(2, 2));
		list.add(new Interval(4, 6));
		merge(list);

	}
}
