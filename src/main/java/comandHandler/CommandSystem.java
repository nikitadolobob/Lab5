package comandHandler;

import filler.JSONOutput;
import main.Main;
import model.*;

import java.util.Collections;

/**
 * Элемент Pattern Command, хранящий методы-реализации всех команд приложения
 */
public class CommandSystem {
    /**
     * Реализация команды, добавляющей новый фильм в конец коллекции
     */
    public void add(){
        Movie movie = UserInput.readMovie();
        if(movie == null){
            return;
        }
        Main.arrayList.add(movie);
        System.out.println("The movie is successfully added");
        System.out.println("Enter your next command: ");
    }

    /**
     * Реализация команды, добавляющей новый фильм в конец коллекции, если этот элемент, в соотвествие с переопределённым для класса Movie методом compareTo, окажется строго меньше минимального элемента коллекции
     */
    public void addIfMin(){
        Movie movie = UserInput.readMovie();
        if(movie == null){
            return;
        }
        Movie minMovie = Collections.min(Main.arrayList);
        if(movie.compareTo(minMovie) < 0){
            Main.arrayList.add(movie);
            System.out.println("The movie is in the collection now");
        }
        else {
            System.out.println("The movie was not a minimum, so it is not in the collection");
        }
        System.out.println("Enter your next command: ");
    }

    /**
     * Реализация команды, очищающей коллекцию (в результате коллекция, с которой мы работаем, становится пустой)
     */
    public void clear(){
            Main.arrayList.clear();
            System.out.println("The collection is empty now");
            System.out.println("Enter your next command: ");
    }

    /**
     * Реализация команды, выводящей на консоль количество фильмов коллекции, жанр которых, в соответствие с полем genreRating, строго больше заданного жанра
     *
     * @param genre Заданный жанр, с которым производится сравнение
     */
    public void countGreaterThanGenre(String genre){
        MovieGenre eGenre = null;
        int maxGenreCount = 0;
        for(MovieGenre iGenre : MovieGenre.values()){
            if(genre.equals(iGenre.name())){
                eGenre = iGenre;
            }
        }
        if(eGenre == null){
            System.out.println("Listen here you dumbass asshole. Am i a fucking joke to you? What did i tell you to enter? Is it so hard? Is it so fucking hard, huh, motherfucker? Read the shit i asked you to do and do this one right this time dickhead");
            return;
        }
        for(Movie movie : Main.arrayList){
            if(movie.getGenre().genreRating > eGenre.genreRating){
                maxGenreCount++;
            }
        }
        System.out.println("Here you go, bro. There are: " + maxGenreCount + " of the more genred movies in the collection!");
        System.out.println("Enter your next command: ");
    }

    /**
     * Реализация команды, выводящей на консоль количество фильмов коллекции, жанр которых, в соответствие с полем genreRating, строго меньше заданного жанра
     *
     * @param genre заданный жанр, с которым производится сравнение
     */
    public void countLessThanGenre(String genre){
        MovieGenre eGenre = null;
        int minGenreCount = 0;
        for(MovieGenre iGenre : MovieGenre.values()){
            if(genre.equals(iGenre.name())){
                eGenre = iGenre;
            }
        }
        if(eGenre == null){
            System.out.println("Listen here you dumbass asshole. Am i a fucking joke to you? What did i tell you to enter? Is it so hard? Is it so fucking hard, huh, motherfucker? Read the shit i asked you to do and do this one right this time dickhead");
            return;
        }
        for(Movie movie : Main.arrayList){
            if(movie.getGenre().genreRating < eGenre.genreRating){
                minGenreCount++;
            }
        }
        System.out.println("Here you go, bro. There are: " + minGenreCount + " of the less genred movies in the collection!");
        System.out.println("Enter your next command: ");
    }

    /**
     * Реализация команды, выполняющей команды из файла, заданного пользователем
     *
     * @param filleName имя файла заданного пользователем
     */
    public void executeScript(String filleName){
        System.out.println("Start reading script" + filleName);
        UserInput userInput = new UserInput(filleName);
        userInput.readCommands();
        System.out.println("Script successfully executed. You may get to entering data by console");
    }

    /**
     * Реализация команды, завершающей работу приложения без сохранения изменений в файл, за исключением тех, что уже были отдельно сохранены командой save
     */
    public void exit(){
        System.exit(0);
    }

    /**
     * Реализация команды, выводящей на консоль фильмы коллекции, жанр которых, в соответствие с полем genreRating, строго больше заданного жанра
     *
     * @param genre заданный жанр, с которым производится сравнение
     */
    public void filterGreaterThanGenre(String genre){
        MovieGenre eGenre = null;
        for(MovieGenre iGenre : MovieGenre.values()){
            if(genre.equals(iGenre.name())){
                eGenre = iGenre;
            }
        }
        if(eGenre == null){
            System.out.println("Listen here you dumbass asshole. Am i a fucking joke to you? What did i tell you to enter? Is it so hard? Is it so fucking hard, huh, motherfucker? Read the shit i asked you to do and do this one right this time dickhead");
            return;
        }
        System.out.println("Here is the list of better genered movies in the collection: ");
        for(Movie movie : Main.arrayList){
            if(movie.getGenre().genreRating > eGenre.genreRating){
                printMovie(movie);
                System.out.println("----------------------------------");
            }
        }
        System.out.println("That's all of them!");
        System.out.println("Enter your next command: ");
    }

