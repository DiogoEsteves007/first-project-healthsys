/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Stock implements Serializable{    
    //variaveis de instancia
    private HashMap<Vacina, Integer> stock;
    
    //construtor
    public Stock (){
        stock = new HashMap();
    }
    
    //Método seletor
    public HashMap<Vacina, Integer> getStock() {
        return stock;
    }
    
    //Métodos
    public void criarStock(Vacina vacina, int quantidade){
        stock.put(vacina, quantidade);
    }
    
    //adicionar certa quantidade ao stock de uma vacina
    public void atualizarStock(Vacina vacina, int quantidade){
        stock.put(vacina, stock.get(vacina)+quantidade);   
    }
    
    //remover certa quantidade ao stock de uma vacina
    public void removerStock(Vacina vacina, int quantidade){
        stock.put(vacina, stock.get(vacina)-quantidade);
   
    }
 
    public boolean existeVacina (Vacina nome){
        return stock.containsKey(nome);
    }
    
    public int qtdVacina(Vacina vacina){
        return stock.get(vacina);
    }


}
