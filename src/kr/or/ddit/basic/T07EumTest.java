package kr.or.ddit.basic;


/////enum상수 쓰지 않을때 상수 정의
//class Flower{
//	static final int ROSE =1; //장미
//	static final int TULIP =2; //튤립
//}
//
//class Animal{
//	static final int LION = 1; //사자
//	static final int TIGER = 2; //호랑이
//}





public class T07EumTest {
/*
 열거형 => 상수값들을 선언한는 방법
 
 선언방법 : enum 열거형 이름 {상수값1, 상수값2, ....,상수값n}; 
 
 */
	
	public enum HomeTown{광주, 부산, 평양, 제주도, 대구, 대전};
	
	
	
	// City 열거형 객체 선언 (기본값을 이용하는 열거형)
	public enum City { 서울, 부산, 대구, 광주, 대전}; ///City타입의 상수(객체)들
//	public enum City { 서울(), 부산(), 대구, 광주, 대전}; ///이렇게 해도 에러 안남
	
	// 데이터값을 임의로 지정한 열거형 객체 선언
	// 데이터값을 정해줄 경우에는 생성자를 이용하여 제공해 주면 된다.
	public enum Season { ///Season타입의 상수들
		봄("3월부터 5월까지"), 여름("6월부터 8월까지"), 가을("9월부터11월까지"), 겨울("12월부터 2월까지");
		
		// 괄호안의 값이 저장될 변수 선언
		private String data;
		
		// 생성자 만들기 (열거형의 생성자는 제어자가 묵시적으로 'private'이다)
		///기본 생성자는 public인데 enum은 private이다 이것의 효과는 외부에서 이것을 호출할 수가 없다
		/// 왜? 지금만들어진 객체들을 상수역할을 하기 위해서 만들어졌다. 상수는 여러개일 필요가 없다
		///객체를 많이 만든다는건 메모리를 많이 소모한다는것, 불필요한 객체를 많이생성할 필요가 없으므로 막아둔것이다
//		private Season(String data) {
		Season(String data) { ///안써도 private이다
			this.data = data;
		}
		
		// getter메서드
		public String getData() {
			return data;
		}
	}
	
	public static void main(String[] args) {
//		///임시로 enum안쓸때
//		int a = Animal.LION; ///a에는 LION이 들어있다
//		
//		///중간에 코드 많이 있다고 치고...
//		
//		if (a==Flower.ROSE) {
//			System.out.println("이것은 장미가 확실합니다...");
//		}
//		///a에 LION을 넣었으나 결국 값은 1로 둘이 똑같으므로 같다는 결과가 나온다
//		///에러가 나지않으므로 디버깅하기 어렵다
//		///이걸 해결하기 위한것이 enum이다
		
		
		
	/*
	 열거형에서 사용하는 주요 메서드
	 
	 1. name() => 열거형 상수의 이름을 문자열로 반환한다.
	 2. valueOf("열거형 상수이름") => '열거형 상수이름'과 일치하는 열거형 상수 객체를 반환한다
	 3. ordinal() => 열거형 상수가 정의된 순서값을 반환한다. (기본적으로 0부터 시작)
	 */
		City myCity1; // 열거형 객체변수 선언
		City myCity2; // 열거형 객체변수 선언
		
		myCity1 = City.서울;///상수의 이름(문자열)
		myCity2 = City.valueOf("서울"); ///이름(문자열)을 알아서 그것의객체를  원함
		
		System.out.println("myCity1 : "+ myCity1.name()); 
		System.out.println("myCity1의 ordnal : "+ myCity1.ordinal()); ///선언된 순서를 알고 싶을때
		System.out.println();
		System.out.println("myCity2 : "+ myCity2.name());
		System.out.println("myCity2의 ordnal : "+ myCity2.ordinal());
		System.out.println("========================================");
		
		Season ss = Season.valueOf("여름");
		System.out.println("name => "+ ss.name());
		System.out.println("ordinal => "+ ss.ordinal());
		System.out.println("getter메서드 호출값 => "+ ss.getData());
		System.out.println("-----------------------------------------");
		
		// 열거형이름.values() => 열거형 배열값을 반환함.
//		Season[] ssArr = Season.values();
//		for (Season s : ssArr) {
//			System.out.println(s.name()+ " : "+ s.getData());
//		}
//		Season[] ssArr = Season.values();
		for (Season s : Season.values()) {
			System.out.println(s.name()+ " : "+ s.getData());
		}
		System.out.println();
		
//		for (City city : City.values()) {
//			System.out.println(city.name()+" : "+ city.ordinal());
//		}
		City [] ccArr = City.values();
		for (City city : ccArr) {
			System.out.println(city.name()+" : "+ city.ordinal());
		}
		
		
		///비교, 라이언 장미 값만 비교해서 같은것으로 나왔던거...
		City city = City.대구;
		
		
		System.out.println(city == City.대구);
		System.out.println(city == City.대전);
		
//		System.out.println(city == HomeTown.대구);
		///호환되지 않아서 비교 자체를 할 수가 없다 이게나오는 이유는 단순히 값이 아닌 클래스타입정보까지 비교하기때문이다
		/// 타입이 틀리면 아예 비교자체가 안된다
		/// enum도 타입 안전한 코딩을 도와주는 문법이다
		
		////////////////////////////////////////////////
		
		///compareTo를 쓰는것을 보아 enum 상수들은 comparbal타입이기도 하다는 뜻이다
		///ordinal정보로 비교한것이다
		///public enum City { 서울, 부산, 대구, 광주, 대전}; 
		System.out.println("대구 => " + city.compareTo(city.대구));
		System.out.println("서울 => " + city.compareTo(city.서울)); 
		/// 서울 : 0, 대구 : 2 이므로 왼쪽에 있는 대구가 더 커서 양수가 나옴 
		System.out.println("대전 => " + city.compareTo(city.대전)); 
		/// 대구 : 2, 대전 : 4 이므로 오른쪽에 있는 대전이 더 크므로 음수가 나옴 
		
	}
	

}
