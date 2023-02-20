package comandHandler;

public class RemoveLast implements Command{
    private CommandSystem commandSystem;

    @Override
    public void runCommand() {
        commandSystem.removeLast();
    }

    public RemoveLast (CommandSystem commandSystem){
        this.commandSystem = commandSystem;
    }
}
