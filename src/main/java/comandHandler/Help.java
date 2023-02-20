package comandHandler;

public class Help implements Command{
    private CommandSystem commandSystem;

    @Override
    public void runCommand() {
        commandSystem.help();
    }

    public Help (CommandSystem commandSystem){
        this.commandSystem = commandSystem;
    }
}
