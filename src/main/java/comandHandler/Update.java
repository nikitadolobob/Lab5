package comandHandler;

/**
 * Элемент Pattern Command, описывающий конкретную команду update.
 */
public class Update implements Command{
    private final CommandSystem commandSystem;
    private final int id;

    /**
     * переопределённый метод, запускающий команду update
     */
    @Override
    public void runCommand() {
        commandSystem.update(id);
    }

    /**
     * Конструктор экземпляра update.
     *
     * @param commandSystem элемент Pattern Command содержащий реализацию команды update
     * @param id вводимое пользователем поле, по значению которого будет вычислен изменяемый элемент
     */
    public Update (CommandSystem commandSystem, int id){
        this.commandSystem = commandSystem;
        this.id = id;
    }
}
