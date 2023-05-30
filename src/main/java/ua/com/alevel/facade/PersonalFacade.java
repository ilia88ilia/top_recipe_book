package ua.com.alevel.facade;

import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.web.data.PageData;
import ua.com.alevel.web.data.PersonalData;

public interface PersonalFacade {

    PageData<PersonalData> findAllPersonal(WebRequest request);
}
