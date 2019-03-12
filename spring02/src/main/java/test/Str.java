package test;

import com.example.spring02.util.MediaUtils;

public class Str {
	public static void main(String[] args) {
		String str="aaa.bbb.ccc.ddd.eee.jpg";
		System.out.println(  str.lastIndexOf(".")+1);
		System.out.println(
				str.substring(str.lastIndexOf(".")+1));
		System.out.println( MediaUtils.getMediaType("jsp"));
		System.out.println( MediaUtils.getMediaType("png"));
	}
}
