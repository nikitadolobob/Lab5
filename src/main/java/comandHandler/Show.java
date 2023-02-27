package comandHandler;

/**
 * Элемент Pattern Command, описывающий конкретную команду show.
 */
public class Show implements Command{
    private final CommandSystem commandSystem;

    /**
     * переопределённый метод, запускающий команду show
     */
    @Override
    public void runCommand() {
        commandSystem.show();
    }

    /**
     * Конструктор экземпляра show.
     *
     * @param commandSystem элемент Pattern Command содержащий реализацию команды show
     */
    public Show (CommandSystem commandSystem){
        this.commandSystem = commandSystem;
    }
}
