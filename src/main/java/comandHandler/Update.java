package comandHandler;

public class Update implements Command{
    private CommandSystem commandSystem;
    private int id;

    @Override
    public void runCommand() {
        commandSystem.update(id);
    }

    public Update (CommandSystem commandSystem, int id){
        this.commandSystem = commandSystem;
        this.id = id;
    }
}
