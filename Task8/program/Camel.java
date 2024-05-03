
import java.util.ArrayList;

public class Camel extends Pack_Animals {
    public Camel(Integer id, String name, String birth_date, ArrayList<String> command) {
        super(id, name, birth_date, command);
    }

    @Override
    public String toString() {
        return "Camel {" +
                "name:" + super.getName() +
                ", birth date: " + super.getBirth_date() +
                ", commands: " + super.getCommand() +
                '}';
    }
}
