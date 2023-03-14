package comandHandler;

/**
 * Элемент Pattern Command, описывающий конкретную команду exit.
 */
public class Exit implements Command{

    /**
     * Реализация команды, завершающей работу приложения без сохранения изменений в файл, за исключением тех, что уже были отдельно сохранены командой save
     */
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
     */
    public Exit (){

    }
}
