
package withoutOptimization;



import mongodboperation.MongoDBInserter;
import java.io.File;
import java.util.ArrayList;
import util.DatasetReader;


public class WithoutOptimizationDBInserter
{
    
    public ArrayList initiateProcess(String path)
    {
        File f=new File(path);
        String fname=f.getName();
        String dbname="datasecurity";
       
        String collectioname=fname.substring(0, fname.indexOf("."))+"_without_Opti_info";
        
      
        ArrayList attributes = new DatasetReader().getAttributeName(path);
        System.out.println("Attributes List is " + attributes+"\n");

       
        
        ArrayList data=new DatasetReader().getDataSetInList(path);
              
          
        long start=System.currentTimeMillis();
        
        new MongoDBInserter().insertList(attributes, data, "admin", "1234", dbname, collectioname);
        
        long end=System.currentTimeMillis();
        long totalwopt=end-start;
        System.out.println("\n\n TOTAL TIME REQUIRED FOR TRANSACTION OF "+data.size()+ " ROWS IS "+totalwopt+" MILLISECONDS");
        
        ArrayList res=new ArrayList();
        res.add(Integer.toString(data.size()));
        res.add(Long.toString(totalwopt));
        
        
        return res;
    }
}
