package com.dliu.dddsample.domain.model.voyage;

import org.apache.commons.lang.Validate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 */
@Entity
@Table(name = "VOYAGE")
public class Voyage {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Embedded
    private VoyageNumber voyageNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="VOYAGE_ID")
    private List<CarrierMovement> carrierMovements;

    public Voyage() {
    }

    public Voyage(VoyageNumber voyageNumber, List<CarrierMovement> carrierMovements) {
        Validate.notNull(voyageNumber, "Voyage number is required");
        Validate.notNull(carrierMovements, "Schedule is required");
        Validate.noNullElements(carrierMovements);
        this.voyageNumber = voyageNumber;
        this.carrierMovements = carrierMovements;
    }

    public boolean sameIdentityAs(Voyage o) {
        return o != null && voyageNumber.sameValueAs(o.voyageNumber);
    }

    public VoyageNumber voyageNumber() {
        return voyageNumber;
    }

    public List<CarrierMovement> carrierMovements() {
        return Collections.unmodifiableList(carrierMovements);
    }

    @Override
    public int hashCode() {
        return voyageNumber.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return sameIdentityAs((Voyage) o);
    }
}
