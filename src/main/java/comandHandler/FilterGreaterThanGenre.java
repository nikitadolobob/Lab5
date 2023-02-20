package comandHandler;

public class FilterGreaterThanGenre implements Command{
    private CommandSystem commandSystem;
    private String genre;

    @Override
    public void runCommand() {
        commandSystem.filterGreaterThanGenre(genre);
    }

    public FilterGreaterThanGenre (CommandSystem commandSystem, String genre){
        this.commandSystem = commandSystem;
        this.genre = genre;
    }
}
