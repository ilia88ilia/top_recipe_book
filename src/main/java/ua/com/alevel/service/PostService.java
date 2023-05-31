package ua.com.alevel.service;

import ua.com.alevel.persistence.entity.post.Post;

import java.util.List;

public interface PostService extends CrudService<Post> {

    void like(Long id);
    void dislike(Long id);
    List<Post> findAllPosts();
}
