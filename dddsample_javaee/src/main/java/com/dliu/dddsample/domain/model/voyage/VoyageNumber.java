package com.dliu.dddsample.domain.model.voyage;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by IntelliJ IDEA.
 */
@Embeddable
public class VoyageNumber {
    @Column(name = "VOYAGE_NUMBER")
    private String number;

    public VoyageNumber(String number) {
        Validate.notNull(number);
        this.number = number;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(number).toHashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return sameValueAs((VoyageNumber)o);
    }

    public boolean sameValueAs(VoyageNumber other) {
        return other != null && this.number.equals(other.number);
    }
}
