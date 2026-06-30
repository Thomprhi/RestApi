/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ApiExceptions.*;
import models.MLWorkspace;
import service.DataStore;


@Path("/workspaces")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WorkspaceResource {

    // GET all workspaces
    @GET
    public Response getAllWorkspaces() {
        return Response.ok(DataStore.workspaces.values()).build();
    }

    // POST create workspace
    @POST
    public Response createWorkspace(MLWorkspace workspace) {

        if (DataStore.workspaces.containsKey(workspace.getId())) {
            return Response.status(Response.Status.CONFLICT)
                   .entity(new ApiError("Workspace already exists"))
                  .build();
        }

        DataStore.workspaces.put(workspace.getId(), workspace);

        return Response.status(Response.Status.CREATED)
                .entity(workspace)
                .build();
    }

    // GET workspace by ID
    @GET
    @Path("/{id}")
    public Response getWorkspace(@PathParam("id") String id) {

        MLWorkspace workspace = DataStore.workspaces.get(id);

        if (workspace == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new LinkedWorkspaceNotFoundException("Workspace not found"))
                    .build();
        }

        return Response.ok(workspace).build();
    }

    // DELETE workspace
    @DELETE
    @Path("/{id}")
    public Response deleteWorkspace(@PathParam("id") String id) {

        MLWorkspace workspace = DataStore.workspaces.get(id);

        if (workspace == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new LinkedWorkspaceNotFoundException("Workspace not found"))
                    .build();
        }

        if (!workspace.getModelIds().isEmpty()) {
            return Response.status(Response.Status.CONFLICT)
                    .entity("Workspace cannot be deleted because it is not empty")
                    .build();
        }

        DataStore.workspaces.remove(id);

        return Response.ok("Workspace deleted successfully").build();
    }
}

