/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Utente extends Utilizador implements Serializable{
    //variaveis de instancia
    private String nome;
    private String morada;
    private String localidade;
    private LocalDate dataNasc;
    private int contactoTlm;
    private ArrayList<String> doencasPrevias = new ArrayList<>();
    private String email;
    private CentroVacinacao centro;
    private Vacina vacina;
    private ArrayList<LocalDate> datasAdministracao;
    private boolean tomouVacina;      
    private int numTomas;

    //construtor
    public Utente (String user, String pass, String nome, String morada, String localidade, int tlm, ArrayList<String> doencas, String email, LocalDate data_nasc) {
        super(user, pass); //cod=nºutente
        this.nome=nome;
        this.dataNasc=data_nasc;
        this.contactoTlm= tlm;
        this.doencasPrevias = doencas;
        this.email=email;
        this.morada= morada;
        this.localidade=localidade;
        centro=null;
        tomouVacina=false;
        vacina=null;
        datasAdministracao=new ArrayList(); 
        numTomas=0;
    }
    
    //Métodos seletores
    public String getNome() {
        return nome;
    }
    
    public String getMorada() {
        return morada;
    }
    
    public String getLocalidade() {
        return localidade;
    }
    
    public LocalDate getDataNasc() {
        return dataNasc;
    }
    
    public int getContactoTlm() {
        return contactoTlm;
    }
    
    public ArrayList<String> getDoencas() {
        return doencasPrevias;
    }
    
    public String getEmail() {
        return email;
    }
    
    public CentroVacinacao getCentro() {
        return centro;
    }
    
    public Vacina getVacina() {
        return vacina;
    }
    
    public ArrayList getDataAdministracao() {
        return datasAdministracao;
    }
    
    public boolean isTomouVacina() {
        return tomouVacina;
    }
    
    public ArrayList<String> getDoencasPrevias() {
        return doencasPrevias;
    }

    public int getNumTomas() {
        return numTomas;
    }
    
    //Métodos modificadores
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setContactoTlm(int contactoTlm) {
        this.contactoTlm = contactoTlm;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Utente{" + "nome=" + nome + ", morada=" + morada + ", localidade=" + localidade + ", data_nasc=" + dataNasc + ", contacto_tlm=" + contactoTlm + ", doencas_previas=" + doencasPrevias + ", email=" + email + ", centro=" + centro + ", vacina=" + vacina + ", data_administracao=" + datasAdministracao + ", tomou_vacina=" + tomouVacina + '}';
    }

    
   public void setCentro(CentroVacinacao centro) {
        this.centro = centro;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public void setDataAdministracao(LocalDate dataAdministracao) {
        this.datasAdministracao.add(dataAdministracao);
    }

    public void setTomouVacina(boolean tomouVacina) {
        this.tomouVacina = tomouVacina;
    }
    
    public void setNumTomas(int numTomas) {
        this.numTomas = numTomas;
    }
    
    public void setDoencas_previas(ArrayList<String> doencasPrevias) {
        this.doencasPrevias = doencasPrevias;
     
    }

    public void adicionarDoencaPrevia(String doenca){
        try{
            if (!doencasPrevias.contains(doenca)){        
                doencasPrevias.add(doenca);
            }
        }catch(NullPointerException e){            
        }
    } 
    
    public void removerDoencaPrevia(String doenca){
        doencasPrevias.remove(doenca);
    } 

}
