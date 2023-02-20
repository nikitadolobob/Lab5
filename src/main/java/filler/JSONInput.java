package filler;

import model.*;
import main.Main;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

/**
 * The type Json input.
 */
public class JSONInput {
    /**
     * The Fille name.
     */
    public String filleName;

    /**
     * Instantiates a new Json input.
     *
     * @param filleName the fille name
     */
    public JSONInput(String filleName){
        this.filleName = filleName;
    }

    /**
     * Read movie.
     *
     * @param jsonObject the json object
     */
    public void readMovie(JSONObject jsonObject){
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

        Main.arrayList.add(movie);
    }

    /**
     * Read json.
     *
     * @throws IOException    the io exception
     * @throws ParseException the parse exception
     */
    public void readJSON() throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader(filleName));
        JSONObject jo = (JSONObject) obj;
        JSONArray moviesArr = (JSONArray) jo.get("Movies");
        Iterator moviesItr = moviesArr.iterator();

        while (moviesItr.hasNext()) {
            JSONObject test = (JSONObject) moviesItr.next();
            readMovie(test);
        }
    }
}
