package kr.or.ddit.basic;import sun.java2d.d3d.D3DSurfaceData;

public class T01ArgsTest {
	/*
	 	가변형 인수 => 메서드의 매개변수의 개수가 실행될 때마다 다를때 사용한다.
	 	///형태가 변할 수 있는것, 인수=argument=> 파라미터 값이 언제든지 바뀔 수 있다
	 		- 가변형 인수는 메서드 안에서 배열로 처리된다. ///파라미터 개수가 바뀔 수 있다
	 		- 가변형 인수는 한가지 자료형만 사용할 수 있다.
	 */
		// 배열을 이용한 메서드
		public int sumArr(int[] data) {
			int sum=0;
			for (int i = 0; i < data.length; i++) {
				sum+=data[i];
			}
			return sum;
		
		}
		
		// 가변형 인수를 이용한 메서드
		///배열로 한번 감싸지 않고도 쓸 수가 있다
		///내부적으로는 배열인것처럼 쓴다
		public int sumArgs(int...data) { ///int타입의 데이터가 여러개 들어올 수 있다
			int sum=0;
			for (int i = 0; i < data.length; i++) {
				sum+=data[i];
			}
			return sum;
		}
		
		// 가변형 인수와 일반적인 인수를 같이 사용할 경우에는 가변형 인수를 제일 뒤쪽에 배치한다
		public String sumArgs2(String name, int...data) {
			int sum=0;
			for (int i = 0; i < data.length; i++) {
				sum+=data[i];
			}
			return name+" 씨 점수 : "+sum;
		}
		
		public static void main(String[] args) {
			T01ArgsTest at = new T01ArgsTest(); 
			int [] nums = {100, 200, 300};
			System.out.println(at.sumArr(nums));
			System.out.println(at.sumArr(new int[] {1,2,3,4,5}));
			System.out.println();
			
			System.out.println(at.sumArgs(100,200,300));
			System.out.println(at.sumArgs(1,2,3,4,5));
			System.out.println();
			
			System.out.println(at.sumArgs2("홍길동", 1,2,3,4,5,6,7,8,9));
			
			
			
		}
		
		
		

}
