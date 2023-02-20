package model;

public class Coordinates{
    private Integer x; //Поле не может быть null
    private Float y; //Максимальное значение поля: 208, Поле не может быть null

    public Coordinates(Integer x, Float y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates(){}

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }
}
