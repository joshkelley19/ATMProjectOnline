package kelley.josh.ATM.UI;

import java.util.Scanner;

public class UserInput {
    public Scanner scan = new Scanner(System.in);

    public String getString(){
        return scan.next();
    }
    public int getInt(){
        return scan.nextInt();
    }
    public double getDouble(){
        return scan.nextDouble();
    }
}
