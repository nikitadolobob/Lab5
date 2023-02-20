package comandHandler;

public class Save implements Command{
    private CommandSystem commandSystem;

    @Override
    public void runCommand() {
        commandSystem.save();
    }

    public Save (CommandSystem commandSystem){
        this.commandSystem = commandSystem;
    }
}
