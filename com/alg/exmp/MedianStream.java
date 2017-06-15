package com.alg.exmp;

import java.util.*;

public class MedianStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		double arr[] = new double[num];
		try{
		for(int i=0; i <num; i++){
			if(scan.hasNextInt()){
				arr[i] = scan.nextInt();
			}else{
				System.out.println("Finished reading Input.");
			}
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
		
			scan.close();
		}
		
		Vector<Double> growingarr = new Vector<Double>();
		int j = 0;
		Vector<Double> vec = new Vector<Double>();
		growingarr.add(arr[0]);
		vec.add((Double)growingarr.get(j));
		for(int i=1; i <num; i++){
			
			growingarr.add(arr[i]);
			//sort array
			for(int p=growingarr.size()-1; p>0; p-- ){
				int last = ((Double)growingarr.get(p)).intValue();
				int lastbeforeone= ((Double)growingarr.get(p-1)).intValue();
				if( last < lastbeforeone){
					double temp = last;
					//growingarr.add((p-1), (Double)growingarr.get(p));
					growingarr.remove(p);
					growingarr.add((p-1), temp);
				}
			}
			
			int index = (growingarr.size()-1)/2;
			if(growingarr.size()%2 != 0){
				vec.add((Double)growingarr.get(index));
			}else{
				int subindex = growingarr.size()/2;
				int[] subarr1 = new int[subindex];
				for(int k=0; k<subindex; k++){
					subarr1[k] = ((Double)growingarr.get(k)).intValue();
				}
				int[] subarr2 = new int[subindex];
				for(int r=subindex,k=0; r<growingarr.size(); r++, k++){
					subarr2[k] = ((Double)growingarr.get(r)).intValue();
				}
				double median = Math.floor(((subarr1[subindex-1]+subarr2[0])/2));
				vec.add(new Double(median));
			}
			
			
			
		}
		for(int result = 0; result< vec.size(); result++){
			System.out.println(vec.get(result).intValue());
		}
		
		
		
	}

}
