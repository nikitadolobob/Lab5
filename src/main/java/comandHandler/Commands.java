package comandHandler;

/**
 * Енам всех команд приложения имеет две цели:
 * 1) при вводе пользователем команды довольно просто, без условия под каждую команду, можно установить команду и выполнить её
 * 2) при выполнении команды help при помощи введённых через конструктор имени и описания команды, проще оперировать с выводимыми данными
 */
public enum Commands {
    /**
     * Команда, выводящая в консоль информацию обо всех командах приложения
     */
    HELP("help", "describes all commands"){
        @Override
        void runCommand(){
            Command help = new Help();
            UserInput.controller.setCommand(help);
            UserInput.controller.executeCommand();
        }
    },
    /**
     * Команда, выводящая в консоль информацию о коллекции
     */
    INFO("info", "gives data on collections"){
        @Override
        void runCommand(){
            Command info = new Info();
            UserInput.controller.setCommand(info);
            UserInput.controller.executeCommand();
        }
    },
    /**
     * Команда, выводящая в консоль все элементы коллекции
     */
    SHOW("show", "demonstrates all collection elements"){
        @Override
        void runCommand(){
            Command show = new Show();
            UserInput.controller.setCommand(show);
            UserInput.controller.executeCommand();
        }
    },
    /**
     * Команда, добавляющая в конец коллекции введённый пользователем фильм
     */
    ADD("add", "adds ellement to collection"){
        @Override
        void runCommand(){
            Command add = new Add();
            UserInput.controller.setCommand(add);
            UserInput.controller.executeCommand();
        }
    },
    /**
     * Команда, вносящая заданные пользователем изменения в элемент коллекции с заданным id
     */
    UPDATE("update", "changes element with given id"){
        @Override
        void runCommand(int id){
            Command update = new Update(id);
            UserInput.controller.setCommand(update);
            UserInput.controller.executeCommand();
        }
    },
    /**
     * Команда, удаляющая из коллекции элемент с заданным id
     */
    REMOVE_BY_ID("remove_by_id", "removes element with given id"){
        @Override
        void runCommand(int id){
            Command remove = new RemoveById(id);
            UserInput.controller.setCommand(remove);
            UserInput.controller.executeCommand();
        }
    },
    /**
     * Команда, очищающая коллекцию
     */
    CLEAR("clear", "makes the collection empty"){
        @Override
        void runCommand(){
            Command clear = new Clear();
            UserInput.controller.setCommand(clear);
            UserInput.controller.executeCommand();
        }
    },
    /**
     * Команда, сохраняющая актуальное состояние коллекции в файл
     */
    SAVE("save", "saves the collection to the fille"){
        @Override
        void runCommand(){
            Command save = new Save();
            UserInput.controller.setCommand(save);
            UserInput.controller.executeCommand();
        }
    },
    /**
     * Команда, выполняющая команды из заданного пользователем файла
     */
    EXECUTE_SCRIPT("execute_script", "executes your script from a given fille"){
        @Override
        void runCommand(String filleName){
            Command executeScript = new ExecuteScript(filleName);
            UserInput.controller.setCommand(executeScript);
            UserInput.controller.executeCommand();
        }
    },
    /**
     * Команда, завершающая работу приложения
     */
    EXIT("exit", "finishes the programm without saving collection to the fille"){
        @Override
        void runCommand(){
            Command exit = new Exit();
            UserInput.controller.setCommand(exit);
            UserInput.controller.executeCommand();
        }
    },
    /**
     * Команда, удаляющая последний элемент коллекции, при его наличии
     */
    REMOVE_LAST("remove_last", "removes the last element of collection"){
        @Override
        void runCommand(){
            Command removeLast = new RemoveLast();
            UserInput.controller.setCommand(removeLast);
            UserInput.controller.executeCommand();
        }
    },
    /**
     * Команда добавляющая элемент в коллекцию, если он меньше минимального элемента коллекции
     */
    ADD_IF_MIN("add_if_min", "adds an element to collection if it is less than current collection minimum"){
        @Override
        void runCommand(){
            Command addIfMin = new AddIfMin();
            UserInput.controller.setCommand(addIfMin);
            UserInput.controller.executeCommand();
        }
    },
    /**
     * Команда, переставляющая элементы коллекции в обратном порядке
     */
    REORDER("reorder", "reverses the order of the collection"){
        @Override
        void runCommand(){
            Command reorder = new Reorder();
            UserInput.controller.setCommand(reorder);
            UserInput.controller.executeCommand();
        }
    },
    /**
     * Команда, выводящая в консоль количество фильмов, жанр которых, в соответствие с полем genreRating меньше заданного
     */
    COUNT_LES_THAN_GENRE("count_les_than_genre", "tells the ammount of elements whiches genre is lesser than given"){
        @Override
        void runCommand(String genre){
            Command countLessThanGenre = new CountLessThanGenre(genre);
            UserInput.controller.setCommand(countLessThanGenre);
            UserInput.controller.executeCommand();
        }
    },
    /**
     * Команда, выводящая в консоль количество фильмов, жанр которых, в соответствие с полем genreRating больше заданного
     */
    COUNT_GREATER_THAN_GENRE("count_greater_than_genre", "tells the amount of elements with gener greater than given"){
        @Override
        void runCommand(String genre){
            Command countGreaterThanGenre = new CountGreaterThanGenre(genre);
            UserInput.controller.setCommand(countGreaterThanGenre);
            UserInput.controller.executeCommand();
        }
    },
    /**
     * Команда, выводящая в консоль фильмы, жанр которых, в соответствие с полем genreRating больше заданного.
     */
    FILTER_GREATER_THAN_GENRE("filter_greater_than_genre", "outputs the elements with gener greater than given"){
        @Override
        void runCommand(String genre){
            Command filterGreaterThanGenre = new FilterGreaterThanGenre(genre);
            UserInput.controller.setCommand(filterGreaterThanGenre);
            UserInput.controller.executeCommand();
        }
    };

    /**
     * Конструктор енама
     * @param commandName имя команды
     * @param description словесное описание команды
     */
    Commands(String commandName, String description) {
        this.commandName = commandName;
        this.description = description;
    }

    /**
     * Переопределяемый командами, на вход которым не подаются данные, метод, реализующий исполнение команд
     */
    void runCommand(){}

    /**
     * Переопределяемый командами, на вход которым даётся строковое значение, метод, реализующий исполнение команд
     *
     * @param s строка, с которой должна работать команда
     */
    void runCommand(String s){}

    /**
     * Переопределяемый командами, на вход которым даётся целочисленное значение, метод, реализующий исполнение команд
     *
     * @param id целое число, с которым должна работать команда
     */
    void runCommand(int id){}

    /**
     * Поле имя команды, используемая в каждой константе енама при помощи конструктора
     */
    final public String commandName;
    /**
     * Поле описание команды, используемое в каждой константе енами при помощи конструктора
     */
    final public String description;

    /**
     * метод возвращающий поле имя команды
     *
     * @return строковое значение - имя команды
     */
    public String getCommandName(){
        return this.commandName;
    }
}
