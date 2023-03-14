package comandHandler;

import filler.JSONOutput;
import main.Main;
import model.*;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Элемент Pattern Command, хранящий методы-реализации всех команд приложения
 */
public class CommandSystem {
    public static String filleName;
    public static int execute_cnt = 0;

    /**
     * Коллекция, в которой хранятся фильмы.
     */
    public static ArrayList<Movie> arrayList = new ArrayList<Movie>();

    /**
     * Реализация команды, добавляющей новый фильм в конец коллекции
     */


    /**
     * Реализация команды, добавляющей новый фильм в конец коллекции, если этот элемент, в соотвествие с переопределённым для класса Movie методом compareTo, окажется строго меньше минимального элемента коллекции
     */


    /**
     * Реализация команды, очищающей коллекцию (в результате коллекция, с которой мы работаем, становится пустой)
     */

    /**
     * Реализация команды, выводящей на консоль количество фильмов коллекции, жанр которых, в соответствие с полем genreRating, строго больше заданного жанра
     *
     * @param genre Заданный жанр, с которым производится сравнение
     */


    /**
     * Реализация команды, выводящей на консоль количество фильмов коллекции, жанр которых, в соответствие с полем genreRating, строго меньше заданного жанра
     *
     * @param genre заданный жанр, с которым производится сравнение
     */


    /**
     * Реализация команды, выполняющей команды из файла, заданного пользователем
     *
     * @param filleName имя файла заданного пользователем
     */


    /**
     * Реализация команды, завершающей работу приложения без сохранения изменений в файл, за исключением тех, что уже были отдельно сохранены командой save
     */


    /**
     * Реализация команды, выводящей на консоль фильмы коллекции, жанр которых, в соответствие с полем genreRating, строго больше заданного жанра
     *
     * @param genre заданный жанр, с которым производится сравнение
     */


    /**
     * Реализация команды, выводящей на консоль информацию о каждой команде приложения
     */


    /**
     * Реализация команды, выводящей на консоль информацию о коллекции(её размер и класс)
     */


    /**
     * Реализация команды, удаляющей из коллекции фильм с заданным id
     *
     * @param id - значение поля id удаляемого фильма
     */

    /**
     * Реализация команды, удаляющей фильм из конца коллекции, если она не пуста
     */

    /**
     * Реализация команды, переставляющей элементы коллекции в обратном порядке
     */


    /**
     * Реализация команды, сохраняющей коллекцию в нынешнем состоянии в стартовый файл
     */

    /**
     * Реализация команды, выводящей на консоль все фильмы коллекции
     */


    /**
     * Реализация команды, позволяющая пользователю поочередно изменить каждое поле фильма коллекции с заданным id
     *
     * @param id - значения поля id фильма, поля которого пользователь будет менять
     */

    /**
     * Метод пыподящий конкретный переданный ему фильм на консоль (поочередно выводит каждое поле заданного фильма)
     *
     * @param movie - заданный фильм, поля которого нужно вывести в консоль
     */
    public static void printMovie(Movie movie){
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
