/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.Administrador;
import backend.CentroVacinacao;
import backend.Gestor;
import backend.ListaCentVac;
import backend.ListaUtilizadores;
import backend.ListaVacinas;
import backend.Serializacao;
import backend.Sistema;
import backend.Utente;
import backend.Vacina;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;


public class Iniciar {
        public static void main(String[] args) throws ListaUtilizadores.UtilizadorDuplicadoException, ClassNotFoundException, ListaCentVac.CentroDuplicadoException, ListaVacinas.VacinaDuplicadaException 
    {
        Sistema sistema;        
        String ficheiroDados = String.format("%s\\utilizadores.data", System.getProperty("user.dir"));
        System.out.println(String.format("Ficheiro de dados: %s.", ficheiroDados));
        Serializacao bd = new Serializacao(ficheiroDados);        
        
        //Se o ficheiro de base de dados nao existir
        
        if (! bd.getFicheiro().exists()) {
            //Cria uma instancia do sistema
            sistema = new Sistema();      
            //Adiciona dois utilizadores para que possa ser possivel entrar no sistema
            sistema.getListaUtilizadores().adicionarUtilizador(new Administrador("admin","admin"));
            sistema.getListaUtilizadores().adicionarUtilizador(new Administrador("admin2","admin"));
            sistema.getListaUtilizadores().adicionarUtilizador(new Gestor("gestor1", "1234"));  
            sistema.getListaUtilizadores().adicionarUtilizador(new Gestor("gestor2", "1234"));
            sistema.getListaUtilizadores().adicionarUtilizador(new Utente("user1", "1234", "Pedro", "Braga", "Braga", 912563578, null, "pedroc@gmail.com", LocalDate.of(1994, 1, 13)));
            sistema.getListaCentros().adicionarCentro(new CentroVacinacao("centro1", "Braga", "Braga", 5));
            sistema.getListaCentros().adicionarCentro(new CentroVacinacao("centro2", "Porto", "Porto", 4));
            sistema.getListaVacinas().adicionarVacina(new Vacina("AC1", "AstraZenaca", "Oxford", 0.5f, "idade > 50", 2, 10, 20, new ArrayList<>(Arrays.asList("tontura", "febre"))));
            //String cod, String nome, String fabricante, float doseIndividual, String restricoes, int numTomas, int prazoMin, int prazoMax, ArrayList efeitosSecundarios
        }else{

            sistema = bd.lerSistema();            
        }                 
        
        //Uma vez que a JanelaLogin é modal, este método irá bloquear até que a janela seja fechada.
        //A janela só fecha quando os dados de login são válidos.                
        //PaginaLogin login = new PaginaLogin(sistema, bd);               
        //login.setVisible(true);
        
        Login login = new Login(sistema, bd);               
        login.setVisible(true);
        
    }
}

