package automotive.tum.de.routem.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ch0PPeR on 20.01.2015.
 */
public class Comment {
    Coordinate coordinate;
    Picture pic;
    String text;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Picture getPic() {
        return pic;
    }

    public void setPic(Picture pic) {
        this.pic = pic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
