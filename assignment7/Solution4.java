package assignment7;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
    
    public String toString() {
    	return String.format("[%d, %d]", this.start, this.end);
    }
}

public class Solution4 {
	
	public List<Interval> merge(List<Interval> intervals) {
	
		List<Interval> result = new LinkedList<>();
		
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval s1, Interval s2) {
				return s1.start - s2.start;
			}
		});
		
		Interval cur = null;
		
		for (Interval v: intervals) {
			if (cur == null) {
				cur = v;
			}
			else if(cur.end >= v.start) {
				cur.end = Math.max(cur.end, v.end);
			}
			else {
				result.add(cur);
				cur = v;
			}
		}
		
		if (cur != null)
			result.add(cur);
		
		return result;
	}

	public static void main(String[] args) {
		Solution4 solution4 = new Solution4();
		List<Interval> list = new LinkedList<>();
		list.add(new Interval(1, 3));
		list.add(new Interval(2, 6));
		list.add(new Interval(8, 10));
		list.add(new Interval(16, 18));
		
		List<Interval> ret = solution4.merge(list);
		for (Interval p: ret) {
			System.out.println(p);
		}
		
	}

}
