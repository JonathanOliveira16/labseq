package io.github.jonathan.sequence.rest;

import io.github.jonathan.sequence.cache.SequenceService;
import io.github.jonathan.sequence.rest.dto.ResponseError;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/labseq/{n}")
public class LabseqResource {

    private SequenceService sequenceService;

    @Inject
    public LabseqResource(SequenceService sequenceService){
        this.sequenceService = sequenceService;
    }

    @GET
    public Response getValueSequence(@PathParam("n") Integer value){
        if(value < 0){
            ResponseError error = new ResponseError("Invalid value", Response.Status.BAD_REQUEST.getStatusCode());
            return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
        }
        try {
            Integer result = sequenceService.calculatingSequence(value);
            return Response.status(Response.Status.OK).entity(result).build();
        }catch (Exception ex){
            ResponseError error = new ResponseError("Internal error on application, please contact the support team!", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
