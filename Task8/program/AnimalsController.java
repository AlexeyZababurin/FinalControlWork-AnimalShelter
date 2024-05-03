
import java.util.ArrayList;
import java.util.List;

public class AnimalsController implements Controller<Animals> {
    private final AnimalsService animalsService =  new AnimalsService();
    private final Menu menu = new Menu();

    @Override
    public void createNewAnimal() {
        int choice = menu.getTypeAnimal();
        String name = menu.getName();
        String birth_date = menu.getBirthDate();
        String command1 = menu.teachCommand();
        List<String> command = new ArrayList<>();
        command.add(command1);
        animalsService.createNewAnimal(choice, name, birth_date, command);
    }

    @Override
    public void showCommands() {
        System.out.println("Animal commands.");
        String name = menu.getName();
        String showCommands = animalsService.showCommand(name);
        menu.printOnConsole(showCommands);
    }

    @Override
    public void teachCommand() {
        String name = menu.getName();
        String newCommand = menu.teachCommand();
        animalsService.teachCommand(name, newCommand);
    }

    @Override
    public void getAllByBirthDate() {
        animalsService.getAllByBirthDate();
    }

    @Override
    public void getAnimalsCount() {
        animalsService.getAnimalsCount();
        String result = String.valueOf(animalsService.getAnimalsCount());
        menu.printOnConsole(result);
    }
}
