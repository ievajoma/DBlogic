import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        DBlogic db = new DBlogic();
        Scanner scan = new Scanner(System.in);

        db.addUser("suns", "kopaa");

        db.getUsers();

        System.out.println("Which user you want to delete?: ");
        int user_choice = scan.nextInt();

        db.deleteUsers(user_choice);

        db.getUsers();

        System.out.println("Which user you want to update?: ");
        int update_choice = scan.nextInt();

        System.out.println("Enter new password: ");
        String new_password = scan.next();

        db.updateUsers(new_password, update_choice);

    }
}