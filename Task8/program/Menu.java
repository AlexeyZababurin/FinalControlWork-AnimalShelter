
import java.util.Scanner;

public class Menu {
    public void printOnConsole(String str) {
        System.out.println(str);
    }

    public void getMenu() {
        AnimalsController animalsController = new AnimalsController();
        boolean flag = true;
        while (flag) {

            System.out.println("Menu:\n 1 - Add new animal\n 2 - List of animal commands\n 3 - Learning new commands\n 4 - List of animals by date of birth\n 5 - Number of animals\n 0 - Exit\n");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    animalsController.createNewAnimal();
                    break;
                case 2:
                    animalsController.showCommands();
                    break;
                case 3:
                    animalsController.teachCommand();
                    break;
                case 4:
                    animalsController.getAllByBirthDate();
                    break;
                case 5:
                    animalsController.getAnimalsCount();
                case 0:
                    flag = false;
                    System.out.println("Exiting the program.\n");
                    break;
                default:
                    System.out.println("There is no such command.\n");
            }
        }
    }

    public Integer getTypeAnimal() {
        System.out.println("Create new animal.");
        System.out.println("Choose the type of animal:\n 1 - Cat\n 2 - Dog\n 3 - Hamster\n 4 - Horse\n 5 - Donkey\n 6 - Camel\n");
        Scanner scanner = new Scanner(System.in);
        Integer result = scanner.nextInt();
        return result;
    }

    public String getName() {
        System.out.println("Enter the name of the animal:");
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        return result;
    }

    public String getBirthDate() {
        System.out.println("Enter the date of birth of the animal in the format yyyy-mm-dd:");
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        return result;
    }

    public String teachCommand() {
        System.out.println("Enter the command:");
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        return result;
    }
}
