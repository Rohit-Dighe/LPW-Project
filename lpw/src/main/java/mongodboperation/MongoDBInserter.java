/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mongodboperation;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;


public class MongoDBInserter
{
    public void insertList(ArrayList attribute,ArrayList mas,String username,String password,String dbname,String collectionname)
    {
        
        MongoDatabase  database= new Connection().getConnection(username, dbname, password);
        MongoCollection<Document> collection = database.getCollection(collectionname); 
           
     
       Document d=null;
        for (int i = 0; i < mas.size(); i++)
        {
            d=new Document();
            ArrayList row=(ArrayList)mas.get(i);
            for (int j = 0; j < row.size(); j++) 
            {
             String attri=(String)attribute.get(j);
            String value=(String)row.get(j);
            d.append(attri, value);
            }
          
              collection.insertOne(d); 
              
        }
      
      System.out.println("Document inserted successfully");  
      

     
    }
}
