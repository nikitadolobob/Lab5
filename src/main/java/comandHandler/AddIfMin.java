package comandHandler;

public class AddIfMin implements Command{
    private CommandSystem commandSystem;

    @Override
    public void runCommand() {
        commandSystem.addIfMin();
    }

    public AddIfMin(CommandSystem commandSystem){
        this.commandSystem = commandSystem;
    }
}
