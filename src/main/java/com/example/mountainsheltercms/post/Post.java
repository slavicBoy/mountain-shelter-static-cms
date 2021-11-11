package com.example.mountainsheltercms.post;

import com.example.mountainsheltercms.tag.Tag;
import com.example.mountainsheltercms.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Title can't be empty")
    @Size(min = 2, max = 2500, message = "Name must be between 2 and 32 characters long")
    private String title;
    @NotBlank(message = "Content can't be empty")
    @Size(min = 2, max = 10000, message = "Content must be between 2 and 10000 characters")
    private String content;
    @NotBlank(message = "Img can't be empty")
    @Size(min = 2, max = 100, message = "Img must be between 2 and 100")
    private String img;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Tag> tags;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    {
        tags = new ArrayList<>();
    }

    public Post() {
    }

    public Post(String title, String content, String img) {
        this.title = title;
        this.content = content;
        this.img = img;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", img='" + img + '\'' +
                ", tags=" + tags +
                ", user=" + user +
                '}';
    }
}
