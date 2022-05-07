package myproject.software.restaurants_rating_2022;

public class comments {
  public static Restaurant selectedres;

  public void setC_id(int c_id) {
    this.c_id = c_id;
  }

  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }

  public void setComment_info(String comment_info) {
    this.comment_info = comment_info;
  }

  public void setComment_date(String comment_date) {
    this.comment_date = comment_date;
  }

  public comments(int c_id, String user_name, String comment_info, String comment_date) {
    this.c_id = c_id;
    this.user_name = user_name;
    this.comment_info = comment_info;
    this.comment_date = comment_date;
  }
  public comments(){
   // flagd=false;
  }

  private int  c_id;
  private String user_name ;
  private  String comment_info;
  private String comment_date;

  public int getC_id() {
    return c_id;
  }

  public String getUser_name() {
    return user_name;
  }

  public String getComment_info() {
    return comment_info;
  }

  public String getComment_date() {
    return comment_date;
  }

}
