package comandHandler;

public enum Commands {
    HELP("help", "describes all commands"){
        @Override
        void runCommand(){
            Command help = new Help(UserInput.commandSystem);
            UserInput.controller.setCommand(help);
            UserInput.controller.executeCommand();
        }
    },
    INFO("info", "gives data on collections"){
        @Override
        void runCommand(){
            Command info = new Info(UserInput.commandSystem);
            UserInput.controller.setCommand(info);
            UserInput.controller.executeCommand();
        }
    },
    SHOW("show", "demonstrates all collection elements"){
        @Override
        void runCommand(){
            Command show = new Show(UserInput.commandSystem);
            UserInput.controller.setCommand(show);
            UserInput.controller.executeCommand();
        }
    },
    ADD("add", "adds ellement to collection"){
        @Override
        void runCommand(){
            Command add = new Add(UserInput.commandSystem);
            UserInput.controller.setCommand(add);
            UserInput.controller.executeCommand();
        }
    },
    UPDATE("update", "changes element with given id"){
        @Override
        void runCommand(int id){
            Command update = new Update(UserInput.commandSystem, id);
            UserInput.controller.setCommand(update);
            UserInput.controller.executeCommand();
        }
    },
    REMOVE_BY_ID("remove_by_id", "removes element with given id"){
        @Override
        void runCommand(int id){
            Command remove = new RemoveById(UserInput.commandSystem, id);
            UserInput.controller.setCommand(remove);
            UserInput.controller.executeCommand();
        }
    },
    CLEAR("clear", "makes the collection empty"){
        @Override
        void runCommand(){
            Command clear = new Clear(UserInput.commandSystem);
            UserInput.controller.setCommand(clear);
            UserInput.controller.executeCommand();
        }
    },
    SAVE("save", "saves the collection to the fille"){
        @Override
        void runCommand(){
            Command save = new Save(UserInput.commandSystem);
            UserInput.controller.setCommand(save);
            UserInput.controller.executeCommand();
        }
    },
    EXECUTE_SCRIPT("execute_script", "executes your script from a given fille"){
        @Override
        void runCommand(String filleName){
            Command executeScript = new ExecuteScript(UserInput.commandSystem, filleName);
            UserInput.controller.setCommand(executeScript);
            UserInput.controller.executeCommand();
        }
    },
    EXIT("exit", "finishes the programm without saving collection to the fille"){
        @Override
        void runCommand(){
            Command exit = new Exit(UserInput.commandSystem);
            UserInput.controller.setCommand(exit);
            UserInput.controller.executeCommand();
        }
    },
    REMOVE_LAST("remove_last", "removes the last element of collection"){
        @Override
        void runCommand(){
            Command removeLast = new RemoveLast(UserInput.commandSystem);
            UserInput.controller.setCommand(removeLast);
            UserInput.controller.executeCommand();
        }
    },
    ADD_IF_MIN("add_if_min", "adds an element to collection if it is less than current collection minimum"){
        @Override
        void runCommand(){
            Command addIfMin = new AddIfMin(UserInput.commandSystem);
            UserInput.controller.setCommand(addIfMin);
            UserInput.controller.executeCommand();
        }
    },
    REORDER("reorder", "reverses the order of the collection"){
        @Override
        void runCommand(){
            Command reorder = new Reorder(UserInput.commandSystem);
            UserInput.controller.setCommand(reorder);
            UserInput.controller.executeCommand();
        }
    },
    COUNT_LES_THAN_GENRE("count_les_than_genre", "tells the ammount of elements whiches genre is lesser than given"){
        @Override
        void runCommand(String genre){
            Command countLessThanGenre = new CountLessThanGenre(UserInput.commandSystem, genre);
            UserInput.controller.setCommand(countLessThanGenre);
            UserInput.controller.executeCommand();
        }
    },
    COUNT_GREATER_THAN_GENRE("count_greater_than_genre", "tells the amount of elements with gener greater than given"){
        @Override
        void runCommand(String genre){
            Command countGreaterThanGenre = new CountGreaterThanGenre(UserInput.commandSystem, genre);
            UserInput.controller.setCommand(countGreaterThanGenre);
            UserInput.controller.executeCommand();
        }
    },
    FILTER_GREATER_THAN_GENRE("filter_greater_than_genre", "outputs the elements with gener greater than given"){
        @Override
        void runCommand(String genre){
            Command filterGreaterThanGenre = new FilterGreaterThanGenre(UserInput.commandSystem, genre);
            UserInput.controller.setCommand(filterGreaterThanGenre);
            UserInput.controller.executeCommand();
        }
    };

    Commands(String commandName, String description) {
        this.commandName = commandName;
        this.description = description;
    }
    void runCommand(){}
    void runCommand(String s){}
    void runCommand(int id){}

    final public String commandName;
    final public String description;
    public String getCommandName(){
        return this.commandName;
    }
}
