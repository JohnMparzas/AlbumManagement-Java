package print_exit;

import java.util.Scanner;
public class Exit{ // eksodos apo programa 
	public Exit(){
		System.out.println("Eisai sigouros oti theleis na bgeis apo to programma?(yes/no)");
		Scanner input = new Scanner(System.in);
		if(input.next().equals("yes")){
			System.exit(0);
		}
		return;
	}
}