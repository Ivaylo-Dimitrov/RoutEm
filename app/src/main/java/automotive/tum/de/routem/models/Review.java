package automotive.tum.de.routem.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by H1GHWAvE on 2/8/15.
 */
public class Review {
    float rating;
    String text;
    String title;

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
