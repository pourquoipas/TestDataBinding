package net.gnius.testdatabinding;

import java.util.Date;

public class SimplePojo {

    private String testo;
    private Integer numero;
    private Date data;
    private TestEnum enumField;

    public SimplePojo(String testo, Integer numero, Date data) {
        this.testo = testo;
        this.numero = numero;
        this.data = data;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public TestEnum getEnumField() {
        return enumField;
    }

    public void setEnumField(TestEnum enumField) {
        this.enumField = enumField;
    }

    public Integer getEnumFieldAsInteger() {
        if (getEnumField() != null) {
            return getEnumField().ordinal();
        }
        return null;
    }
    public void setEnumFieldAsInteger(Integer value) {
        if (value != null) {
            TestEnum [] values = TestEnum.values();
            if (value >= 0 && value < values.length) {
                setEnumField(values[value]);
            }
        } else {
            setEnumField(null);
        }
    }

}
