package comandHandler;

/**
 * Элемент Pattern Command, описывающий конкретную команду addIfMin
 */
public class AddIfMin implements Command{
    private final CommandSystem commandSystem;

    /**
     * переопределённый метод, запускающий команду addIfMin
     */
    @Override
    public void runCommand() {
        commandSystem.addIfMin();
    }

    /**
     * Конструктор экземпляра addIfMin
     *
     * @param commandSystem элемент Pattern Command содержащий реализацию команды addIfMin
     */
    public AddIfMin(CommandSystem commandSystem){
        this.commandSystem = commandSystem;
    }
}
