package main;

public class TestZhiOrYinyong {

	public void test(int a) {
		a = 5;
		System.out.println("test func a=" + a);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 3;
		TestZhiOrYinyong tt = new TestZhiOrYinyong();
		tt.test(a);
		System.out.println("main func a=" + a);
	}

}
