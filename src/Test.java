import java.util.Scanner;

public class Test {

	public void test() {
		Library li = new Library();
		Login lo  = new Login();
		System.out.println("Molimo vas unesite vase korisnicko ime i  vasu  lozinku ");
		Scanner sc = new Scanner(System.in);
		String username = sc.next();
		String password = sc.next();
		System.out.println(lo.validate(username, password));
	}
}
