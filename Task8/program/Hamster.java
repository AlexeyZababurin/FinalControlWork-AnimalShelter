
import java.util.ArrayList;

public class Hamster extends Pets {
    public Hamster(Integer id, String name, String birth_date, ArrayList<String> command) {
        super(id, name, birth_date, command);
    }

    @Override
    public String toString() {
        return "Hamster {" +
                "name:" + super.getName() +
                ", birth date: " + super.getBirth_date() +
                ", commands: " + super.getCommand() +
                '}';
    } 
}
