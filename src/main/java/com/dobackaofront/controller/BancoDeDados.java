package com.dobackaofront.controller;

import com.dobackaofront.model.Paciente;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BancoDeDados {
    private Paciente paciente;
    private ArrayList<Paciente> pacientes;

    public BancoDeDados() {
        pacientes = new ArrayList<Paciente>();
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public void ler(){
        try {
            InputStream is = new FileInputStream("pacientes.txt");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String linha = br.readLine();

            while(linha != null){
                System.out.println(linha);
                linha = br.readLine();
            }

        }catch (Exception e){
            System.out.println("Não foi possivel ler o arquivo. " +e.getMessage());
        }

    }
}
