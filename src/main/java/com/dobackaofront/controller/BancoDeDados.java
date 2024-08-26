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
    private ArrayList<String> linhas;

    public BancoDeDados() {
        pacientes = new ArrayList<Paciente>();
        linhas = ler();
        pacientes = transformar(linhas);
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

    public ArrayList<String> ler(){
        try {
            InputStream is = new FileInputStream("pacientes.txt");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String linha = br.readLine();
            ArrayList<String> linhas = new ArrayList<>();

            while(linha != null){
                linhas.add(linha);
                linha = br.readLine();
            }

            br.close();
            isr.close();
            is.close();

            //System.out.println("Arquivo lido com sucesso!");
            return linhas;
        }catch (Exception e){
            System.out.println("Não foi possivel ler o arquivo. " +e.getMessage());
            return null;
        }
    }

    public ArrayList<Paciente> transformar(ArrayList<String> linhas){
        String[] linha_obj = new String[5];
        String nome;
        int idade;
        double peso;
        double altura;
        String cpf;

        for(int i = 0; i < linhas.size(); i++){
            linha_obj = linhas.get(i).split(",");

            nome = linha_obj[0];
            idade = Integer.parseInt(linha_obj[1]);
            peso = Double.parseDouble(linha_obj[2]);
            altura = Double.parseDouble(linha_obj[3]);
            cpf = linha_obj[4];

            paciente = new Paciente(nome,idade,peso,altura,cpf);
            pacientes.add(paciente);
        }
        return pacientes;
    }
}
