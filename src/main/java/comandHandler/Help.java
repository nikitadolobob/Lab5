package comandHandler;

/**
 * Элемент Pattern Command, описывающий конкретную команду help.
 */
public class Help implements Command{

    /**
     * Реализация команды, выводящей на консоль информацию о каждой команде приложения
     */

    private void help(){
        for(Commands command : Commands.values()){
            System.out.println(command.commandName + ": " + command.description);
        }
        System.out.println("Enter your next command: ");
    }

    /**
     * переопределённый метод, запускающий команду help
     */
    @Override
    public void runCommand() {
        this.help();
    }

    /**
     * Конструктор экземпляра help.
     *
     */
    public Help (){

    }
}
