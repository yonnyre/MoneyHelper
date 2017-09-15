package com.example.yonny.moneyhelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yonny on 14/09/2017.
 */

public class DineroRepository {
    private static DineroRepository _INSTANCE = null;

    private DineroRepository() {
    }

    public static DineroRepository getInstance() {
        if (_INSTANCE == null)
            _INSTANCE = new DineroRepository();
        return _INSTANCE;
    }

    private List<Dinero> dineros = new ArrayList<>();

    public List<Dinero> getDineros() {
        return this.dineros;
    }

    public void agregarDinero(Dinero dinero) {
        this.dineros.add(dinero);
    }
}