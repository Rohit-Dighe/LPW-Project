/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongodboperation;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import org.bson.Document;


public class ReadAttributeNames {
    
     public String[] getAttributename(String collectionname)
    {
        MongoClient client = new MongoClient("localhost", 27017);
        DB db = client.getDB("datasecurity");
         
         DBCursor cur = db.getCollection(collectionname).find();
         DBObject dbo = cur.next();
         Set<String>s=dbo.keySet();
         
         String str=String.join(",", s);
         
        // System.out.println(str);
         
         String attributenames[]=str.split(",");
         String[] modifiedArray = Arrays.copyOfRange(attributenames, 1, attributenames.length);
           
               return modifiedArray;
    }
    
       
}
