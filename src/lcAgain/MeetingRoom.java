package lcAgain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingRoom {
	public static class Interval {
		      int start;
		      int end;
		     Interval() { start = 0; end = 0; }
		     Interval(int s, int e) { start = s; end = e; }
		  }
	 public static boolean canAttendMeetings(Interval[] intervals) {
	        if(intervals.length <= 1) {
	            return true;
	        }
	        Arrays.sort(intervals, new Comparator<Interval>(){
	            public int compare(Interval a, Interval b) {
	                return a.start - b.start;
	            }
	        });
	        
	        /*for(Interval i: intervals){
	        	System.out.println(i.start + " "+ i.end);
	        }*/
	        
	        for(int i = 1; i < intervals.length; i++) {
	            if(intervals[i].start < intervals[i-1].end) {
	                return false;
	            }
	        }
	        return true;
	    }
	 
	 public static List<Interval> conflitsList(Interval[] intervals){
		 List<Interval> res = new ArrayList<Interval>();
		 
		 Arrays.sort(intervals, new Comparator<Interval>(){
			 public int compare(Interval a, Interval b){
				 return a.start - b.start;
			 }
		 });
		 
		 for(int i=1; i<intervals.length; i++){
			 if(intervals[i-1].end < intervals[i].start){
				 if(res.contains(intervals[i-1]))
					 res.add(intervals[i-1]);
				 if(res.contains(intervals[i]))
					 res.add(intervals[i]);
				 
			 }
		 }
		 
		 return res;
	 }
	 
	 
	 
	 public static void main(String args[]){
		 Interval i1 = new Interval(15,40);
		 Interval i2 = new Interval(5,20);
		 Interval i3 = new Interval(17,30);
		 Interval[] test = {i1, i2,i3};
		 canAttendMeetings(test);
	 }
}
