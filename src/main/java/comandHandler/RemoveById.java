package comandHandler;

/**
 * Элемент Pattern Command, описывающий конкретную команду removeById.
 */
public class RemoveById implements Command{
    private final CommandSystem commandSystem;
    private final int id;

    /**
     * переопределённый метод, запускающий команду removeById
     */
    @Override
    public void runCommand() {
        commandSystem.removeById(id);
    }

    /**
     * Конструктор экземпляра removeById.
     *
     * @param commandSystem элемент Pattern Command содержащий реализацию команды removeById
     * @param id вводимое пользователем поле, по значению которого будет вычислен удаляемый элемент
     */
    public RemoveById (CommandSystem commandSystem, int id){
        this.commandSystem = commandSystem;
        this.id = id;
    }
}
