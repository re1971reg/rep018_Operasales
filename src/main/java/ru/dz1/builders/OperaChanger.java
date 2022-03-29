package ru.dz1.builders;

import ru.dz1.model.Opera;

public class OperaChanger {

//    private int placesCount;
    private String description;
    private String name;
    private String ageCategory;

    public OperaChanger() {
        super();
    }

//    public OperaChanger placeCount(int placesCount) {
//        this.placesCount = placesCount;
//        return this;
//    }

//    public int getPlacesCount() {
//        return this.placesCount;
//    }

    public String getDescription() {
        return description;
    }

    public OperaChanger description(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public OperaChanger name(String name) {
        this.name = name;
        return this;
    }

    public String getAgeCategory() {
        return ageCategory;
    }

    public OperaChanger ageCategory(String ageCategory) {
        this.ageCategory = ageCategory;
        return this;
    }
}