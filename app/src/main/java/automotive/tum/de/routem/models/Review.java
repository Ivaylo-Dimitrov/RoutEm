package automotive.tum.de.routem.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by H1GHWAvE on 2/8/15.
 */
public class Review {
    @SerializedName("class")
    String clazz;
    int id;
    float rating;
    String text;
    String title;

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
