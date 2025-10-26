/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 */
public class Sistema implements Serializable{
    private ListaUtilizadores listaUtilizadores;
    private Utilizador utilizadorLigado;
    private ListaCentVac listaCentros;
    private ListaVacinas listaVacinas;

    public Sistema(){
        listaUtilizadores = new ListaUtilizadores();
        listaCentros = new ListaCentVac();
        listaVacinas= new ListaVacinas();
    }
       
    public ListaUtilizadores getListaUtilizadores(){
        return listaUtilizadores;
    }
    
    public ListaCentVac getListaCentros() {
        return listaCentros;
    }

    public ListaVacinas getListaVacinas() {
        return listaVacinas;
    }

    public void setListaUtilizadores(ListaUtilizadores listaUtilizadores) {
        this.listaUtilizadores = listaUtilizadores;
    }

    public void setUtilizadorLigado(Utilizador utilizadorLigado) {
        this.utilizadorLigado = utilizadorLigado;
    }

    public void setListaCentros(ListaCentVac listaCentros) {
        this.listaCentros = listaCentros;
    }
    
    public void setListaVacinas(ListaVacinas listaVacinas) {
        this.listaVacinas = listaVacinas;
    }
    
    public Utilizador getUtilizadorLigado() {
        return utilizadorLigado;
    }
    
    public boolean autenticarUtilizador(String username, String password) {        
        if (listaUtilizadores.existe(username)) {
            try{
                Utilizador u = listaUtilizadores.getUtilizador(username);                
                if (u.getPassword().equals(password)){
                    utilizadorLigado = u;
                    return true;
                }                
            }catch (Exception e) {}                        
        }        
        return false;        
    }
    
    public void inicializar() throws ListaUtilizadores.UtilizadorDuplicadoException {
        listaUtilizadores.adicionarUtilizador(new Administrador("admin", "admin"));
        listaUtilizadores.adicionarUtilizador(new Utilizador("user1", "1234"));
        listaUtilizadores.adicionarUtilizador(new Utilizador("user2", "1234"));        
    }
    
    public void terminar() {
        System.exit(0);
    }  
}
