/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AgendaMarcacoes implements Serializable{
    //variaveis de instancia
    HashMap <LocalDate, ArrayList<Utente>> agenda;
    
    //construtor
    public AgendaMarcacoes(){
        agenda = new HashMap();
    }
    
    //Método seletor
    public HashMap<LocalDate, ArrayList<Utente>> getAgenda() {
        return agenda;
    }
    
    //Método modificador
    public void setAgenda(HashMap<LocalDate, ArrayList<Utente>> agenda) {
        this.agenda = agenda;
    }

    //metodos
    public void AdicionarMarcacao(LocalDate data, Utente utente){
        ArrayList<Utente> marcacoes = agenda.get(data);
        
        if (marcacoes == null){
           marcacoes= new ArrayList<>();
           marcacoes.add(utente);
           agenda.put(data, marcacoes);
        } else if (!marcacoes.contains(utente)){
           marcacoes.add(utente);
        }else {
           System.out.println("Utente já possui marcação para esse dia.");
        }       
    }
    
    public void CancelarMarcacao(LocalDate data, Utente utente){
        ArrayList<Utente> marcacoes = agenda.get(data);
        
        if (marcacoes != null && marcacoes.contains(utente)) {
            marcacoes.remove(utente);
            if (marcacoes.isEmpty()) {
                agenda.remove(data);
            }
        }
    }

    //consultar marcaçoes num certo dia
    public ArrayList<Utente> ConsultarMarcacao(LocalDate data){
        return agenda.get(data);
    }

    //consultar marcacoes dia seguinte
    public ArrayList<Utente> MarcacoesDiaSeguinte (){
        return agenda.get(LocalDate.now().plusDays(1));
    }
    
    //obter uma listagem com todos os utentes com marcacoes agendadas
    public List<Utente> MarcacoesAgendadas (){
        ArrayList<Utente> lista = new ArrayList();
        
        for (LocalDate data: agenda.keySet()){
            ArrayList<Utente> marcacoes = agenda.get(data);
            for (Utente utente : marcacoes) {
                if (!lista.contains(utente)) {
                    lista.add(utente);
                }
            }
        }
        return lista;
    }
    
    //obter listagem com marcacoes para os dias antes, ou seja os que faltaram
    public List<Utente> MarcacoesSemInoc (){
        ArrayList<Utente> lista = new ArrayList();
        
        for (LocalDate data: agenda.keySet()){
            if (data.isBefore(LocalDate.now()) || data.equals(LocalDate.now())){
                ArrayList<Utente> marcacoes = agenda.get(data);
                for (Utente utente : marcacoes) {
                    if (!lista.contains(utente)) {
                        lista.add(utente);
                    }
                } 
            }
            
        }
        return lista;
    }
    
    //calcular numero de marcacoes por dia
    public int CalcularNumeroMarcacoes(LocalDate data) {
        ArrayList<Utente> lista = agenda.get(data);

        if (lista == null) {
            return 0;
        }else{
            return lista.size();
        }
}
    
    //consultar data da próxima marcação de um utente
    public LocalDate ProximaMarcacao(Utente utente){
        int contador=0;
        ArrayList<Utente> marcacoes;
        do {
            if (agenda.containsKey(LocalDate.now().plusDays(contador))){
                marcacoes = agenda.get(LocalDate.now().plusDays(contador));
            }else{
                marcacoes= null;
            }
            contador+=1;
        } while (!marcacoes.contains(utente));
        return LocalDate.now().plusDays(contador);
    }
    
    //consultar o dia da marcacao do utente
    public LocalDate MarcacoesDoUtente(Utente utente){
        for(LocalDate data: agenda.keySet()){
            ArrayList<Utente> marcacoes = agenda.get(data);            
            if (marcacoes.contains(utente))
                return data;
        }
        return null;
    }
    

}

