package myproject.software.restaurants_rating_2022;

public class Restaurant {
    String name;

    String imgSrc;


    public Restaurant(String name, String color, String imgSrc) {
        this.name = name;

        this.imgSrc = imgSrc;
    }
    public Restaurant(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}
