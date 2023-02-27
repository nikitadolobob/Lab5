package comandHandler;

/**
 * Элемент Pattern Command имплементируемый всеми командами приложения
 */
public interface Command {
    /**
     * метод, переопределяемый и реализуемый по своему для каждой конкретной команды
     */
    void runCommand();
}
