package com.geekcap.javaworld.jpa.resource;

import com.geekcap.javaworld.jpa.model.User;
import com.geekcap.javaworld.jpa.repository.UserRepository;

import java.util.List;
import java.util.Set;
import java.net.URI;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject UserRepository userRepository;

    @GET
    public Set<User> getAll() {
        return userRepository.listAll();
    }

    @GET
    @Path("{id}")
    public User getById(@PathParam("id") Long id) {
        return userRepository.findById(id);
    }

    @GET
    @Path("name/{name}")
    public User getByName(@PathParam("name") String name) {
        return userRepository.findByName(name);
    }
    
    @GET
    @Path("gallery/{gallery}")
    public List<Art> getByGroup(@PathParam("gallery") String gallery) {
        return ar.findByGallery(gallery);
    }

    @POST
    @Transactional
    public Response create(User user) {
        ar.persist(art);
        if (ar.isPersistent(art)) {
            return Response.status(Status.CREATED).entity(art).build();
        }
        return Response.status(NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response deleteById(@PathParam("id") Long id) {
        // Response response = Response.status(Status.CREATED).entity(art).build();
        boolean deleted = ar.deleteById(id);
        return deleted ? Response.noContent().build() : Response.status(BAD_REQUEST).build();
    }
}