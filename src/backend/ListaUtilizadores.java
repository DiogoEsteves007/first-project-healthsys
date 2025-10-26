/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


public class ListaUtilizadores implements Serializable{
    //variaveis de instancia
    private HashMap<String, Utilizador> listaUtilizadores;

    //construtor
    public ListaUtilizadores() {
        listaUtilizadores = new HashMap<>();        
    }
    
    //exceções
    public class UtilizadorNaoExistenteException extends Exception {
        public UtilizadorNaoExistenteException() { }
        public UtilizadorNaoExistenteException(String message) {
            super(message);
        }        
    }
    
    public class UtilizadorDuplicadoException extends Exception {
        public UtilizadorDuplicadoException() { }
        public UtilizadorDuplicadoException(String message) {
            super(message);
        }        
    }
    
    //Método seletor
    public HashMap<String, Utilizador> getListaUtilizadores() {
        return listaUtilizadores;
    }

    public void adicionarUtilizador(Utilizador utilizador) throws UtilizadorDuplicadoException {
        if (utilizador == null) {
            throw new NullPointerException("O parâmetro 'utilizador' não pode ser um valor nulo");
        }        
        
        if (!listaUtilizadores.containsKey(utilizador.getUsername())) {
            listaUtilizadores.put(utilizador.getUsername(), utilizador);
        }else{
            throw new UtilizadorDuplicadoException(String.format("O utilizador já existe na coleção", utilizador.getUsername()));
        } 
    }
   
    
    public boolean existe(String username) {
        return listaUtilizadores.containsKey(username);
    }
    
    public int size() {
        return listaUtilizadores.size();
    }
    
    public void removerUtilizador(String username) {
        listaUtilizadores.remove(username);
    }
    
    public Utilizador getUtilizador(String username) throws UtilizadorNaoExistenteException {
        if (listaUtilizadores.containsKey(username)){
            return listaUtilizadores.get(username);
        }else{
            throw new UtilizadorNaoExistenteException("O utilizador já existe na lista");
        }
    }

    public Utente getUtente(Utente utente) throws UtilizadorNaoExistenteException {
        if (listagemUtentes().contains(utente)){
            return utente;
        }else{
            throw new UtilizadorNaoExistenteException("O utilizador já existe na lista");
        }
    }
    
    public ArrayList<Utilizador> listagemUtilizadores() {
        return new ArrayList<>(listaUtilizadores.values());
    }
    
    public ArrayList<Gestor> listagemGestores(){
        ArrayList <Gestor> listaGestores = new ArrayList<>();
        for( HashMap.Entry e : listaUtilizadores.entrySet()){
            if(e.getValue() instanceof Gestor)
                listaGestores.add((Gestor)e.getValue());
        }

        return listaGestores;
    }
    
    public ArrayList<Utente> listagemUtentes(){
        ArrayList <Utente> listaUtentes = new ArrayList<>();
        for( HashMap.Entry e : listaUtilizadores.entrySet()){
            if(e.getValue() instanceof Utente)
                listaUtentes.add((Utente)e.getValue());
        }

        return listaUtentes;
    }
    
    public ArrayList<Utente> listarUtentesCentro (CentroVacinacao centro){ 
        ArrayList<Utente> listaUtentes =new ArrayList();
            for(Utente e : listagemUtentes()) {
                if (e.getCentro()==centro){
                    listaUtentes.add(e);
                }
            }
            return listaUtentes;    
    }
    
    //devolve lista com os gestores que não estão atribuidos a nenhum centro
    public ArrayList gestoresLivres(){
        ArrayList<Gestor> listaGestoresLivres =new ArrayList();
        ArrayList<Gestor> listaGestores =listagemGestores();
        for(Gestor g : listaGestores){
            if(g.getCentroAtribuido()==null){
                listaGestoresLivres.add(g);
            }
        }
       return listaGestoresLivres;
    }


}


