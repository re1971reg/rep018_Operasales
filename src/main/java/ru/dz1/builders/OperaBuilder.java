package ru.dz1.builders;

import ru.dz1.model.Opera;

public class OperaBuilder {

    private int placesCount;
    private String description;
    private String name;
    private String ageCategory;

    public OperaBuilder() {
        super();
    }

    public OperaBuilder placesCount(int count) {
        this.placesCount = count;
        return this;
    }

    public int getPlacesCount() {
        return this.placesCount;
    }

    public OperaBuilder description(String operaDescription) {
        this.description = operaDescription;
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public OperaBuilder name(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public OperaBuilder ageCategory(String ageCategory) {
        this.ageCategory = ageCategory;
        return this;
    }

    public String getAgeCategory() {
        return this.ageCategory;
    }

    public boolean validateOpera() {
        return (name != null && !name.trim().isEmpty() && placesCount > 0);
    }

    public Opera build() {
        Opera opera;
        if (validateOpera()) {
            opera = new Opera(this);
        } else {
            throw new IllegalArgumentException("Объект Опера не может быть создана без обязательных параметров.");
        }
        return opera;
    }
}