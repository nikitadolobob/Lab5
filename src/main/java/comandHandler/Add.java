package comandHandler;

public class Add implements Command {
    private CommandSystem commandSystem;

    @Override
    public void runCommand() {
        commandSystem.add();
    }

    public Add(CommandSystem commandSystem){
        this.commandSystem = commandSystem;
    }
}
