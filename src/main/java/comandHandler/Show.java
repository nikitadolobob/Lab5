package comandHandler;

public class Show implements Command{
    private CommandSystem commandSystem;

    @Override
    public void runCommand() {
        commandSystem.show();
    }

    public Show (CommandSystem commandSystem){
        this.commandSystem = commandSystem;
    }
}
