package filler;

import comandHandler.CommandSystem;
import model.*;
import main.Main;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

/**
 * Класс для считывания данных из JSON файла и их помещения в коллекцию, с которой работает приложение.
 */
public class JSONInput {

    /**
     * Имя считываемого файла
     */
    public String filleName;

    /**
     * Конструктор для экземляра класса, чтобы считывать с конкретного файла
     *
     * @param filleName - имя файла, с которым будет работать экземпляр класса
     */
    public JSONInput(String filleName){
        this.filleName = filleName;
    }


    /**
     * Метод для обработки конкретного фильма и перевода его из JSON файла в коллекцию в качестве эллемента типа Class Movie
     *
     * @param jsonObject - поступающий методу на вход фильм в формате JSON
     */
    public void readMovie(JSONObject jsonObject){
        try{
            Movie movie = new Movie();
            Coordinates coordinates = new Coordinates();
            Person person = new Person();
            Location location = new Location();

            JSONObject cord = (JSONObject) jsonObject.get("coordinates");
            coordinates.setX(Integer.parseInt((String) cord.get("x")));
            coordinates.setY(Float.parseFloat((String) cord.get("y")));

            JSONObject direct = (JSONObject) jsonObject.get("director");
            person.setName((String) direct.get("name"));

            JSONObject loc = (JSONObject) direct.get("location");
            location.setX(Double.parseDouble((String) loc.get("x")));
            location.setY(Integer.parseInt((String) loc.get("y")));
            location.setZ(Float.parseFloat((String) loc.get("z")));

            if(direct.containsKey("weight")) {
                person.setWeight(Float.parseFloat((String) direct.get("weight")));
            }
            if(direct.containsKey("eyeColor")) {
                String eyeColor = (String) direct.get("eyeColor");
                for (model.colorEyes.Color color : model.colorEyes.Color.values()) {
                    if (color.name().equals(eyeColor)) {
                        person.setEyeColor(color);
                    }
                }
            }
            String hairColor = (String) direct.get("hairColor");
            for(model.colorHair.Color color : model.colorHair.Color.values()){
                if(color.name().equals(hairColor)){
                    person.setHairColor(color);
                }
            }
            String country = (String) direct.get("nationality");
            for(Country eCountry : Country.values()){
                if(eCountry.name().equals(country)){
                    person.setNationality(eCountry);
                }
            }
            person.setLocation(location);

            movie.setId(Integer.parseInt((String) jsonObject.get("id")));
            movie.setName((String)jsonObject.get("name"));
            movie.setCoordinates(coordinates);
            DateTimeFormatter formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
            movie.setCreationDate(ZonedDateTime.parse((String) jsonObject.get("creationDate"), formatter));
            movie.setOscarsCount(Integer.parseInt((String) jsonObject.get("oscarsCount")));
            String genre = (String) jsonObject.get("genre");
            for(MovieGenre eGenre : MovieGenre.values()){
                if(eGenre.name().equals(genre)){
                    movie.setGenre(eGenre);
                }
            }

            if(jsonObject.containsKey("mpaRating")){
                String mpaaRating = (String) jsonObject.get("mpaaRating");
                for(MpaaRating rating : MpaaRating.values()){
                    if(rating.name().equals(mpaaRating)){
                        movie.setMpaaRating(rating);
                    }
                }
            }

            movie.setDirector(person);
            CommandSystem.arrayList.add(movie);


        }catch (NullPointerException e){
            System.out.println("Can not read movies from JSON. Some of required fields are missing");
            System.exit(-1);
        }
    }


    /**
     * Метод, переводящий содержимое JSON файла в эллементы коллекции
     */
    public void readJSON()  {
        Object obj = null;
        try {
            obj = new JSONParser().parse(new FileReader(filleName));
        } catch (IOException e) {
            System.out.println("Error during file reading. For correct work file must contain root element containing Movies array");
            System.exit(-1);
        } catch (ParseException e) {
            System.out.println("Unable to parse file. For correct work file must contain root element containing Movies array");
            System.exit(-1);
        }
        JSONObject jo = (JSONObject) obj;
        JSONArray moviesArr = (JSONArray) jo.get("Movies");
        if(moviesArr == null){
            System.out.println("No Movies array in file. For correct work file must contain root element containing Movies array");
            System.exit(-1);
        }
        Iterator moviesItr = moviesArr.iterator();

        while (moviesItr.hasNext()) {
            JSONObject test = (JSONObject) moviesItr.next();
            readMovie(test);
        }
    }
}
