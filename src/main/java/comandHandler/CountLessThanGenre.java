package comandHandler;

public class CountLessThanGenre implements Command{
    private CommandSystem commandSystem;
    private String genre;

    @Override
    public void runCommand() {
        commandSystem.countLessThanGenre(genre);
    }

    public CountLessThanGenre (CommandSystem commandSystem, String genre){
        this.commandSystem = commandSystem;
        this.genre = genre;
    }
}
