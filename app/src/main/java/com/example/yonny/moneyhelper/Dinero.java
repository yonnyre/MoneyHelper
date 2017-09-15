package com.example.yonny.moneyhelper;

/**
 * Created by Yonny on 11/09/2017.
 */

public class Dinero {

    private double monto;
    private String registro;
    private String cuenta;

    public Dinero() {
        super();
    }

    public Dinero(double monto, String registro, String cuenta) {
        this.monto = monto;
        this.registro = registro;
        this.cuenta = cuenta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

}
