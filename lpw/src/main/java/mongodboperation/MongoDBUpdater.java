/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongodboperation;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.conversions.Bson;


public class MongoDBUpdater {
    
    
    public boolean getupdate(String collecname, ArrayList prev, String id, ArrayList att)
    {
        
        System.out.println("Inside Updater ");
        System.out.println("collecname "+collecname);
        System.out.println("prev "+prev);
        System.out.println("id "+id);
        System.out.println("att "+att);
        boolean flag=false;
        
        try
        {
            
        
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("datasecurity");
        MongoCollection<Document> collection = db.getCollection(collecname);
        
                
        int x=Integer.parseInt((String) att.get(0));
          String str2=(String) att.get(1);
           String value=(String) prev.get(x);
           
        Document query = new Document();
        query.append("sr no",id);
        
        Document setData = new Document();
        setData.append(str2, value);
        
        Document update = new Document();
        update.append("$set", setData);
        //To update single Document  
        collection.updateOne(query, update);
       
//      
//        
//       
        
        System.out.println("Attribute Name: "+str2);
        System.out.println("Original Value: "+value);
//        
//       
//        Bson filter = new Document("sr no", id);
//        Bson newValue = new Document(str2, value);
//        Bson updateOperationDocument = new Document("$set", newValue);
//        collection.updateOne(filter, updateOperationDocument);

        mongoClient.close();
        flag=true;
        }
        
         catch(Exception e)
        {
            System.out.println("Exception in MongoDBUpdater Class is: "+e);
            flag=false;
        }
        
        return flag;
    }
}
