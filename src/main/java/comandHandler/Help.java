package comandHandler;

/**
 * Элемент Pattern Command, описывающий конкретную команду help.
 */
public class Help implements Command{
    private final CommandSystem commandSystem;

    /**
     * переопределённый метод, запускающий команду help
     */
    @Override
    public void runCommand() {
        commandSystem.help();
    }

    /**
     * Конструктор экземпляра help.
     *
     * @param commandSystem элемент Pattern Command содержащий реализацию команды help
     */
    public Help (CommandSystem commandSystem){
        this.commandSystem = commandSystem;
    }
}
