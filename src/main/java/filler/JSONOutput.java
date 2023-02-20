package filler;

import model.Movie;

import main.Main;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;

public class JSONOutput {
    public String filleName;
    public JSONOutput(String filleName){
        this.filleName = filleName;
    }
    public void writeJSON(){
        JSONObject jsonObject = new JSONObject();
        JSONArray movies = new JSONArray();
        for(Movie movie : Main.arrayList){
            JSONObject currentMovie = new JSONObject();
            currentMovie.put("id", Integer.toString(movie.getId()));
            currentMovie.put("name", movie.getName());
            JSONObject coordinates = new JSONObject();
            coordinates.put("x", movie.getCoordinates().getX().toString());
            coordinates.put("y", movie.getCoordinates().getY().toString());
            currentMovie.put("coordinates", coordinates);
            currentMovie.put("creationDate", movie.getCreationDate().toString());
            currentMovie.put("oscarsCount", Integer.toString(movie.getOscarsCount()));
            currentMovie.put("genre", movie.getGenre().toString());
            if(movie.getMpaaRating() != null) currentMovie.put("mpaaRating", movie.getMpaaRating().toString());
            JSONObject director = new JSONObject();
            director.put("name", movie.getDirector().getName());
            if(movie.getDirector().getWeight() != null) director.put("weight", movie.getDirector().getWeight().toString());
            if(movie.getDirector().getEyeColor() != null) director.put("eyeColor", movie.getDirector().getEyeColor().toString());
            director.put("hairColor", movie.getDirector().getHairColor().toString());
            director.put("nationality", movie.getDirector().getNationality().toString());
            JSONObject location = new JSONObject();
            location.put("x", movie.getDirector().getLocation().getX().toString());
            location.put("y", movie.getDirector().getLocation().getY().toString());
            location.put("z", Float.toString(movie.getDirector().getLocation().getZ()));
            director.put("location", location);
            currentMovie.put("director", director);
            movies.add(currentMovie);

        }
        jsonObject.put("Movies", movies);
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filleName));
            writer.write(jsonObject.toJSONString());
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("This fille does not exist");
        } catch (IOException e) {
            System.out.println("some shit happened");
        }
    }
}
