package comandHandler;

public class RemoveById implements Command{
    private CommandSystem commandSystem;
    private int id;

    @Override
    public void runCommand() {
        commandSystem.removeById(id);
    }

    public RemoveById (CommandSystem commandSystem, int id){
        this.commandSystem = commandSystem;
    }
}
