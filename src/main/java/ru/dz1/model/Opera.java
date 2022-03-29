package ru.dz1.model;

import ru.dz1.builders.OperaBuilder;
import ru.dz1.builders.OperaChanger;

/**
 * класс Опера.
 *  placesCount - максимально колличество мест на представлении
 *  placesFree - колличество свободных мест
 *  operaDescription - описание оперы
 *  name - название оперы
 *  ageСategory - возрастная категория
 *  places - купленные места
 */

public class Opera {

    private int placesCount;
    private int placesFree;
    private String operaDescription;
    private String operaName;
    private String ageСategory;

    public Opera(OperaBuilder operaBuilder) {
        if (operaBuilder == null) {
            throw new IllegalArgumentException("Укажите OperaBuilder для создания объекта Opera.");
        }
        if (operaBuilder.getPlacesCount() <= 0) {
            throw new IllegalArgumentException("Не указано максимальное колличество мест оперы.");
        }
        String operaName = operaBuilder.getName();
        if (operaName == null || operaName.trim().isEmpty()) {
            throw new IllegalArgumentException("Не указано наименование оперы.");
        }

        this.placesCount = operaBuilder.getPlacesCount();
        this.placesFree = this.placesCount;
        this.ageСategory = operaBuilder.getAgeCategory();
        this.operaName = operaBuilder.getName();
        this.operaDescription = operaBuilder.getDescription();
    }

    public void change(OperaChanger operaChanger) {
        this.operaDescription = operaChanger.getDescription();
        this.ageСategory = operaChanger.getAgeCategory();
    }

    public int getPlacesCount() {
        return placesCount;
    }

    public String getOperaDescription() {
        return operaDescription;
    }

    public String getOperaName() {
        return operaName;
    }

    public String getAgeСategory() {
        return ageСategory;
    }

    public int getPlacesFree() {
        return placesFree;
    }

    public void buyTikets(int ticketCount) {
        if (this.placesFree - ticketCount < 0) {
            throw new IllegalArgumentException(String.format("В опере {%s} недостаточно свободных мест.", this.operaName));
        }
        this.placesFree = this.placesFree - ticketCount;
    }

    public void refundTickets(int ticketCount) {
        if (this.placesFree + ticketCount > this.placesCount) {
            throw new IllegalArgumentException(String.format("Для оперы {%s} нельзя вернуть %d шт. мест."
                    ,this.operaName, ticketCount));
        }
        this.placesFree = this.placesFree + ticketCount;
    }

    @Override
    public String toString() {
        return String.format("Опера {наименование оперы=%s, описание=%s, возрастная категория=%s, свободное кол-во мест=%d из %d}",
                this.operaName, this.operaDescription, this.ageСategory, this.placesFree, this.placesCount

        );
    }
}