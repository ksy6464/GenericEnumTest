package kr.or.ddit.basic;

import java.util.List;
import java.util.Map;

public class T02GenericClassTest {
/*
 	제너릭 클래스 생성하는 방법
	 	
 	class 클래스명<제너릭 타입글자>{
	 	
 	제너릭타입 변수명; //변수 선언에 제너릭 문자 사용할 겨우
 	...
 	제너릭타입글자 메서드명() { //
 		...
	 		
 		return 값;
 	}
 	...
 }
	 암 건나
-- 제너릭타입글자 --
T => Type 
K => Key 
V => Value 
E => Element (자료구조에 들어가는 원소들을 의미할 때 사용됨)
*/
	public static void main(String[] args) {
		
		NonGenericClass ng1 = new NonGenericClass(); 
		ng1.setVal("가나다라");
		
		NonGenericClass ng2 = new NonGenericClass();
		ng2.setVal(100);
		
		String rtnVal1 =(String) ng1.getVal();
		System.out.println("문자열 반환값 rtnVal1 : "+rtnVal1);
		
		int rtnVal2 =(Integer) ng2.getVal();
		System.out.println("정수형 반환값 rtnVal2 : "+rtnVal2);
		System.out.println();
		
		////////////////////////////////////////////////////////
		
		MyGeneric<String> mg1 = new MyGeneric<String>();
		MyGeneric<Integer> mg2 = new MyGeneric<Integer>();
		
		mg1.setValT("우리나라");
		mg2.setValT(500);
		
		rtnVal1 = mg1.getValT();
		rtnVal2 = mg2.getValT();
		
		System.out.println("제너릭 문자열 반환값 : "+ rtnVal1);
		System.out.println("제너릭 정수형 반환값 : "+ rtnVal2);
		
	}

}


///새로운 클래스 정의
class NonGenericClass{
	private Object val;

	public Object getVal() {
		return val;
	}

	public void setVal(Object val) {
		this.val = val;
	}
}

class MyGeneric<T>{
	private T valT;

	public T getValT() {
		return valT;
	}

	///제너릭 안에 있어서 타입이 선언됐을뿐 일반 메소드이다
	///제너릭 메소드 아니다
	public void setValT(T valT) {
		this.valT = valT;
	}
	
}


