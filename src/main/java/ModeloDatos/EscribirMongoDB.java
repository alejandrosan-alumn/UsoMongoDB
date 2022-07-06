/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDatos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexP
 */
public class EscribirMongoDB{
    
    Conexion conectarse;
    public EscribirMongoDB() {
        
        conectarse = null;
    }

    public void EscribirFicheroEmpresas(ArrayList<Empresa>objetoRef){
        
        if(objetoRef.size() > this.DimensionTablaEmpresa()){
            
            this.AniadirEmpresa(objetoRef.get(objetoRef.size()-1));
        }
        else if(objetoRef.size() < this.DimensionTablaEmpresa()){
                
                this.EliminarEmpresa(objetoRef);
        }
        else{
            this.ModificarEmpresa(objetoRef);
        }
    }
    
    public void ModificarEmpresa(ArrayList<Empresa>objeto){
        
        this.conectarse = new Conexion();
        MongoDatabase conexionEmpresa = this.conectarse.Conectarse();
        MongoCollection<Empresa> coleccionEmpresa = conexionEmpresa.getCollection("empresas", Empresa.class);
        List<Empresa> empresas = coleccionEmpresa.find().into(new ArrayList<Empresa>());
        
        for(int i = 0; i < empresas.size(); i++){
            
            for(int j = 0; j < objeto.size(); j++){
                
                if(empresas.get(i).getIdEmpresa() == objeto.get(j).getIdEmpresa()){
                    
                    if(!empresas.get(i).equals(objeto.get(j))){
                        coleccionEmpresa.replaceOne(eq("idEmpresa", empresas.get(i).getIdEmpresa()), objeto.get(j));
                    }
                }
            }
        }
        this.conectarse.Desconectarse();
    }
    
    public void EliminarEmpresa(ArrayList<Empresa>objeto){
        
        this.conectarse = new Conexion();
        boolean idEncontrado = false;
        MongoDatabase conexionEmpresa = this.conectarse.Conectarse();
        MongoCollection<Empresa> coleccionEmpresas = conexionEmpresa.getCollection("empresas", Empresa.class);
        List<Empresa> empresas = coleccionEmpresas.find().into(new ArrayList<Empresa>());
        for(int i = 0; i < empresas.size(); i++){
            
            idEncontrado = false;
            for(int j = 0; j < objeto.size(); j++){
                
                if(empresas.get(i).getIdEmpresa() == objeto.get(j).getIdEmpresa()){
                    idEncontrado = true;
                }
            }
            if(!idEncontrado){
                coleccionEmpresas.deleteOne(eq("idEmpresa", empresas.get(i).getIdEmpresa()));
            }
        }
        this.conectarse.Desconectarse();
    }
    
    public void AniadirEmpresa(Empresa objetoAnadido){
        
        this.conectarse = new Conexion();
        MongoDatabase conexionEmpresa = this.conectarse.Conectarse();
        MongoCollection<Empresa> coleccionEmpresas = conexionEmpresa.getCollection("empresas", Empresa.class);
        coleccionEmpresas.insertOne(objetoAnadido);
        this.conectarse.Desconectarse();
    }
    
    public void EscribirFicheroSagas(ArrayList<Saga>objetoRef){
        
        if(objetoRef.size() > this.DimensionTablaSagas()){
            
            this.AniadirSaga(objetoRef.get(objetoRef.size()-1));
        }
        else if(objetoRef.size() < this.DimensionTablaSagas()){
                
                this.EliminarSaga(objetoRef);
        }
        else{
            
            this.ModificarSaga(objetoRef);
        }
    }
    
    public void ModificarSaga (ArrayList<Saga>objeto){
        
        this.conectarse = new Conexion();
        MongoDatabase conexionSaga = this.conectarse.Conectarse();
        MongoCollection<Saga> coleccionSaga = conexionSaga.getCollection("sagas", Saga.class);
        List<Saga> sagas = coleccionSaga.find().into(new ArrayList<Saga>());
        
        for(int i = 0; i < sagas.size(); i++){
            
            for(int j = 0; j < objeto.size(); j++){
                
                if(sagas.get(i).getIdSaga() == objeto.get(j).getIdSaga()){
                    
                    if(!sagas.get(i).equals(objeto.get(j))){
                        coleccionSaga.replaceOne(eq("idSaga", sagas.get(i).getIdSaga()), objeto.get(j));
                    }
                }
            }
        }
        this.conectarse.Desconectarse();
    }
    
