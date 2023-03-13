package comandHandler;

/**
 * Элемент Pattern Command, описывающий конкретную команду exit.
 */
public class Exit implements Command{
    private void exit(){
        System.exit(0);
    }

    /**
     * переопределённый метод, запускающий команду exit
     */
    @Override
    public void runCommand() {
        this.exit();
    }

    /**
     * Конструктор экземпляра exit.
     *
     * @param commandSystem элемент Pattern Command содержащий реализацию команды exit
     */
    public Exit (){

    }
}
