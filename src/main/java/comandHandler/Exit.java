package comandHandler;

/**
 * Элемент Pattern Command, описывающий конкретную команду exit.
 */
public class Exit implements Command{
    private final CommandSystem commandSystem;

    /**
     * переопределённый метод, запускающий команду exit
     */
    @Override
    public void runCommand() {
        commandSystem.exit();
    }

    /**
     * Конструктор экземпляра exit.
     *
     * @param commandSystem элемент Pattern Command содержащий реализацию команды exit
     */
    public Exit (CommandSystem commandSystem){
        this.commandSystem = commandSystem;
    }
}
