package myproject.software.restaurants_rating_2022;

public class Restaurant {
    String name;
    String color;
    String imgSrc;


    public Restaurant(String name, String color, String imgSrc) {
        this.name = name;
        this.color = color;
        this.imgSrc = imgSrc;
    }
    public Restaurant(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}