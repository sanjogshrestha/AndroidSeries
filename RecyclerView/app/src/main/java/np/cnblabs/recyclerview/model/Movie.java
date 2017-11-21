package np.cnblabs.recyclerview.model;

/**
 * Created by sanjogstha on 11/20/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

public class Movie {
    private String title, category, year;

    public Movie(){}

    public Movie(String title, String category, String year){
        this.title = title;
        this.category = category;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
