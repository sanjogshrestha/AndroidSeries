package np.cnblabs.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sanjogstha on 11/21/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

public class TreeHouseModel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("count")
    @Expose
    private Long count;
    @SerializedName("count_total")
    @Expose
    private Long countTotal;
    @SerializedName("pages")
    @Expose
    private Long pages;
    @SerializedName("posts")
    @Expose
    private List<Post> posts = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getCountTotal() {
        return countTotal;
    }

    public void setCountTotal(Long countTotal) {
        this.countTotal = countTotal;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
