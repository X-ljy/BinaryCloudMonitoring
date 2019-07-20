package com.binary.servermonitor.entity;

public class Strategy {
    private String option;
    private String typeName;
    private String typeMethod;
    private String typeValue;

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeMethod() {
        return typeMethod;
    }

    public void setTypeMethod(String typeMethod) {
        this.typeMethod = typeMethod;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    @Override
    public String toString() {
        return "strategy{" +
                "option='" + option + '\'' +
                ", typeName='" + typeName + '\'' +
                ", typeMethod='" + typeMethod + '\'' +
                ", typeValue='" + typeValue + '\'' +
                '}';
    }
}
