package Main;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Dog implements HttpSessionBindingListener {

	private String breed;

	public Dog(String bread) {
		this.breed = bread;
	}

	public String getBreed() {
		return breed;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		// 如果我知道我在一个会话中，就运行这段代码
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		// 如果我知道我不在一个回话中，就运行这段代码
	}
}
