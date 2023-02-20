package comandHandler;

public class CountGreaterThanGenre implements Command{
    private CommandSystem commandSystem;
    private String genre;

    @Override
    public void runCommand() {
        commandSystem.countGreaterThanGenre(genre);
    }

    public CountGreaterThanGenre (CommandSystem commandSystem, String genre){
        this.commandSystem = commandSystem;
        this.genre = genre;
    }
}
