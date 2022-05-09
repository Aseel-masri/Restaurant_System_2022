package myproject.software.restaurants_rating_2022;

public class Comment {
   public  String AuthorEmail;
   public  String text;
   public String  Day_Date;
   public int c_id;
 public Comment(){}

    public Comment(String authorEmail, String text, String day_Date) {
       this.AuthorEmail = authorEmail;
        this.text = text;
        this.Day_Date = day_Date;
        c_id = 0;
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
    public int getid() {
        return this.c_id;
    }

    public void setid(int id) {
        this.c_id = id;
    }
}
