/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

import java.io.Serializable;

/**
 *
 * @author Emiliano
 */
public class CustomException extends Exception implements Serializable{
    private static final long serialVersionUID = 1L;
    public CustomException(){
        super();
    }
    public CustomException(String msg){
        super(msg);
    }
    public CustomException(String msg,Exception e){
        super(msg,e);
    }
}
