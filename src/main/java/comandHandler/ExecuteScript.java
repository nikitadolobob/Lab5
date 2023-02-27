package comandHandler;

/**
 * Элемент Pattern Command, описывающий конкретную команду executeScript.
 */
public class ExecuteScript implements Command{
    private final CommandSystem commandSystem;
    private final String filleName;

    /**
     * переопределённый метод, запускающий команду executeScript
     */
    @Override
    public void runCommand() {
        commandSystem.executeScript(filleName);
    }

    /**
     * Конструктор экземпляра executeScript.
     *
     * @param commandSystem элемент Pattern Command содержащий реализацию команды executeScript
     * @param filleName имя вводимого пользователем файла, с которым будет работать экземпляр команды
     */
    public ExecuteScript (CommandSystem commandSystem, String filleName){
        this.commandSystem = commandSystem;
        this.filleName = filleName;
    }
}
