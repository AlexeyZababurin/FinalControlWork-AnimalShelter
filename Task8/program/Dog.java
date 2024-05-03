
import java.util.ArrayList;

public class Dog extends Pets {
    public Dog(Integer id, String name, String birth_date, ArrayList<String> command) {
        super(id, name, birth_date, command);
    }

    @Override
    public String toString() {
        return "Dog {" +
                "name:" + super.getName() +
                ", birth date: " + super.getBirth_date() +
                ", commands: " + super.getCommand() +
                '}';
    }
}
