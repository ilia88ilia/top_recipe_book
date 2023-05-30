package ua.com.alevel.service;

import ua.com.alevel.persistence.entity.post.Post;

public interface PostService extends CrudService<Post> {

    void like(Long id);
    void dislike(Long id);
}
