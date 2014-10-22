/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv.countrycode;

import com.googlecode.jcsv.reader.CSVEntryFilter;

/**
 *
 * @author Emiliano
 */
public class KeyValueFilter implements CSVEntryFilter<String[]>{

    @Override
    public boolean match(String[] e) {
        return true;
    }
    
}
