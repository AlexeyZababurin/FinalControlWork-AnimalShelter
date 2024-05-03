
import java.util.ArrayList;

public abstract class Pets extends Animals {
    public Pets(Integer id, String name, String birth_date, ArrayList<String> command) {
        super(id, name, birth_date, command);
    }
}