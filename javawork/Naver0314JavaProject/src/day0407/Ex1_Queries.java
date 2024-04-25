package day0407;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

public class Ex1_Queries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int arr[]= {0,1,2,4,3};
		int queries[][]= {
				{0,4,2},
				{0,3,2},
				{0,2,2},
		};
		
		//stream 공부
		
		//Arrays.stream(arr, q[0], q[1]+1)//범위설정
		
		ArrayList<Integer> g=new ArrayList<>();
		ArrayList<Integer> result=new ArrayList<>();
		
		
		for(int i=0 ; i<queries.length ; i++) {
						int r=0;
						g.removeAll(g);
			for(int j=queries[i][0] ; j<=queries[i][1] ; j++) {
					if(arr[j]>queries[i][2]) {
						g.add(arr[j]);
					}	
			}
			
			//System.out.println(g.size());
			if(g.size()>=2) {
				r=Collections.min(g);
			} else if(g.size()==1) {
				r=g.get(0);
			} else if(g.size()==0) {
				g.add(-1);
				r=g.get(0);
			}
			
			result.add(r);
			
		}
		Integer[] mid=result.toArray(new Integer[result.size()]);
		int[] result1= new int[result.size()];
		for(int i=0 ; i<result.size() ; i++) {
			result1[i]=mid[i];
			
		}
		
		for(int i=0 ; i<result1.length ; i++) {
		System.out.print(result1[i]+"\t");
		}
		
	}
}
