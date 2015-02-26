package automotive.tum.de.routem.models;

import com.google.gson.annotations.Expose;

/**
 * Created by H1GHWAvE on 2/25/15.
 */
public class Picture {
    String path;
    @Expose
    String pic;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
