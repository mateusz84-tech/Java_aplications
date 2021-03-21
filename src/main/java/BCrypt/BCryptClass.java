package BCrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Scanner;

public class BCryptClass {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        Scanner input = new Scanner(System.in);
        System.out.print("Wpisz hasło: ");
        while(!input.hasNext("\\D{8,12}+[1-9]+")){
            input.next();
            System.out.println("Hasło powinno zwierać litery i cyfry. Min 8 znaków max 12");
        }
        String password = input.next();
        String result = encoder.encode(password);
        System.out.println("Wpisane hasło: " + password);
        System.out.println("Zakodowane hasło: " + result);
    }
}
