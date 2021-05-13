package design;

import java.util.List;
import java.util.Scanner;

public class CashRegisterTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.next();
		String[] input = line.split(";");
		double pp = Double.parseDouble(input[0]);
		double cash = Double.parseDouble(input[1]);
		CashRegister cr = new CashRegister();
		List<String> change = cr.getChange(pp, cash);
		for(int i = 0; i < change.size(); i++) {
			System.out.println(change.get(i));
		}
	}
}