package comandHandler;

/**
 * Элемент Pattern Command, описывающий конкретную команду Clear.
 */
public class Clear implements Command{
    private final CommandSystem commandSystem;

    /**
     * переопределённый метод, запускающий команду clear
     */
    @Override
    public void runCommand() {
        commandSystem.clear();
    }

    /**
     * Конструктор экземпляра clear.
     *
     * @param commandSystem элемент Pattern Command содержащий реализацию команды Clear
     */
    public Clear(CommandSystem commandSystem){
        this.commandSystem = commandSystem;
    }
}
