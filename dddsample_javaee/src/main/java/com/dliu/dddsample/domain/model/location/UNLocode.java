package com.dliu.dddsample.domain.model.location;

import org.apache.commons.lang.Validate;

import javax.persistence.Embeddable;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 */
@Embeddable
public class UNLocode {
    private static final Pattern VALID_PATTERN = Pattern.compile("[a-zA-Z]{2}[a-zA-Z2-9]{3}");
    private String unlocode;

    public UNLocode() {
    }

    public UNLocode(String unlocode) {
        Validate.isTrue(VALID_PATTERN.matcher(unlocode).matches());
        this.unlocode = unlocode.toUpperCase();
    }

    @Override
    public int hashCode() {
        return unlocode.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        return unlocode.equals(((UNLocode)other).unlocode);
    }

    public String getUnlocode() {
        return unlocode;
    }

    public static class Builder {
        private String unloccode;

        public Builder withUnloccode(String unloccode) {
            this.unloccode = unloccode;
            return this;
        }

        public UNLocode build() {
            return new UNLocode(unloccode);
        }
    }
}
