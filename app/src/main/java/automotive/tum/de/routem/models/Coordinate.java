package automotive.tum.de.routem.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by H1GHWAvE on 2/8/15.
 */
public class Coordinate {
    @SerializedName("class")
    String clazz;
    int id;
    float altitude;
    float latitude;
    float longitude;

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

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