    public void EliminarSaga(ArrayList<Saga>objeto){
        
        this.conectarse = new Conexion();
        boolean idEncontrado = false;
        MongoDatabase conexionSaga = this.conectarse.Conectarse();
        MongoCollection<Saga> coleccionSaga = conexionSaga.getCollection("sagas", Saga.class);
        List<Saga> sagas = coleccionSaga.find().into(new ArrayList<Saga>());
        
        for(int i = 0; i < sagas.size(); i++){
            
            idEncontrado = false;
            for(int j = 0; j < objeto.size(); j++){
                
                if(sagas.get(i).getIdSaga() == objeto.get(j).getIdSaga()){
                    idEncontrado = true;
                }
            }
            if(!idEncontrado){
                coleccionSaga.deleteOne(eq("idSaga", sagas.get(i).getIdSaga()));
            }
        }
        this.conectarse.Desconectarse();
    }
    
    public void AniadirSaga(Saga objetoAnadido){
        
        this.conectarse = new Conexion();
        MongoDatabase conexionSaga = this.conectarse.Conectarse();
        MongoCollection<Saga> coleccionSagas = conexionSaga.getCollection("sagas", Saga.class);
        coleccionSagas.insertOne(objetoAnadido);
        this.conectarse.Desconectarse();
    }
    
    public void EscribirFicheroVideojuegos(ArrayList<Videojuego>objetoRef){

        if(objetoRef.size() > this.DimensionTablaVideojuegos()){
            
            this.AniadirVideojuego(objetoRef.get(objetoRef.size()-1));
        }
        else if(objetoRef.size() < this.DimensionTablaVideojuegos()){
                
                this.EliminarVideojuego(objetoRef);
        }
        else{
            
            this.ModificarVideojuego(objetoRef);
        }
    }
    
    public void ModificarVideojuego (ArrayList<Videojuego>objeto){
        
        this.conectarse = new Conexion();
        MongoDatabase conexionVideojuego = this.conectarse.Conectarse();
        MongoCollection<Videojuego> coleccionVideojuego = conexionVideojuego.getCollection("videojuegos", Videojuego.class);
        List<Videojuego> videojuegos = coleccionVideojuego.find().into(new ArrayList<Videojuego>());
        
        for(int i = 0; i < videojuegos.size(); i++){
            
            for(int j = 0; j < objeto.size(); j++){
                
                if(videojuegos.get(i).getIdVideojuego() == objeto.get(j).getIdVideojuego()){
                    
                    if(!videojuegos.get(i).equals(objeto.get(j))){
                        coleccionVideojuego.replaceOne(eq("idVideojuego", videojuegos.get(i).getIdVideojuego()), objeto.get(j));
                    }
                }
            }
        }
        this.conectarse.Desconectarse();
    }
    
    public void EliminarVideojuego(ArrayList<Videojuego>objeto){
        
        this.conectarse = new Conexion();
        boolean idEncontrado = false;
        MongoDatabase conexionVideojuego = this.conectarse.Conectarse();
        MongoCollection<Videojuego> coleccionVideojuego = conexionVideojuego.getCollection("videojuegos", Videojuego.class);
        List<Videojuego> videojuegos = coleccionVideojuego.find().into(new ArrayList<Videojuego>());
        
        for(int i = 0; i < videojuegos.size(); i++){
            
            idEncontrado = false;
            for(int j = 0; j < objeto.size(); j++){
                
                if(videojuegos.get(i).getIdVideojuego() == objeto.get(j).getIdVideojuego()){
                    idEncontrado = true;
                }
            }
            if(!idEncontrado){
                coleccionVideojuego.deleteOne(eq("idVideojuego", videojuegos.get(i).getIdVideojuego()));
            }
        }
        this.conectarse.Desconectarse();
    }
    
    public void AniadirVideojuego(Videojuego objetoAnadido){
        
        this.conectarse = new Conexion();
        MongoDatabase conexionVideojuego = this.conectarse.Conectarse();
        MongoCollection<Videojuego> coleccionVideojuegos = conexionVideojuego.getCollection("videojuegos", Videojuego.class);
        coleccionVideojuegos.insertOne(objetoAnadido);
        this.conectarse.Desconectarse();
    }
    
    public void EscribirFicheroPersonajes(ArrayList<Personaje>objetoRef){
        
        if(objetoRef.size() > this.DimensionTablaPersonajes()){
            
            this.AniadirPersonaje(objetoRef.get(objetoRef.size()-1));
        }
        else if(objetoRef.size() < this.DimensionTablaPersonajes()){
                
                this.EliminarPersonaje(objetoRef);
        }
        else{
            
            this.ModificarPersonaje(objetoRef);
        }
    }
    
