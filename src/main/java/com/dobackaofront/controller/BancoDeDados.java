package com.dobackaofront.controller;

import com.dobackaofront.model.Paciente;

import java.util.ArrayList;

public class BancoDeDados {
    private Paciente paciente;
    private ArrayList<Paciente> pacientes;

    public BancoDeDados() {
        pacientes = new ArrayList<Paciente>();
    }
}
