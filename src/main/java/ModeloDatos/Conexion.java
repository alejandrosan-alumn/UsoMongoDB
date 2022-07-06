/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDatos;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoDatabase;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author alexP
 */
public class Conexion {

    MongoClient conexion;
    String rutaConexion;
    CodecRegistry registropoyos;
    
    public Conexion() {
        
        this.registropoyos = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
    CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        conexion = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(registropoyos).build());
        rutaConexion = null;
    }
    
    public MongoDatabase Conectarse(){
        
        MongoDatabase conexionBD;
        this.rutaConexion = "PracticaMongodb";
        conexionBD = conexion.getDatabase(rutaConexion);
        
        return conexionBD;
    }
    public void Desconectarse(){
        
        this.conexion.close();
    }
}
