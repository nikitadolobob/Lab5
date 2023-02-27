package comandHandler;

/**
 * Элемент Pattern Command, описывающий конкретную команду removeLast.
 */
public class RemoveLast implements Command{
    private final CommandSystem commandSystem;

    /**
     * переопределённый метод, запускающий команду removeLast
     */
    @Override
    public void runCommand() {
        commandSystem.removeLast();
    }

    /**
     * Конструктор экземпляра removeLast.
     *
     * @param commandSystem элемент Pattern Command содержащий реализацию команды removeLast
     */
    public RemoveLast (CommandSystem commandSystem){
        this.commandSystem = commandSystem;
    }
}
