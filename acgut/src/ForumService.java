import java.util.ArrayList;
import java.util.List;

class ForumPost {
    private String username;
    private String message;

    public ForumPost(String username, String message) {
        this.username = username;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }
}

class ForumService {
    private List<ForumPost> posts;

    public ForumService() {
        posts = new ArrayList<>();
    }

    public void addPost(ForumPost post) {
        posts.add(post);
    }

    public List<ForumPost> getPosts() {
        return posts;
    }
}
