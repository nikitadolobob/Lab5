package comandHandler;

/**
 * Элемент Pattern Command, описывающий конкретную команду reorder.
 */
public class Reorder implements Command{
    private final CommandSystem commandSystem;

    /**
     * переопределённый метод, запускающий команду reorder
     */
    @Override
    public void runCommand() {
        commandSystem.reorder();
    }

    /**
     * Конструктор экземпляра reorder.
     *
     * @param commandSystem элемент Pattern Command содержащий реализацию команды reorder
     */
    public Reorder (CommandSystem commandSystem){
        this.commandSystem = commandSystem;
    }
}
