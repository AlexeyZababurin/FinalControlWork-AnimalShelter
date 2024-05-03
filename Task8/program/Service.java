
import java.util.List;

public interface Service <T extends Animals> {
    List<T> getAll();
    void createNewAnimal(Integer choice, String name, String birth_date, List<String> command);
    String showCommand(String name);
    public List<String> teachCommand(String name, String newCommand);
    void getAllByBirthDate();
    public int getAnimalsCount();
}
