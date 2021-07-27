package class17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BusyMan {

	static class Pair {
		int startTime;
		int endTime;
		
		public Pair(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.startTime + " " + this.endTime;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		List<Pair> activities = new ArrayList<>();
		while(n-- != 0) {
			
			int startTime = s.nextInt();
			int endTime = s.nextInt();
			
			Pair activity = new Pair(startTime, endTime);
			
			activities.add(activity);
		}
		
		//sort activity list on basis of end time
		System.out.println(activities);
		Collections.sort(activities, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) { //o1 -> this/current pair, o2 -> current + 1
				// TODO Auto-generated method stub
				return o1.endTime - o2.endTime; //+ve
			}
			
		});
		
		
		System.out.println(activities);
		//4 5, 5 7, 7 9, 8 9, 0 10, 4 10
		int currActivityEnd = activities.get(0).endTime;
		int count = 1;
		
		for(int i = 1; i < activities.size(); i++) {
			if(activities.get(i).startTime >= currActivityEnd) {
				count++;
				currActivityEnd = activities.get(i).endTime;
			}
		}
		
		System.out.println(count);
	}

}
