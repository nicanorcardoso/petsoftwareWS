/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dao.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import model.Usuario;
import static sun.security.jgss.GSSUtil.login;

/**
 * REST Web Service
 *
 * @author ad
 */
@Path("testews")
public class TesteWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TesteWS
     */
    public TesteWS() {
    }

    /**
     * Retrieves representation of an instance of ws.TesteWS
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {        
        return "Teste WS ok";
    }

    @GET
    @Produces("application/json")
    @Path("Usuario/get/{login}")
    public String getUsuario(@PathParam("login") String login) {

        Usuario usr = new Usuario();
        usr.setLogin(login);
        
        UsuarioDAO dao = new UsuarioDAO();
        usr = dao.buscarUsuarioPorLogin(usr);
        //convertendo para Gson
        Gson g = new Gson();
        return g.toJson(usr);

    }

    @GET
    @Produces("application/json")
    @Path("Usuario/list")
    public String listUsuario() {

        List<Usuario> lista;
        
        UsuarioDAO dao = new UsuarioDAO();
        
        lista = dao.buscarTodosUsuarios();

        //convertendo para Gson        
        Gson g = new Gson();
        return g.toJson(lista);

    }

    /**
     * PUT method for updating or creating an instance of TesteWS
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
