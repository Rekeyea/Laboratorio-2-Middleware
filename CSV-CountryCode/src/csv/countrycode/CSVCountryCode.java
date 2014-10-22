/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv.countrycode;
import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.sql.*;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author Emiliano
 */
public class CSVCountryCode {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, SQLException{
        // TODO code application logic here
        HashMap<String,String> hash = new HashMap();
        String nameOfFile = "ISO3166-Alpha3.txt";
        Reader reader = new FileReader(nameOfFile);
        KeyValueFilter kvp = new KeyValueFilter();
        KeyValueEntryParser kve = new KeyValueEntryParser();
        CSVReaderBuilder<String[]> builder = new CSVReaderBuilder<String[]>(reader).strategy(CSVStrategy.UK_DEFAULT).entryFilter(kvp).entryParser(kve);
        CSVReader<String[]> csvReader = builder.build();
        
        
        List<String[]> data = csvReader.readAll();
        for (String[] tokens : data) {
            hash.put(tokens[0], tokens[1]);
        }
        
        //Ahora guardo en base de datos
        Connection con = null;
        PreparedStatement st = null;
        String url = "jdbc:mysql://localhost:3306/ejercicio3";
        String user = "root";
        String pass = "root";
        String query = "INSERT INTO codigopais VALUES (?,?)";
        try{
            con = DriverManager.getConnection(url,user,pass);
            con.setAutoCommit(false);
            st = con.prepareStatement(query);
            Set<Entry<String,String>> entry = hash.entrySet();
            int i = 1;
            for(Entry<String,String> e : entry){
                //System.out.println(i);
                //i++;
                //System.out.println(e.getKey());
                //System.out.println(e.getValue());
                st.setString(1, e.getKey());
                st.setString(2, e.getValue());
                st.executeUpdate();
            }
            con.commit();
            con.setAutoCommit(true);
            System.out.println("Termino ... ");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            con.rollback();
        }finally{
            con.close();
        }
    }
    
}
