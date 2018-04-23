import java.util.Scanner;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException{
		
		Scanner in = new Scanner(System.in);
		
		
		System.out.println("What's your zipcode?");
		String zipcode = in.nextLine();
		System.out.println(Weather.getLocalTemp(zipcode));

	}

}
