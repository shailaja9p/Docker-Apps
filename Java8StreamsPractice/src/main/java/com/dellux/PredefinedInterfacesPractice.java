package com.dellux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PredefinedInterfacesPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Student s1[]={ new Student("shailaja",80),new Student("medha",90),new
		 * Student("suman",91)};
		 * 
		 * Function<Student,String> f= st->{ String grade="";
		 * if(st.marks>90)grade="First class"; else if(st.marks>80 &&
		 * st.marks<=90)grade="Second class"; else grade="third class"; return grade; };
		 * for(Student s:s1){ System.out.println(f.apply(s)); }
		 */String str[] ={"sunny","prabhas","ps","aa","sidharth1","venkatesh"};
	    
	     String max = Arrays.stream(str).max((s1,s2)->s1.length()<s2.length()?-1:
	    	  (s1.length()>s2.length())?1:
	          s1.compareTo(s2)).get();
	      System.out.println(max);
	    }
	    	
	}


