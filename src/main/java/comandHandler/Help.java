package comandHandler;

/**
 * Элемент Pattern Command, описывающий конкретную команду help.
 */
public class Help implements Command{
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
     * @param commandSystem элемент Pattern Command содержащий реализацию команды help
     */
    public Help (){

    }
}
