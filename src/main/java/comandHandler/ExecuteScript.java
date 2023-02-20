package comandHandler;

public class ExecuteScript implements Command{
    private CommandSystem commandSystem;
    private String filleName;

    @Override
    public void runCommand() {
        commandSystem.executeScript(filleName);
    }

    public ExecuteScript (CommandSystem commandSystem, String filleName){
        this.commandSystem = commandSystem;
        this.filleName = filleName;
    }
}
