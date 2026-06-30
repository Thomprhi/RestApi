/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;
 import javax.ws.rs.core.Response;
import ApiExceptions.*;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import service.DataStore;
import javax.ws.rs.*;
import models.*;

/**
 *
 * @author Student
 */
public class ModelResource {
    @POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response createModel(MachineLearningModel model){

    MLWorkspace workspace =
            DataStore.workspaces.get(model.getWorkspaceId());

    if(workspace == null){

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new LinkedWorkspaceNotFoundException("Workspace does not exist"))
                .build();
    }

    DataStore.models.put(model.getId(), model);

    workspace.getModelIds().add(model.getId());

    return Response.status(Response.Status.CREATED)
            .entity(model)
            .build();
}
}
