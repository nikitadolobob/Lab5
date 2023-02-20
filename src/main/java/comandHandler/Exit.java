package comandHandler;

public class Exit implements Command{
    private CommandSystem commandSystem;

    @Override
    public void runCommand() {
        commandSystem.exit();
    }

    public Exit (CommandSystem commandSystem){
        this.commandSystem = commandSystem;
    }
}
