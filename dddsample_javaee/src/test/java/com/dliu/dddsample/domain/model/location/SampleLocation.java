package com.dliu.dddsample.domain.model.location;

/**
 * Created by IntelliJ IDEA.
 */
public class SampleLocation {
    public static Location BEIJING = new Location.Builder().withUnLocode(new UNLocode("CHBEJ")).withName("Beijing").build();
    public static Location SHANGHAI = new Location.Builder().withUnLocode(new UNLocode("CHSHA")).withName("Shanghai").build();

}