    /**
     * Реализация команды, выводящей на консоль информацию о каждой команде приложения
     */
    public void help(){
        for(Commands command : Commands.values()){
            System.out.println(command.commandName + ": " + command.description);
        }
        System.out.println("Enter your next command: ");
    }

    /**
     * Реализация команды, выводящей на консоль информацию о коллекции(её размер и класс)
     */
    public void info(){
        System.out.println("Information about collection:");
        System.out.println("Collection size: " + Main.arrayList.size());
        System.out.println("Collection type: " + Main.arrayList.getClass());
        System.out.println("Enter your next command: ");
    }

    /**
     * Реализация команды, удаляющей из коллекции фильм с заданным id
     *
     * @param id - значение поля id удаляемого фильма
     */
    public void removeById(int id){
        if(id <= 0 || id >= Main.arrayList.size()) {
            System.out.println("Id is incorrect. Can not remove element. Try again or enter another command.");
            return;
        }
        Main.arrayList.remove(id - 1);

        for (Movie movie : Main.arrayList) {
            movie.setId(Main.arrayList.indexOf(movie) + 1);
        }
        System.out.println("Element is deleted");
        System.out.println("Enter your next command: ");
    }

    /**
     * Реализация команды, удаляющей фильм из конца коллекции, если она не пуста
     */
    public void removeLast(){
        if(Main.arrayList.isEmpty()){
            System.out.println("Can not remove last because collection is empty. Enter your next command");
            return;
        }
        Main.arrayList.remove(Main.arrayList.size() - 1);
        System.out.println("The last movie of the collection is successfully removed from it");
        System.out.println("Enter your next command: ");
    }

    /**
     * Реализация команды, переставляющей элементы коллекции в обратном порядке
     */
    public void reorder(){
        Collections.reverse(Main.arrayList);
        for(Movie movie : Main.arrayList){
            movie.setId(Main.arrayList.indexOf(movie) + 1);
        }
        System.out.println("The movies in the collection reversed their order");
        System.out.println("Enter your next command: ");
    }

    /**
     * Реализация команды, сохраняющей коллекцию в нынешнем состоянии в стартовый файл
     */
    public void save(){
        JSONOutput jsonOutput = new JSONOutput(Main.filleName);
        jsonOutput.writeJSON();
        System.out.println("The collection is saved to the file");
        System.out.println("Enter your next command: ");
    }

    /**
     * Реализация команды, выводящей на консоль все фильмы коллекции
     */
    public void show(){
        for(Movie movie : Main.arrayList){
            printMovie(movie);
            System.out.println("---------------------------------");
        }
        System.out.println("Command SHOW successfully finished");
        System.out.println("Enter your next command: ");
    }

    /**
     * Реализация команды, позволяющая пользователю поочередно изменить каждое поле фильма коллекции с заданным id
     *
     * @param id - значения поля id фильма, поля которого пользователь будет менять
     */
    public void update(int id){
        if(id <= 0 || id >= Main.arrayList.size()) {
            System.out.println("Id is incorrect. Can not update element. Try again or enter another command.");
            return;
        }
        Movie movie = UserInput.readMovie();
        if(movie == null){
            return;
        }
        movie.setId(id);
        movie.setCreationDate(Main.arrayList.get(id - 1).getCreationDate());
        Main.arrayList.remove(id - 1);
        Main.arrayList.add(id - 1, movie);
        System.out.println("The movie is successfully updgared");
        System.out.println("Enter your next command: ");
    }

    /**
     * Метод пыподящий конкретный переданный ему фильм на консоль (поочередно выводит каждое поле заданного фильма)
     *
     * @param movie - заданный фильм, поля которого нужно вывести в консоль
     */
    private void printMovie(Movie movie){
        Coordinates coordinates = movie.getCoordinates();
        Person director = movie.getDirector();
        Location location = director.getLocation();

        System.out.println("The id: " + movie.getId());
        System.out.println("The name: " + movie.getName());
        System.out.println("Coordinates:");
        System.out.println("    " + coordinates.getX());
        System.out.println("    " + coordinates.getY());
        System.out.println("Created at: " + movie.getCreationDate());
        System.out.println("Got " + movie.getOscarsCount() + " oscar nominations");
        System.out.println("Movie genre is: " + movie.getGenre());
        System.out.println("MpaaRated: " + movie.getMpaaRating());
        System.out.println("Director:");
        System.out.println("    Name: " + director.getName());
        System.out.println("    Weight: " + director.getWeight());
        System.out.println("    eyeColor: " + director.getEyeColor());
        System.out.println("    Hair color: " + director.getHairColor());
        System.out.println("    Nationality: " + director.getNationality());
        System.out.println("    Location:");
        System.out.println("        X: " + location.getX());
        System.out.println("        Y: " + location.getY());
        System.out.println("        Z: " + location.getZ());
    }
}
