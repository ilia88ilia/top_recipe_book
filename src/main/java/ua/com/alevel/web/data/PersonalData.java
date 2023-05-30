package ua.com.alevel.web.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.alevel.persistence.entity.user.Personal;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PersonalData {
    private Long id;
    private String email;
    private Date created;

    public PersonalData(Personal personal) {
        this.id = personal.getId();
        this.email = personal.getEmail();
        this.created = personal.getCreated();
    }
}


