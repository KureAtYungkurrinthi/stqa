import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForumTest {

    @DisplayName("Test Forum Service")
    @Test
    void forumService() {
        ForumService forumService = new ForumService();
        forumService.addPost(new ForumPost("user1", "message1"));
        forumService.addPost(new ForumPost("user2", "message2"));

        assertAll("Forum Posts",
            () -> assertEquals(2, forumService.getPosts().size()),
            () -> assertEquals("user1", forumService.getPosts().getFirst().getUsername()),
            () -> assertEquals("message1", forumService.getPosts().getFirst().getMessage()),
            () -> assertEquals("user2", forumService.getPosts().getLast().getUsername()),
            () -> assertEquals("message2", forumService.getPosts().getLast().getMessage())
        );
    }
}