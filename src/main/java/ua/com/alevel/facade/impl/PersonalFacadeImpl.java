package ua.com.alevel.facade.impl;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.PersonalFacade;
import ua.com.alevel.persistence.entity.user.Personal;
import ua.com.alevel.service.PersonalService;
import ua.com.alevel.web.data.PageData;
import ua.com.alevel.web.data.PersistenceRequestData;
import ua.com.alevel.web.data.PersonalData;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonalFacadeImpl implements PersonalFacade {

    private final PersonalService personalService;

    public PersonalFacadeImpl(PersonalService personalService) {
        this.personalService = personalService;
    }

    @Override
    public PageData<PersonalData> findAllPersonal(WebRequest request) {
        PersistenceRequestData persistenceRequestData = new PersistenceRequestData(request);
        Page<Personal> page = personalService.findAll(persistenceRequestData);
        PageData<PersonalData> data = new PageData<>();
        data.setCurrentPage(page.getNumber());
        data.setPageSize(page.getNumber());
        data.setTotalElements(page.getTotalPages());
        data.setTotalPages(page.getTotalPages());
        if (CollectionUtils.isNotEmpty(page.getContent())) {
            List<PersonalData> list = page.getContent().stream().map(PersonalData::new).collect(Collectors.toList());
            data.setItems(list);
        }
        return data;
    }
}
