/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class CentroVacinacao implements Serializable {
    //variaveis de instancia
    private String codigo;
    private String morada;
    private String localidade;
    private int numPostos;
    private Gestor gestor;
    private AgendaMarcacoes marcacoes;
    private Stock stockVacinas;
    private int numMaxMarcacoes; //numero maximo de marcaçoes por dia
    private int numVacAdministradas; 
    private ArrayList<String> listaEfeitosSecRegistados; 
   
    ///construtor
    public CentroVacinacao(String cod, String mor, String local, int n_postos){
        this.codigo=cod;
        this.morada=mor;
        this.localidade=local;
        this.numPostos=n_postos;
        gestor=null;
        marcacoes = new AgendaMarcacoes();
        stockVacinas= new Stock();
        numMaxMarcacoes=2; 
        numVacAdministradas= 0; 
        listaEfeitosSecRegistados= new ArrayList<>();
    }
    

    //Métodos seletores    
    public String getMorada (){
        return morada;
    }
    
    public String getLocalidade (){
        return localidade;
    }

    public Gestor getGestor (){
        return gestor;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public int getNumPostos() {
        return numPostos;
    }
    
    public AgendaMarcacoes getMarcacoes() {
        return marcacoes;
    }
    
    public Stock getStockVacinas() {
        return stockVacinas;
    }
    
    public int getNumMaxMarcacoes() {
        return numMaxMarcacoes;
    }
    
    public int getNumVacAdministradas() {
        return numVacAdministradas;
    }
    
    public ArrayList getListaEfeitosSecRegistados() {
        return listaEfeitosSecRegistados;
    }
    
    //Métodos modificadores
    public void setGestor (Gestor gestorNovo){
        gestor=gestorNovo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNumPostos(int numPostos) {
        this.numPostos = numPostos;
    }

    public void setMarcacoes(AgendaMarcacoes marcacoes) {
        this.marcacoes = marcacoes;
    }

    public void setStockVacinas(Stock stockVacinas) {
        this.stockVacinas = stockVacinas;
    }

    public void setNumMaxMarcacoes(int numMaxMarcacoes) {
        this.numMaxMarcacoes = numMaxMarcacoes;
    }
       
    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
    
    public void setNumVacAdministradas(int numVacAdministradas) {
        this.numVacAdministradas = numVacAdministradas;
    }

    //métodos
    @Override
    public String toString (){
        return "Codigo= "+ codigo+ "\nMorada: "+morada+ "\nLocalidade: " + localidade +"\nNºpostos: "+numPostos;
    }
    
    public void fazerMarcacao(LocalDate dia, Utente utente){
        int num_marcacoes=marcacoes.CalcularNumeroMarcacoes(dia);

        if (num_marcacoes >= numMaxMarcacoes) {
            System.out.println("Nao existe disponibilidade para mais marcacoes neste dia");
        }else{
            marcacoes.AdicionarMarcacao(dia, utente);
        }
    }
    
    public void cancelarMarcacao(LocalDate dia, Utente utente){
        marcacoes.CancelarMarcacao(dia, utente);
    }
    
    public void criarStock(Vacina vacina, int quantidade){
        stockVacinas.criarStock(vacina, quantidade);
    }
    
    //adicionar certa quantidade ao stock de uma vacina
    public void atualizarStock(Vacina vacina, int quantidade){
        stockVacinas.atualizarStock(vacina, quantidade);        
    }
    
    //remover certa quantidade ao stock de uma vacina
    public void removerStock(Vacina vacina, int quantidade){
        stockVacinas.removerStock(vacina, quantidade);   
    }
    
    //nºde vacinas administradas num centro
    public void numVacAdministradas(){ 
         numVacAdministradas++; 
    }
   
    public void adicionarEfeitosSecundarios(String efeitoSecundario){
        listaEfeitosSecRegistados.add(efeitoSecundario);
    }
    
    public void inoculacao(Utente utente, Vacina vacina, String efeitosSecundarios){
        if (utente.getNumTomas()<vacina.getNumTomas()){
            //se for a 1º dose fica registada a vacina
            if(utente.getNumTomas()==0){
                utente.setVacina(vacina);
            }           
            numVacAdministradas();
            utente.setNumTomas(utente.getNumTomas()+1);
            //se o nº de tomas que levou for igual ao nº de tomas da vacina, o utente fica registado como vacinado
            if (utente.getNumTomas()==vacina.getNumTomas()){
                utente.setTomouVacina(true); 
            }
            removerStock(vacina, 1);
            utente.setDataAdministracao(marcacoes.MarcacoesDoUtente(utente)); 
            marcacoes.CancelarMarcacao(LocalDate.now(), utente);
            if (efeitosSecundarios!=null){
                adicionarEfeitosSecundarios(efeitosSecundarios);
            }
            //comparar nºde doses da vacina e ver qts faltam
            try{
                if (utente.getNumTomas()<vacina.getNumTomas()){
                    LocalDate dia = marcacoes.MarcacoesDoUtente(utente);
                    for (int i=vacina.getPrazoMin(); i<=vacina.getPrazoMax(); i++)
                        dia = marcacoes.MarcacoesDoUtente(utente).plusDays(i);
                        if (marcacoes.CalcularNumeroMarcacoes(dia)<numMaxMarcacoes){
                            fazerMarcacao(dia, utente);
                        }              
                }
            }catch(Exception e){
                System.out.println("O utente ja tomou todas as doses necessarias");
            }
        }
    }
}

