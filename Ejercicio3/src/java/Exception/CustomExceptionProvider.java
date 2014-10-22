/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
/**
 *
 * @author Emiliano
 */
@Provider
public class CustomExceptionProvider implements ExceptionMapper<CustomException>{
    @Override
    public Response toResponse(CustomException exception){
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity(exception.getMessage()).build(); 
    }
}
