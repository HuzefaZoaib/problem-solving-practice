package com.practice;

import java.util.Stack;

public class CallPoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(calPoints("5","2","C","D","+"));
	}
	
	static int calPoints(String... ops) {
		
		Stack<Integer> st = new Stack<>();
		for(int i=0; i<ops.length; i++) {
			String op = ops[i];
			if(op.equals("+")) {
				Integer dt1 = st.pop();
				Integer dt2 = st.pop();
				st.push(dt1);
				st.push(dt2);
				st.push(dt1+dt2);
			} else if(op.equals("C")) {
				st.pop();
			} else if(op.equals("D")) {
				st.push(st.peek()*2);
			} else {
				st.push(Integer.valueOf(op));
			}
		}
		
		int result = st.pop();
		while(!st.isEmpty()) {
			result += st.pop();
		}
		
		return result;
	}

}
