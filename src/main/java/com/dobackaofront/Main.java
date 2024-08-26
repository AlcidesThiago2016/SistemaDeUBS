package com.dobackaofront;

import com.dobackaofront.controller.BancoDeDados;
import com.dobackaofront.model.Paciente;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BancoDeDados bd = new BancoDeDados();
        ArrayList<Paciente> pacientes = bd.getPacientes();
    }
}