package com.burrsutter.zztop;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * TodoResource
 */
@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {
  @GET
  public List<Todo> getall() {
      return Todo.listAll();
  }
  @POST
  @Transactional
  public Response addOne(Todo item) {
    item.persist();
    return Response.status(Status.CREATED).entity(item).build();
  }

  @DELETE
  @Transactional
  @Path("/{id}")
  public Response deleteOne(@PathParam("id") Long id) {
    Todo entity = Todo.findById(id);
    entity.delete();
    return Response.noContent().build();
  }

  @PATCH
  @Transactional
  @Path("/{id}")
  public Response updateOne(@PathParam("id") Long id, Todo item) {
    Todo entity = Todo.findById(id);
    entity.completed = item.completed;
    entity.id = item.id;
    entity.order = item.order;
    entity.title = item.title;
    return Response.ok(entity).build();
  }

}