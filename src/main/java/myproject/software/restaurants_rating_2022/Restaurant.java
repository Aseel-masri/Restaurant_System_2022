package myproject.software.restaurants_rating_2022;

public class Restaurant {
    String name;

    String imgSrc;
    int id;


    public Restaurant(String name, String color, String imgSrc,int id) {
        this.name = name;
        this.id=id;

        this.imgSrc = imgSrc;
    }
    public Restaurant(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}
