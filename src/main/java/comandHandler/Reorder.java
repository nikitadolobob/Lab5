package comandHandler;

public class Reorder implements Command{
    private CommandSystem commandSystem;

    @Override
    public void runCommand() {
        commandSystem.reorder();
    }

    public Reorder (CommandSystem commandSystem){
        this.commandSystem = commandSystem;
    }
}
