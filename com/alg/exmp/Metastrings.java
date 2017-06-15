package com.alg.exmp;

import java.util.*;


public class Metastrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);  

		int num = scan.nextInt();
		Vector<Vector<String>> v = new Vector<Vector<String>>();
		for(int a=0; a<num*2; a++){
			Vector<String> mspair = new Vector<String>();
			mspair.addElement(scan.next());
			++a;
			mspair.addElement(scan.next());
			v.add(mspair);
		}
		scan.close();

		for(int i=0; i < v.size(); i++){
			Vector<String> temp = (Vector<String>)v.get(i);
			Vector<Integer> pos = new Vector<Integer>();
			for(int j=0; j<temp.size(); j++){
				String str1 = temp.get(j);
				String str2 = temp.get(++j);
				
				if(str1.equals(str2)){
					//Exit Not metastring
					System.out.println(0);
					//System.exit(0);
					
				}else if(str1.length() != str2.length()){
					//Exit Not metastring
					System.out.println(0);
					//System.exit(0);
					
				}else{
					pos = new Vector<Integer>();
					char[] arr1 = str1.toCharArray();
					char[] arr2 = str2.toCharArray();
					
					for(int k=0; k< arr1.length; k++){
						
						if(arr1[k] != arr2[k]){
							pos.add(k);
						}
					}
					if(pos.size() != 2){
						//Exit Not metastring
						System.out.println(0);
						//System.exit(0);
					}else{
					//swap 2 chars in one of the strings
					char c11 = arr1[((Integer)pos.get(0)).intValue()];
					char c12 = arr1[((Integer)pos.get(1)).intValue()];
					
					char c21 = arr2[((Integer)pos.get(0)).intValue()];
					char c22 = arr2[((Integer)pos.get(1)).intValue()];
					
					if(c11 == c22 && c12 == c21){
					arr1[((Integer)pos.get(1)).intValue()] = c11;
					arr1[((Integer)pos.get(0)).intValue()]	= c12;	
					
					if(new String(arr1).equals(new String(arr2))){
						System.out.println(1);
						//System.exit(0);
					}
					}else{
						System.out.println(0);
					}
					}
				}
			}
			
		}
	}

}
