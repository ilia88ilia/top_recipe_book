package ua.com.alevel.persistence.entity.user;

import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.persistence.type.RoleType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Getter
@Setter
@Entity
@DiscriminatorValue("PERSONAL")
public class Personal extends User {

    public Personal() {
        super();
        setRoleType(RoleType.ROLE_PERSONAL);
    }
}
