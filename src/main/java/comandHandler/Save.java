package comandHandler;

/**
 * Элемент Pattern Command, описывающий конкретную команду save.
 */
public class Save implements Command{
    private final CommandSystem commandSystem;

    /**
     * переопределённый метод, запускающий команду save
     */
    @Override
    public void runCommand() {
        commandSystem.save();
    }

    /**
     * Конструктор экземпляра save.
     *
     * @param commandSystem элемент Pattern Command содержащий реализацию команды save
     */
    public Save (CommandSystem commandSystem){
        this.commandSystem = commandSystem;
    }
}
