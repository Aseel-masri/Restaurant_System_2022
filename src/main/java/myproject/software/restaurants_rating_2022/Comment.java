package myproject.software.restaurants_rating_2022;

public class Comment {
   public  String AuthorEmail;
   public  String text;
   public String  Day_Date;

   public Comment(){

   }
    public Comment(String authorEmail, String text, String day_Date) {
       this.AuthorEmail = authorEmail;
        this.text = text;
        this.Day_Date = day_Date;
    }

    public String getAuthorEmail() {
        return AuthorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        AuthorEmail = authorEmail;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDay_Date() {
        return Day_Date;
    }

    public void setDay_Date(String day_Date) {
        Day_Date = day_Date;
    }
}
