
package ejercicioadmongo;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author jquesadaabeijon
 */
public class EjercicioADMongo {

    public static void main(String[] args) {
        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.SEVERE); 

        MongoClient cl = new MongoClient("localhost",27017); //Conexión
        MongoDatabase db = cl.getDatabase("digg"); //Conexión con la base de datos
        MongoCollection <Document> coleccion = db.getCollection("stories"); //Conexión con la colección
        BasicDBObject condicion = new BasicDBObject("diggs",Integer.parseInt(JOptionPane.showInputDialog("Escriba el valor de diggs que quiere buscar:"))); //Condición para la consulta
        FindIterable <Document> cursor1 = coleccion.find(condicion); //Crea el cursor para iterar
        MongoCursor <Document> iterar = cursor1.iterator(); //Llama al cursor que hemos creado
      
            while(iterar.hasNext()){
                Document doc = iterar.next();
                String kind = doc.getString("kind");
                Double score = doc.getDouble("score");
                Double student = doc.getDouble("student");
                System.out.println(kind + " , " + score + " , " + student);                
            }
    }
    
}
