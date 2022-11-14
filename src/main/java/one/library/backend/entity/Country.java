package one.library.backend.entity;

import one.library.backend.entity.auxiliaryEntity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Country extends AbstractEntity {

    public enum Name {
        Russia, UnitedStates, UnitedKingdom, Kyrgyztan, Germany
    }

    private Country.Name name;

    laisk

}
