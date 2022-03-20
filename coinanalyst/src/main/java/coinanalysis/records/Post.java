package coinanalysis.records;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Date;
import java.util.Objects;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Post {
    private int number;
    private String postType;
    private String title;
    private String writer;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date datetime;
    private String gallery;
    private String url;

    public Post() {

    }
    public Post(int number, String postType, String title, String writer, Date datetime, String gallery, String url) {
        this.number = number;
        this.postType = postType;
        this.title = title;
        this.writer = writer;
        this.datetime = datetime;
        this.gallery = gallery;
        this.url = url;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getGallery() {
        return gallery;
    }

    public void setGallery(String gallery) {
        this.gallery = gallery;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return getNumber() == post.getNumber() && Objects.equals(getPostType(), post.getPostType()) && Objects.equals(getTitle(), post.getTitle()) && Objects.equals(getWriter(), post.getWriter()) && Objects.equals(getDatetime(), post.getDatetime()) && Objects.equals(getGallery(), post.getGallery()) && Objects.equals(getUrl(), post.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getPostType(), getTitle(), getWriter(), getDatetime(), getGallery(), getUrl());
    }

    @Override
    public String toString() {
        return "Post{" +
                "number=" + number +
                ", postType='" + postType + '\'' +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", datetime=" + datetime +
                ", gallery='" + gallery + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
