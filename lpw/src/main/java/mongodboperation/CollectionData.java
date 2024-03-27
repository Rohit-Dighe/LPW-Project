/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongodboperation;

import mongodboperation.ReadAttributeNames;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.util.ArrayList;


public class CollectionData {
    
    public ArrayList getCollectiondata(String collname)
    {
       
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("datasecurity");     
        DBCollection coll = db.getCollection(collname);
        DBCursor cursor = coll.find();
        String[] columnNames = new ReadAttributeNames().getAttributename(collname);
        
        
        
        String rowData[] = new String[columnNames.length];
        
        ArrayList collectiondata=new ArrayList();
        
        while (cursor.hasNext()) 
        {
            DBObject obj = cursor.next();  
            ArrayList temp=new ArrayList();
            for (int i = 0; i <columnNames.length; i++) 
            {
                String name=columnNames[i];
                String value=(String) obj.get(name);
                temp.add(value);
            }  
            
            collectiondata.add(temp);
        }
            
         mongoClient.close();
        
        return collectiondata;
    }
    
    
}
