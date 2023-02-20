package comandHandler;

public class Clear implements Command{
    private CommandSystem commandSystem;

    @Override
    public void runCommand() {
        commandSystem.clear();
    }

    public Clear(CommandSystem commandSystem){
        this.commandSystem = commandSystem;
    }
}
