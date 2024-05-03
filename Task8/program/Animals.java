import java.util.ArrayList;

public abstract class Animals {
    private Integer id;
    private String name;
    private String birth_date;
    public ArrayList<String> command;

    public Animals(Integer id, String name, String birth_date, ArrayList<String> command) {
        this.id = id;
        this.name = name;
        this.birth_date = birth_date;
        this.command = command;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBirth_date() {
        return birth_date;
    }
    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }
    public ArrayList<String> getCommand() {
        return command;
    }
    public void setCommand(ArrayList<String> command) {
        this.command = command;
    }
    public void addCommand(String newCommand) {
        command.add(newCommand);
    }
}