/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.Serializable;
import java.util.ArrayList;


public class ListaVacinas implements Serializable{
    //variaveis de instancia
    ArrayList<Vacina> listaVacinas;
    
    //construtor
    public ListaVacinas(){
        listaVacinas=new ArrayList();
    }

    //exceçoes
        public class VacinaNaoExistenteException extends Exception {
        public VacinaNaoExistenteException() { }
        public VacinaNaoExistenteException(String message) {
            super(message);
        }        
    }
    
    public class VacinaDuplicadaException extends Exception {
        public VacinaDuplicadaException() { }
        public VacinaDuplicadaException(String message) {
            super(message);
        }        
    }
    
    //Método seletor
    public ArrayList<Vacina> getListaVacinas() {
        return listaVacinas;
    }

    //Método modificador
    public void setListaVacinas(ArrayList<Vacina> listaVacinas) {
        this.listaVacinas = listaVacinas;
    }
    
    //buscar vacina atraves do codigo
    public Vacina getVacina(String cod) throws VacinaNaoExistenteException{
        for (Vacina vac : listaVacinas){
            if (vac.getCodVacina().equals(cod)){
                return vac;
            }
        }
        throw new VacinaNaoExistenteException("A vacina não existe na lista");
    }
    
    //buscar vacina atraves do nome
    public Vacina getVacinaNome(String nome) throws VacinaNaoExistenteException{
        for (Vacina vac : listaVacinas){
            if (vac.getNomeVacina().equals(nome)){
                return vac;
            }
        }
        throw new VacinaNaoExistenteException("A vacina não existe na lista");
    }
    
    public void adicionarVacina(Vacina vacina) throws VacinaDuplicadaException{
        try{
            if(!listaVacinas.contains(vacina)){
                listaVacinas.add(vacina);
            } 
        }catch (NullPointerException e){
            throw new VacinaDuplicadaException(String.format("Vacina já existe "));
        }        
    }
    
    public void removerVacina(Vacina vacina){
        listaVacinas.remove(vacina);
    }
            
    public boolean existe(Vacina vacina){
        return listaVacinas.contains(vacina);
    }
}
