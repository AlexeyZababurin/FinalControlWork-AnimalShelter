
import java.util.ArrayList;

public class Donkey extends Pack_Animals {
    public Donkey(Integer id, String name, String birth_date, ArrayList<String> command) {
        super(id, name, birth_date, command);
    }

    @Override
    public String toString() {
        return "Donkey {" +
                "name:" + super.getName() +
                ", birth date: " + super.getBirth_date() +
                ", commands: " + super.getCommand() +
                '}';
    }
}
