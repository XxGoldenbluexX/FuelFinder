package fr.antony_garcia.fuelfinder.model;

public enum Carburant {

    GAZOIL("price_gazole");

    private final String field;

    private Carburant(String field){
        this.field = field;
    }

    public String getField(){
        return field;
    }

}
