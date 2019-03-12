package test;

public class Args {
	//가변사이즈 매개변수
	// a=>배열 참조 변수
	static void print(String... a) {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+"\t");
		}
	}

	public static void main(String[] args) {
		print("hello");
		print("hello","hi");
		print("hello","hi","good");
	}
}
