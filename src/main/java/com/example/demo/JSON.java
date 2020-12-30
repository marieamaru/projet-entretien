package com.example.demo;

public class JSON {
    private final int id;
    private final String label;
    private final String type;

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getType() {
        return type;
    }

    public JSON(int id, String label, String type) {
        this.id = id;
        this.label = label;
        this.type = type;
    }

    public Type type(){
        if (this.type.equals("PERSONAL")) {
            return Type.PERSONAL;
        }
        return Type.PROFESSIONAL;
    }
}
