/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.Serializable;
import java.util.ArrayList;

public class Vacina implements Serializable {
    private String nomeVacina;
    private String codVacina;
    private String fabricante;
    private float doseIndividual;
    private String restricoes;
    private int numTomas;
    private int prazoMin; //limite minimo de dias entre doses
    private int prazoMax; //limite maximo de dias entre doses
    private ArrayList <String> efeitosSecundarios;
    
    
    //construtor
    public Vacina(String cod, String nome, String fabricante, float doseIndividual, String restricoes, int numTomas, int prazoMin, int prazoMax, ArrayList efeitosSecundarios){
        this.codVacina=cod;
        this.nomeVacina= nome;
        this.fabricante=fabricante;
        this.doseIndividual=doseIndividual;
        this.restricoes=restricoes;
        this.numTomas=numTomas;
        this.prazoMin=prazoMin;
        this.prazoMax=prazoMax;
        this.efeitosSecundarios=efeitosSecundarios;
    
}
    //Métodos seletores
    public String getNomeVacina() {
        return nomeVacina;
    }
    public String getCodVacina() {
        return codVacina;
    }
    
    public String getFabricante() {
        return fabricante;
    }
    
    public float getDoseIndividual() {
        return doseIndividual;
    }
    
    public String getRestricoes() {
        return restricoes;
    }
    
    public int getNumTomas() {
        return numTomas;
    }
    
    public int getPrazoMin() {
        return prazoMin;
    }
    
    public int getPrazoMax() {
        return prazoMax;
    }
    
    public ArrayList<String> getEfeitosSecundarios() {
        return efeitosSecundarios;
    }
    
    //Métodos modificadores
    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public void setCodVacina(String codVacina) {
        this.codVacina = codVacina;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setDoseIndividual(float doseIndividual) {
        this.doseIndividual = doseIndividual;
    }

    public void setRestricoes(String restricoes) {
        this.restricoes = restricoes;
    }

    public void setNumTomas(int numTomas) {
        this.numTomas = numTomas;
    }

    public void setPrazoMin(int prazoMin) {
        this.prazoMin = prazoMin;
    }

    public void setPrazoMax(int prazoMax) {
        this.prazoMax = prazoMax;
    }

    public void setEfeitosSecundarios(ArrayList<String> efeitosSecundarios) {
        this.efeitosSecundarios = efeitosSecundarios;
    }
}

