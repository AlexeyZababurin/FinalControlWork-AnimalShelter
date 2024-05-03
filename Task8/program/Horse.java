
import java.util.ArrayList;

public class Horse extends Pack_Animals {
    public Horse(Integer id, String name, String birth_date, ArrayList<String> command) {
        super(id, name, birth_date, command);
    }

    @Override
    public String toString() {
        return "Horse {" +
                "name:" + super.getName() +
                ", birth date: " + super.getBirth_date() +
                ", commands: " + super.getCommand() +
                '}';
    }
}
