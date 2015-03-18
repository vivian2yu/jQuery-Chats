package main;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class TestStringFunc {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub

		// String a = null;
		// System.out.println("a 的a.trim(): " + a.trim());
		// System.out.println("a 的长度 a.length: " + a.length());

		// 将application/x-www-from-urlencoded字符串转换成普通字符串
		String keyWord = URLDecoder.decode("%E6%9D%8E%E5%88%9A", "UTF-8");
		System.out.println(keyWord);

		// 将普通字符创转换成application/x-www-from-urlencoded字符串
		String urlString = URLEncoder.encode("爱我中华", "UTF-8");
		System.out.println(urlString);

		String s1 = "a";
		String s2 = s1 + "b";
		String s3 = "a" + "b";

		System.out.println(s2 == "ab");
		System.out.println(s3 == "ab");
		System.out.println(s2 == s3);
	}

}
