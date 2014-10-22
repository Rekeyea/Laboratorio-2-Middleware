/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv.countrycode;

import com.googlecode.jcsv.reader.CSVEntryParser;

/**
 *
 * @author Emiliano
 */
public class KeyValueEntryParser implements CSVEntryParser<String[]>{

    @Override
    public String[] parseEntry(String... strings) {
        String countryCode = strings[3];
        String countryName = strings[0];
        String[] code = new String[2];
        code[0]=countryCode;
        code[1]=countryName;
        return code;
    }
    
}
