package comandHandler;

/**
 * Элемент Pattern Command, описывающий конкретную команду CountLessThanGenre.
 */
public class CountLessThanGenre implements Command{
    private final CommandSystem commandSystem;
    private final String genre;

    /**
     * переопределённый метод, запускающий команду countLessThanGenre
     */
    @Override
    public void runCommand() {
        commandSystem.countLessThanGenre(genre);
    }

    /**
     * Конструктор экземпляра countLessThanGenre.
     *
     * @param commandSystem элемент Pattern Command содержащий реализацию команды countLessThanGenre
     * @param genre вводимый пользователь жанр, по которому будет происходить необходимое сравнение
     */
    public CountLessThanGenre (CommandSystem commandSystem, String genre){
        this.commandSystem = commandSystem;
        this.genre = genre;
    }
}
