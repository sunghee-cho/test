package edu.R;

import java.util.Vector;

import org.rosuda.JRI.REXP;
import org.rosuda.JRI.RVector;
import org.rosuda.JRI.Rengine;

import vo.StudentVO;


//http://www.rforge.net/org/doc/org/rosuda/JRI/REXP.html
//api doc
public class RTest2 {
	   static {
		    System.loadLibrary("jri"); 
		    System.out.println("jri로드완료");
		   }

		static Rengine rengine = new Rengine
				(new String[] {"--vanilla"}, false, null);
		
public static void main(String[] args) {
	
	RTest2 obj = new RTest2();
	obj.test1();
	obj.test2();
	//obj.test3(args[0]); //'한서진' 입력
	obj.test3("한서진");
}
//자바에서 입력 데이터 전달하고 r 실행
public StudentVO test3(String input) {
	//System.loadLibrary("jri");
	//Rengine rengine = new Rengine(null, false, null);
	System.out.println("test3 메소드 테스트 완료");
//rengine.eval함수 	
		
	rengine.eval("stu = data.frame( name=c('한서진', "
			+ " '노승혜', '진진희', '이수임') , "
			+ "eng=c(100, 90, 80, 80) , "
			+ "mat=c(77, 88, 99, 22), "
			+ "kor=c(56, 98, 100, 99) ) ");
	//rengine.eval("input='한서진'");
	rengine.eval("library(dplyr)");
	rengine.eval(
	"onestu <- stu %>% filter(name == '" 
	+ input + "') ");

	
	REXP exp2 = rengine.eval(
	"total <- onestu$eng + onestu$mat + onestu$kor");
	REXP exp3 = rengine.eval("avg <- total / 3");
	
	REXP exp4 = rengine.eval("onestu$name <- as.character(onestu$name)");
	REXP exp5 =rengine.eval("onestu$eng <- as.character(onestu$eng)");
	REXP exp6 =rengine.eval("onestu$mat <- as.character(onestu$mat)");
	REXP exp7 =rengine.eval("onestu$kor <- as.character(onestu$kor)");
	
	System.out.println("이름=" + exp4.asString());
	System.out.println("영어=" + exp5.asString());
	System.out.println("수학=" + exp6.asString());
	System.out.println("국어=" + exp7.asString());
	
	System.out.println("총점=" + exp2.asDouble());
	System.out.println("평균=" + exp3.asDouble());	
	
	StudentVO vo = new StudentVO
			(exp4.asString(), 
					Integer.parseInt(exp7.asString()),
					Integer.parseInt(exp5.asString()),
					Integer.parseInt(exp6.asString()),
					exp2.asDouble(),
					exp3.asDouble()
					);
  
		  
		/*
		 * rengine.eval("stu = data.frame( " + "name=c('한서진', '노승혜', '진진희', '이수임')" +
		 * ", eng=c(100, 90, 80, 80) " + ", mat=c(77, 88, 99, 22) " +
		 * ", kor=c(56, 98, 100, 99) )"); rengine.eval("input='한서진'");
		 * rengine.eval("library(dplyr)"); rengine.eval("onestu <- stu %>% " +
		 * "filter(name == " + input + ") ");
		 * 
		 * REXP exp2 = rengine.eval("total <- " +
		 * "onestu$eng + onestu$mat +onestu$kor"); REXP exp3 =
		 * rengine.eval("avg <- total / 3");
		 * 
		 * rengine.eval("onestu$eng<-as.character(onestu$eng)");
		 * rengine.eval("onestu$kor<-as.character(onestu$kor)");
		 * rengine.eval("onestu$mat<-as.character(onestu$mat)");
		 * rengine.eval("onestu$name<-as.character(onestu$name)"); REXP exp1 =
		 * rengine.eval("onestu"); Vector v1 = exp1.asVector().getNames();
		 * 
		 * for(Object s : v1) { System.out.print(s + "\t"); REXP exp6 =
		 * rengine.eval("onestu$" + s); System.out.print(exp6.asString() + "\t"); }
		 * System.out.println();
		 * 
		 * // System.out.println // (rengine.eval("onestu$name").asString());
		 * 
		 * System.out.println(exp2.asDouble()); System.out.println(exp3.asDouble());
		 * 
		 * //System.out.println(xxxx 국어 영어 수학 총점 평균);
		 */	
	rengine.end();
	return vo;	 
}//test3메소드

//이미지 파일 
public void test2() {
	System.out.println(System.getenv("R_HOME"));
	System.out.println
	(System.getProperty("java.library.path"));
	//System.loadLibrary("jri");
	System.out.println("test2 메소드 테스트완료");	
	//Rengine rengine = new Rengine(new String[] {"--vanilla"}, false, null);
	System.out.println(rengine.versionCheck());
	rengine.eval	("library(png)");
	rengine.eval	("png('C:/java_class/mul_workspace/rtest/"
	+ "WebContent/test.png')"	);
	rengine.eval	("plot(sample(c(1:5) , 5))");
	rengine.eval	("dev.off()");
	rengine.end();
	System.out.println("---test2 끝---");
}

public void test1() {  
	System.out.println(System.getenv("R_HOME"));
	System.out.println
	(System.getProperty("java.library.path"));
	//System.loadLibrary("jri");
	System.out.println("test1 메소드 테스트완료");
	//환경설정 확인
	//jar 동작 호출
	//Rengine rengine = new Rengine
	//		(new String[] {"--vanilla"}, false, null);
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
	rengine.end();
	System.out.println("---test1 끝---");
}
}
