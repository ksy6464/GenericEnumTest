package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T05WildCardTest {
	
/*
  	 와일드 카드에 대해여...
  	
  	와일드 카드(?)는 제너릭 타입을 지정하기 위해 사용되는 특별한 종류의 인수(Argument)로서,
  	변수선언, 객체생성 및 메서드를 정의 할 때 사용된다.
  	///어떤 타입이 ?이면 아직 모른다, 구체화되지 않았다 근데 제너릭이면 T로 쓰면 되는거 아님? 근데 T는 선언할때 쓸 수 있는거임
 	///아직 정해지지 않았다는 의미를 담기를 필요로 하는데 그게 ?이다
 	///등장한 이유는  제너릭 문법이 있어서 나온거다 why 아직 정해지지 않은 타입을 하고 싶어서
  	
  	<? extends T> => 와일드 카드의 상한 제한. T와 그 자손들만 가능
  	<? super T>	  => 와일드 카드의 하한 제한. T와 그 조상들만 가능
  	<?>			  => 허용가능한 모든 타입 가능.
 */
	

	public static void main(String[] args) {
		
//		List<E> list = new ArrayList<E>(); ///이러면 에러임, 사용시점에는 타입을 정해줘야한다
//		List<?> list = new ArrayList<Integer>(); ///이게 와일드카드이다
		
		
		
		
		
		///과일 상자 정의
//		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Fruit> fruitBox = new FruitBox<>(); 
		///JDK8 이상이면 앞에서 쓴타입을 생략해도 된다 잘보면 다이아몬드 모양이라서 다이아몬드 문법이라고 한다
		FruitBox<Apple> appleBox = new FruitBox<>(); 
		
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		
		appleBox.add(new Apple());
		appleBox.add(new Apple());
//		appleBox.add(new Grape()); 
		///Apple박스는 타입을 Apple만 들어오게했으므로 타입 Grape는 들어올 수 없어서 빨간줄뜸 
		
		
		Jucer.makeJuice(fruitBox);
		Jucer.makeJuice(appleBox); 
		///원래 에러가 났었다 왜? Fruit 타입만 되는데 appleBox은 Apple 타입이라서...그래서 제너릭 메소드로 만들어줌
		///이렇게 바꾸면 뭐든 들어갈 수 있다 음식물쓰레기 이런것들도...그러니깐 타입제한을 걸어야한다
		
		
	}
	
}

///파라미터로 과일상자 받아서 거기서 과일을 꺼내서 쥬스를 만드는 메서드
///static메서드와 인스턴스메서드(static이 안붙은것) 둘의 차이점은
///인스턴스 메서드는 사용하기 위해서 객체를 생성해야 하고   static은 객체 만들필요가 없다.
///즉, 인스턴스 안만들고 메서드를 만들때 static 메서드를 만든다.
///Util(유용한 기능) 할때는 static 메서드를 많이 쓴다
class Jucer{
//	static void makeJuice(FruitBox<Fruit> box) {
//	static <T>void makeJuice(FruitBox<T> box) { ///사과도 바로 넣고 싶어서 만들음
//	static <T extends Fruit>void makeJuice(FruitBox<T> box) { ///제너릭 방식인데 제한까지
//	static void makeJuice(FruitBox<?> box) { ///와일드카드 방식 
	static void makeJuice(FruitBox<? extends Fruit> box) { ///와일드카드방식인데 제한까지 걸음 
	///1. 이제는 Fruit와 하위들 올 수 있음
		
		String fruitListstr = " "; //과일목로
		
		int cnt = 0;
//		for (Fruit f : box.getFruitList()) { 
//		for (T f : box.getFruitList()) { ///제너릭 메서드
		for (Object f : box.getFruitList()) { ///와일드카드, 이제 제너릭 메서드가 아니다
			if(cnt==0) {
				fruitListstr+=f;
				///첫번째 과일이면 ","가 필용 없으니깐
			}else {
				fruitListstr+="," +f;
			}
			
			cnt++;
			
		}
		System.out.println(fruitListstr+"=> 쥬스 완성~~~!");
	}
}







///클래스를 계층형으로 구조해보겠다
class Fruit{
	private String name;

	public Fruit(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "과일(" + name + ")";
	}
}


///과일을 상속받은 애플 클래스 만들기
class Apple extends Fruit{
	public Apple() {
		super("사과");
	}
}

class Grape extends Fruit{
	public Grape() {
		super("포도");
	}
}


///과일을 담을 수 있는 상자
class FruitBox<T> {
//class FruitBox<T extends Fruit> { 
	///2.이 방법으로도 음식물쓰레기 같은것들말고 과일타입들과 그 하위들만 받을 수 있게 만들어줌
	private List<T> fruitList;
	
	public FruitBox() {
		fruitList = new ArrayList<>();
		
	}

	public List<T> getFruitList() {
		return fruitList;
	}

	public void add(T fruit) {
		fruitList.add(fruit);
	}
	
}







