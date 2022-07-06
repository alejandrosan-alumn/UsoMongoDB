/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDatos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author alexP
 */
public class LeerMongoDB {

    Conexion conectarse;
    
    public LeerMongoDB() {
    
        conectarse = null;
    }
    
    public void LeerFicheroEmpresa(ArrayList<Empresa>listaEmpresa){
        
        this.conectarse = new Conexion();
        MongoDatabase conexionEmpresa = this.conectarse.Conectarse();
        if(!conexionEmpresa.equals(null)){
        MongoCollection<Empresa> coleccionEmpresas = conexionEmpresa.getCollection("empresas", Empresa.class);
        List<Empresa> empresas = coleccionEmpresas.find().into(new ArrayList<Empresa>());
        listaEmpresa.addAll(empresas);
        }
        else{
            System.err.println("Base de datos vacía.");
        }
        this.conectarse.Desconectarse();
    }
    
    public void LeerFicheroSaga(ArrayList<Saga>lista){
        
        this.conectarse = new Conexion();
        MongoDatabase conexionSaga = this.conectarse.Conectarse();
        if(!conexionSaga.equals(null)){
        MongoCollection<Saga> coleccionSagas = conexionSaga.getCollection("sagas", Saga.class);
        List<Saga> sagas = coleccionSagas.find().into(new ArrayList<Saga>());
        lista.addAll(sagas);
        }
        else{
            System.err.println("Base de datos vacía.");
        }
        this.conectarse.Desconectarse();
    }
    
    public void LeerFicheroVideojuego(ArrayList<Videojuego>lista){
        
        this.conectarse = new Conexion();
        MongoDatabase conexionVideojuego = this.conectarse.Conectarse();
        if(!conexionVideojuego.equals(null)){
        MongoCollection<Videojuego> coleccionVideojuegos = conexionVideojuego.getCollection("videojuegos", Videojuego.class);
        List<Videojuego> videojuegos = coleccionVideojuegos.find().into(new ArrayList<Videojuego>());
        lista.addAll(videojuegos);
        }
        else{
            System.err.println("Base de datos vacía.");
        }
        this.conectarse.Desconectarse();
    }
    
    public void LeerFicheroPersonaje(ArrayList<Personaje>lista){
        
        this.conectarse = new Conexion();
        MongoDatabase conexionPersonaje = this.conectarse.Conectarse();
        if(!conexionPersonaje.equals(null)){
        MongoCollection<Personaje> coleccionPersonajes = conexionPersonaje.getCollection("personajes", Personaje.class);
        List<Personaje> personajes = coleccionPersonajes.find().into(new ArrayList<Personaje>());
        lista.addAll(personajes);
        }
        else{
            System.err.println("Base de datos vacía.");
        }
        this.conectarse.Desconectarse();
    }
}