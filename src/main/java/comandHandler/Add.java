package comandHandler;

/**
 * Элемент Pattern Command, описывающий конкретную команду add
 */
public class Add implements Command {
    private final CommandSystem commandSystem;

    /**
     * переопределённый метод, запускающий команду add
     */
    @Override
    public void runCommand() {
        commandSystem.add();
    }

    /**
     * Конструктор экземпляра add
     *
     * @param commandSystem элемент Pattern Command содержащий реализацию команды add
     */
    public Add(CommandSystem commandSystem){
        this.commandSystem = commandSystem;
    }
}
