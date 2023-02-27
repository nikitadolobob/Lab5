package comandHandler;

/**
 * Элемент Pattern Command, описывающий конкретную команду info.
 */
public class Info implements Command{
    private final CommandSystem commandSystem;

    /**
     * переопределённый метод, запускающий команду info
     */
    @Override
    public void runCommand() {
        commandSystem.info();
    }

    /**
     * Конструктор экземпляра info.
     *
     * @param commandSystem элемент Pattern Command содержащий реализацию команды info
     */
    public Info (CommandSystem commandSystem){
        this.commandSystem = commandSystem;
    }
}
