/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import java.io.Serializable;
import java.util.ArrayList;

public class ListaCentVac implements Serializable{
    //variaveis de instancia
    private ArrayList <CentroVacinacao> listaCentros; 
        
    //construtor
    public ListaCentVac (){
        listaCentros= new ArrayList();
    }
    
    //exceções
    public class CentroNaoExistenteException extends Exception {
        public CentroNaoExistenteException() { }
        public CentroNaoExistenteException(String message) {
            super(message);
        }        
    }
    
    public class CentroDuplicadoException extends Exception {
        public CentroDuplicadoException() { }
        public CentroDuplicadoException(String message) {
            super(message);
        }        
    }
    
    //Método seletor
    public ArrayList<CentroVacinacao> getListaCentros () {
         return listaCentros;
    }
    
    public int lenght(){
        return listaCentros.size();
    }

    public void adicionarCentro (CentroVacinacao centro) throws CentroDuplicadoException{       
        try{    
            if(!listaCentros.contains(centro)){
                listaCentros.add(centro); 
            }
        }catch (NullPointerException e){
            throw new CentroDuplicadoException(String.format("O centro já existe ", centro.getCodigo()));
        }                  
    }    

    
    public void removerCentro (CentroVacinacao centro){
        listaCentros.remove(centro);
    }
    
    //listagem de todos os centros
    public ArrayList listagemCentros(){
        ArrayList <CentroVacinacao> lista =new ArrayList();
        for (CentroVacinacao centro : listaCentros){
            lista.add(centro);       
        }
        return lista;
    }
    

    public boolean existe(String centro){
       for(int i=0; i<listaCentros.size(); i++){
           if(listaCentros.get(i).getCodigo().equals(centro)){
               return true;
           }
       } 
       return false;
     }
    
    //nºde vacinas administradas em todos os centros
    public int numVacAdministradas(){ 
        int vacinasTotal=0;
        for(CentroVacinacao centro : listaCentros){
            vacinasTotal += centro.getNumVacAdministradas();
        }  
        return vacinasTotal;
     }
    
    //lista com os efeitos secundarios de todos os centros
    public ArrayList efeitosSecPopulacao(){
        ArrayList listaEfeitos = new ArrayList();
        for(CentroVacinacao centro : listaCentros){
           for (int i=0; i<centro.getListaEfeitosSecRegistados().size(); i++){
              listaEfeitos.add(centro.getListaEfeitosSecRegistados().get(i));
           }
        }  
        return listaEfeitos;
    }
    
    //ver os centros numa localidade
    public CentroVacinacao centrosPorLocalidade(String localidadeUtente){
        for (CentroVacinacao centro : listaCentros)
            if(centro.getLocalidade().equals(localidadeUtente)){
              return centro;  
            }
            return null;
    }
    
    public CentroVacinacao getCentroVacinacao(String codigo)throws ListaCentVac.CentroNaoExistenteException{
        for (CentroVacinacao centro : listaCentros){
            if (centro.getCodigo().equals(codigo)){
                return centro;             
            }
        }
        throw new ListaCentVac.CentroNaoExistenteException("O centro não existe na lista");     
   }
   
}

