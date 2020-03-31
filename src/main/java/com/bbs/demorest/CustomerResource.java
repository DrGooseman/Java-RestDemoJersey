package com.bbs.demorest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("customers")
public class CustomerResource {
	
	private Repository repo = new Repository();
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomers() {
    
        return repo.getCustomers();
    }
    
    @GET
    @Path("customer/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@PathParam("id") int id) {
        return repo.getCustomer(id);
    }
    
    @POST
    @Path("customer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer createCustomer(Customer cust) {
    	System.out.println(cust);
         repo.createCustomer(cust);
         return cust;
    }
}


