package ua.com.alevel.facade;

import ua.com.alevel.persistence.entity.user.Personal;

import java.util.List;

public interface PersonalFacade {

    List<Personal> findAllPersonal();
}
