package kr.or.ddit.basic;


/**
 * 제한된 타입파라미터 예제
 * @author 10
 *
 */
public class T04BoundedParameterTest {
	public static void main(String[] args) {
		
		int result = Util2.compare(10, 20);
		System.out.println(result);
		
		result = Util2.compare(3.14, 3);
		System.out.println(result);
		
//		result = Util2.compare("JAVA", 3); ///허용하지않는 Stirng 타입을 넣었더니 빨간줄 뜬다
	}

}

///이미 Util 클래스 있어서 충돌 일어나니 Util2로 이름 지음
class Util2{
	
	///제너릭 앞에 <>가 있으므로 제너릭 메소드이다
//	public static <T>  int compare(T t1, T t2) {
	///원래 doubleValue밑에 빨간줄이 나온다
	public static <T extends Number>  int compare(T t1, T t2) {
		///T는 뭐든 다 올 수 있지만 Number와 Number의 하위 타입만 올 수 있다고 제한을 걸은것이다.
		
		///숫자값을 받아서 doubleValue를 쓰고 싶다
		///Number타입이 온다는 전제로 하고 있는데 사실 뭐가 올지 모른다
		///String은 못오게 하고 Number와 Number의 하위 타입만 오게 하고 싶다 그걸 제한된 파라미터라고 한다 => extend
		
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		
		return Double.compare(v1, v2);
		///왼쪽 값이 크면 양수, 같으면 0 , 오른족이 더 크면 음수로 int값이 리턴됨
	}
}