    public void ModificarPersonaje (ArrayList<Personaje>objeto){
        
        this.conectarse = new Conexion();
        boolean idEncontrado = false;
        MongoDatabase conexionPersonaje = this.conectarse.Conectarse();
        MongoCollection<Personaje> coleccionPersonaje = conexionPersonaje.getCollection("personajes", Personaje.class);
        List<Personaje> personajes = coleccionPersonaje.find().into(new ArrayList<Personaje>());
        
        for(int i = 0; i < personajes.size(); i++){
            
            for(int j = 0; j < objeto.size(); j++){
                
                if(personajes.get(i).getIdProtagonista() == objeto.get(j).getIdProtagonista()){
                    
                    if(!personajes.get(i).equals(objeto.get(j))){
                        coleccionPersonaje.replaceOne(eq("idProtagonista", personajes.get(i).getIdProtagonista()), objeto.get(j));
                    }
                }
            }
        }
        this.conectarse.Desconectarse();
    }
    
    public void EliminarPersonaje(ArrayList<Personaje>objeto){
        
       this.conectarse = new Conexion();
        boolean idEncontrado = false;
        MongoDatabase conexionPersonaje = this.conectarse.Conectarse();
        MongoCollection<Personaje> coleccionPersonaje = conexionPersonaje.getCollection("personajes", Personaje.class);
        List<Personaje> personajes = coleccionPersonaje.find().into(new ArrayList<Personaje>());
        
        for(int i = 0; i < personajes.size(); i++){
            
            idEncontrado = false;
            for(int j = 0; j < objeto.size(); j++){
                
                if(personajes.get(i).getIdProtagonista() == objeto.get(j).getIdProtagonista()){
                    idEncontrado = true;
                }
            }
            if(!idEncontrado){
                coleccionPersonaje.deleteOne(eq("idProtagonista", personajes.get(i).getIdProtagonista()));
            }
        }
        this.conectarse.Desconectarse();
    }
    
    public void AniadirPersonaje(Personaje objetoAnadido){
        
        this.conectarse = new Conexion();
        MongoDatabase conexionPersonaje = this.conectarse.Conectarse();
        MongoCollection<Personaje> coleccionPersonajes = conexionPersonaje.getCollection("personajes", Personaje.class);
        coleccionPersonajes.insertOne(objetoAnadido);
        this.conectarse.Desconectarse();
    }
    
    public int DimensionTablaPersonajes(){
        
        int tablaPersonajes = 0;
        this.conectarse = new Conexion();
        MongoDatabase conexionPersonaje = this.conectarse.Conectarse();
        MongoCollection<Personaje> coleccionPersonajes = conexionPersonaje.getCollection("personajes", Personaje.class);
        List<Personaje> personajes = coleccionPersonajes.find().into(new ArrayList<Personaje>());
        this.conectarse.Desconectarse();
        
        tablaPersonajes = personajes.size();
        return tablaPersonajes;
        
        
    }
    
    public int DimensionTablaVideojuegos(){
        
        int tablaVideojuegos = 0;
        this.conectarse = new Conexion();
        MongoDatabase conexionVideojuego = this.conectarse.Conectarse();
        MongoCollection<Videojuego> coleccionVideojuegos = conexionVideojuego.getCollection("videojuegos", Videojuego.class);
        List<Videojuego> videojuegos = coleccionVideojuegos.find().into(new ArrayList<Videojuego>());
        this.conectarse.Desconectarse();
        
        tablaVideojuegos = videojuegos.size();
        return tablaVideojuegos;
        
        
    }
    
    public int DimensionTablaSagas(){
        
        int tablaSagas = 0;
        this.conectarse = new Conexion();
        MongoDatabase conexionSaga = this.conectarse.Conectarse();
        MongoCollection<Saga> coleccionSagas = conexionSaga.getCollection("sagas", Saga.class);
        List<Saga> sagas = coleccionSagas.find().into(new ArrayList<Saga>());
        this.conectarse.Desconectarse();
        
        tablaSagas = sagas.size();
        return tablaSagas;
    }    
    
    public int DimensionTablaEmpresa(){
        
        this.conectarse = new Conexion();
        MongoDatabase conexionEmpresa = this.conectarse.Conectarse();
        int tamanioTabla = 0;
        MongoCollection<Empresa> coleccionEmpresas = conexionEmpresa.getCollection("empresas", Empresa.class);
        List<Empresa> empresas = coleccionEmpresas.find().into(new ArrayList<Empresa>());
        this.conectarse.Desconectarse();
        
        tamanioTabla = empresas.size();
        return tamanioTabla;
    }
}
