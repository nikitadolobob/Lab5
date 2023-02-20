package comandHandler;

public class Info implements Command{
    private CommandSystem commandSystem;

    @Override
    public void runCommand() {
        commandSystem.info();
    }

    public Info (CommandSystem commandSystem){
        this.commandSystem = commandSystem;
    }
}
