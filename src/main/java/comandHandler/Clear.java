package comandHandler;

/**
 * Элемент Pattern Command, описывающий конкретную команду Clear.
 */
public class Clear implements Command{

    /**
     * Реализация команды, очищающей коллекцию (в результате коллекция, с которой мы работаем, становится пустой)
     */
    private void clear(){
        CommandSystem.arrayList.clear();
        System.out.println("The collection is empty now");
        System.out.println("Enter your next command: ");
    }

    /**
     * переопределённый метод, запускающий команду clear
     */
    @Override
    public void runCommand() {
        this.clear();
    }

    /**
     * Конструктор экземпляра clear.
     *
     */
    public Clear(){

    }
}
