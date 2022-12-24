package tobedeleted;

import java.util.Date;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		System.out.println(date.toString());
		System.out.println(date.toString().replace(" ", "_").replace(":", "_"));
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("java.version"));
		System.getProperties().list(System.out);
		

		

	}

}
