
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("rawtypes")
public class AnimalsService implements Service {
    private final List<Animals> animals;

    public AnimalsService() {
        this.animals = new ArrayList<>();
    }

    @Override
    public List<Animals> getAll() {
        return animals;
    }

    @SuppressWarnings({ "unchecked" })
    @Override
    public void createNewAnimal(Integer choice, String name, String birth_date, List command) {
        int countMaxId = 0;
        for (Animals animal : animals) {
            if (animal.getId() > countMaxId) {
                countMaxId = animal.getId();
            }
        }
        Animals newAnimal = null;
        switch (choice) {
            case 1:
                newAnimal = new Cat(++countMaxId, name, birth_date, (ArrayList<String>) command);
                break;
            case 2:
                newAnimal = new Dog(++countMaxId, name, birth_date, (ArrayList<String>)command);
                break;
            case 3:
                newAnimal = new Hamster(++countMaxId, name, birth_date, (ArrayList<String>)command);
                break;
            case 4:
                newAnimal = new Horse(++countMaxId, name, birth_date, (ArrayList<String>)command);
                break;
            case 5:
                newAnimal = new Donkey(++countMaxId, name, birth_date, (ArrayList<String>)command);
                break;
            case 6:
                newAnimal = new Camel(++countMaxId, name, birth_date, (ArrayList<String>)command);
                break;
            default:
                System.out.println("Incorrect type of animal");
                break;
        }
        if (newAnimal != null) {
            animals.add(newAnimal);
            System.out.println("A new animal has been added\n" + name);
            System.out.println();
        }
    }

    @Override
    public String showCommand(String name) {
        StringBuilder sb = new StringBuilder();
        for (Animals animals : animals) {
            if (animals.getName().equalsIgnoreCase(name)) {
                sb.append("Animal commands:\n");
                for (String command : animals.getCommand()) {
                    sb.append(" ");
                    sb.append(command);
                }
            }
        }
        if (!sb.isEmpty())
            return sb.toString();
        else
            return "Animal not found";
    }

    @Override
    public List<String> teachCommand(String name, String newCommand) {
        List<String> allCommands = new ArrayList<>();
        for (Animals animals : animals) {
            if (animals.getName().equalsIgnoreCase(name)) {
                animals.addCommand(newCommand);
            }
            allCommands.add(animals.getCommand().toString());
        }
        return allCommands.isEmpty() ? Collections.singletonList("Animal not found") : allCommands;
    }

    @Override
    public void getAllByBirthDate() {
        Collections.sort(animals, Comparator.comparing(Animals::getBirth_date));
        System.out.println("List of animals by date of birth:");
        for (Animals animals : animals) {
            System.out.println(animals);
            System.out.println();
        }
    }

    public int getAnimalsCount() {
        return animals.size();
    }
}
