package edu.R;

import java.util.Enumeration;
import java.util.Vector;

import org.rosuda.JRI.REXP;
import org.rosuda.JRI.RVector;
import org.rosuda.JRI.Rengine;

//http://www.rforge.net/org/doc/org/rosuda/JRI/REXP.html
//api doc
public class RTest {
public static void main(String[] args) {
	//Runtime.getRuntime().exec("c:/경로/python c:/경로/*.py");
	System.out.println(System.getenv("R_HOME"));
	System.out.println
	(System.getProperty("java.library.path"));
	System.loadLibrary("jri");
	System.out.println("테스트완료");
	//환경설정 확인
	//jar 동작 호출
	Rengine rengine = new Rengine(null, false, null);
	System.out.println(rengine.versionCheck());
	
	REXP exp1 = rengine.eval("a<-c(1:10)");
	int[] result1 =  exp1.asIntArray();
	for(int i : result1) {
		System.out.println(i);
	}
	
	REXP exp3 = rengine.eval("b<-LETTERS[1:10]");
	String s[] = exp3.asStringArray();
	for( String st : s) {
		System.out.println(st);
	}
	//asIntArray asStringArray 
	//asDoubleArray asBooleanArray
	//asInt() asString()
	//jri 통해서 r 호출 "/" 경로 구분자!!! 
		rengine.eval
	("setwd('C:/java_class/r_workspace')");
	REXP exp4 = rengine.eval("getwd()");
	System.out.println(exp4.asString());
	
	rengine.eval("library(ggplot2)");
    REXP exp5 = rengine.eval("mpg");
  //행 열 전체
    RVector rv5 = exp5.asVector(); 
   // 모든 열의 이름 
	Vector v5 = rv5.getNames();
//	Enumeration e = v5.elements();
//	while(e.hasMoreElements()) {
//		System.out.println(e.nextElement());//열이름
//	}

	//mpg$열변수명 - 타입 읽어오자
    for(Object o : v5) {
    	System.out.println(o);//열이름
    	REXP exp6 = rengine.eval("mpg$" + o);
    	//System.out.println(exp6.rtype); 
    	//16이면 문자열
    	//13 정수 14 실수
    	if(exp6.rtype == exp6.STRSXP)
    	System.out.println(exp6.asStringArray()[0]);
    	else
        System.out.println(exp6.asDoubleArray()[0]);    		
    	//System.out.println(exp6.STRSXP);//16
     }

	//Rengine ; eval("r문장"):REXP : asxxxx
	
//	REXP exp2 = rengine.eval("a");
//	int[] result2 =  exp2.asIntArray();
//	for(int i : result2) {
//		System.out.println(i);
//	}
	
    //plot, wordcloud, google map
    // r : html형식, png형식
    
		/*
		 * rengine.eval("library(ggplot2)"); REXP exp5 = rengine.eval("mpg"); RVector
		 * rv5 = exp5.asVector(); Vector v5 = rv5.getNames();
		 * System.out.println(v5.elements());
		 */
	
}
}
