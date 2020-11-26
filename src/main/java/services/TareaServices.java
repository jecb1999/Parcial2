package services;

import entity.Tarea;
import model.dto.Response;
import model.dto.TareaDTO;
import model.provider.TareaProvider;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.ArrayList;

@Path("tareas")
@Stateless
public class TareaServices {

    @POST
    @Consumes("application/json")
    @Path("create")
    public Response createTarea(TareaDTO tareaDTO){
        TareaProvider provider = new TareaProvider();
        provider.insertTarea(provider.mapDTO(tareaDTO));
        return new Response("Operacion Exitosa");
    }

    @DELETE
    @Produces("application/json")
    @Path("delete/{id}")
    public Response deleteTarea(@PathParam("id") String id){
        TareaProvider provider = new TareaProvider();
        boolean success = provider.deleteTarea(Integer.parseInt(id));
        if(success) return  new Response("Operacion exitosa");
        else return  new Response("Error");
    }

    @GET
    @Produces("application/json")
    @Path("allToDo")
    public ArrayList<TareaDTO> getAllTareasToDo(){
        TareaProvider provider = new TareaProvider();
        ArrayList<TareaDTO> tareasDTO = provider.getAllTareasToDo();
        return tareasDTO;
    }

    @GET
    @Produces("application/json")
    @Path("allToDoing")
    public ArrayList<TareaDTO> getAllTareasDoing(){
        TareaProvider provider = new TareaProvider();
        ArrayList<TareaDTO> tareasDTO = provider.getAllTareasDoing();
        return tareasDTO;
    }

    @GET
    @Produces("application/json")
    @Path("allToDone")
    public ArrayList<TareaDTO> getAllTareasDone(){
        TareaProvider provider = new TareaProvider();
        ArrayList<TareaDTO> tareasDTO = provider.getAllTareasDone();
        return tareasDTO;
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Path("edit")
    public Response editTarea(TareaDTO tareaDTO){
        TareaProvider provider = new TareaProvider();
        boolean success = provider.editTarea(tareaDTO);
        if(success) return new Response("Operacion Exitosa");
        else return new Response("Operacion Fallida");
    }




}
