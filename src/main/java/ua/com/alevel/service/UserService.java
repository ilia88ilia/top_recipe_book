package ua.com.alevel.service;

import ua.com.alevel.persistence.entity.user.User;

import java.util.List;

public interface UserService<U extends User> extends CrudService<U> {

}
