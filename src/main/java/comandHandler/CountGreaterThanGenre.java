package comandHandler;

/**
 * Элемент Pattern Command, описывающий конкретную команду CountGreaterThanGenre.
 */
public class CountGreaterThanGenre implements Command{
    private final CommandSystem commandSystem;
    private final String genre;

    /**
     * переопределённый метод, запускающий команду countGreaterThanGenre
     */
    @Override
    public void runCommand() {
        commandSystem.countGreaterThanGenre(genre);
    }

    /**
     * Конструктор экземпляра countGreaterThanGenre.
     *
     * @param commandSystem элемент Pattern Command содержащий реализацию команды countGreaterThanGenre
     * @param genre  вводимый пользователь жанр, по которому будет происходить необходимое сравнение
     */
    public CountGreaterThanGenre (CommandSystem commandSystem, String genre){
        this.commandSystem = commandSystem;
        this.genre = genre;
    }
}
