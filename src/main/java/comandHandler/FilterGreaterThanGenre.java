package comandHandler;

/**
 * Элемент Pattern Command, описывающий конкретную команду filterGreaterThanGenre.
 */
public class FilterGreaterThanGenre implements Command{
    private final CommandSystem commandSystem;
    private final String genre;

    /**
     * переопределённый метод, запускающий команду filterGreaterThanGenre
     */
    @Override
    public void runCommand() {
        commandSystem.filterGreaterThanGenre(genre);
    }

    /**
     * Конструктор экземпляра filterGreaterThanGenre.
     *
     * @param commandSystem элемент Pattern Command содержащий реализацию команды filterGreaterThanGenre
     * @param genre вводимый пользователь жанр, по которому будет происходить необходимое сравнение
     */
    public FilterGreaterThanGenre (CommandSystem commandSystem, String genre){
        this.commandSystem = commandSystem;
        this.genre = genre;
    }
}
