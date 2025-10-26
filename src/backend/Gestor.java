/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.Serializable;

public class Gestor extends Utilizador implements Serializable{
    //variaveis de instancia
    private CentroVacinacao centroAtribuido;
    
    //construtor
    public Gestor (String user, String passe){
        super(user,passe);
        centroAtribuido=null;
    }
    
    //Método seletor
    public CentroVacinacao getCentroAtribuido() {
        return centroAtribuido;
    }

    //Método modificador
    public void setCentroAtribuido(CentroVacinacao centroAtribuido) {
        this.centroAtribuido = centroAtribuido;
    }

}