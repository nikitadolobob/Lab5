package comandHandler;

/**
 * Элемент Pattern Command, определяющий исполняемую команду
 */
public class Controller{
    private Command command;

    /**
     * метод, устанавливающий команду, которую контролер сейчас будет исполнять
     *
     * @param command команда(класс имплементирующий интерфэйс Command), которую сейчас будет исполнять контроллер
     */
    public void setCommand(Command command){
        this.command = command;
    }

    /**
     * Метод, исполняющий выбранную в setCommand команду
     */
    public void executeCommand(){
        command.runCommand();
    }
}
