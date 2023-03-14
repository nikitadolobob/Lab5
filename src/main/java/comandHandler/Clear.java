package comandHandler;

/**
 * Элемент Pattern Command, описывающий конкретную команду Clear.
 */
public class Clear implements Command{
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
     * @param commandSystem элемент Pattern Command содержащий реализацию команды Clear
     */
    public Clear(){

    }
}
