/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Agenda;

/**
 *
 * @author ad
 */
public class AgendaDAO {

    public ArrayList<Agenda> buscarAgendaAberta() {

        ArrayList<Agenda> lista = new ArrayList<Agenda>();

        Agenda agenda = null;

        try {
            Connection conexao = Conexao.abreConexao();

            String queryBuscar = "SELECT * FROM tb_petsoftware_agenda_atendimento";
            PreparedStatement pst = conexao.prepareStatement(queryBuscar);            
            
            ResultSet rst = pst.executeQuery();
            

            while (rst.next()) {

                agenda = new Agenda();

                agenda.setId(rst.getInt(1));
                agenda.setDataInicio(rst.getDate(3));
                agenda.setDataFim(rst.getDate(2));
                agenda.setDescricao(rst.getString(4));
                agenda.setDiaTodo(rst.getBoolean(5));
                agenda.setExecutante(rst.getString(6));
                agenda.setPrioridadeAgenda(rst.getString(7));
                agenda.setIdCliente(rst.getInt(8));

                lista.add(agenda);
            }

            conexao.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return lista;
    }

    public Agenda buscarAgendaPorLogin(Agenda agenda) {                      
               
        try {
            Connection conexao = Conexao.abreConexao();

            String queryBuscar = "SELECT * FROM tb_petsoftware_agenda_atendimento WHERE pk_cliente = ?";

            PreparedStatement pst = conexao.prepareStatement(queryBuscar);
            pst.setInt(1, agenda.getIdCliente());
            ResultSet rst = pst.executeQuery();

            while (rst.next()) {

             agenda = new Agenda();

                agenda.setId(rst.getInt(1));
                agenda.setDataFim(rst.getDate(2));
                agenda.setDataInicio(rst.getDate(3));
                agenda.setDescricao(rst.getString(4));
                agenda.setDiaTodo(rst.getBoolean(5));
                agenda.setExecutante(rst.getString(6));
                agenda.setPrioridadeAgenda(rst.getString(7));
                agenda.setIdCliente(rst.getInt(8));             

            } 

            conexao.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return agenda;
    }
}
/*

 String queryBuscar = "SELECT \n"
                    + "agenda.ID_AGENDA, agenda.DT_INICIO_AGENDAMENTO, agenda.DT_FIM_AGENDAMENTO, agenda.DE_EXECUTANTE,\n"
                    + "cliente.ID_CLIENTE, cliente.DE_NOME \n"
                    + "FROM \n"
                    + "tb_petsoftware_agenda_atendimento AS agenda\n"
                    + "INNER JOIN \n"
                    + "tb_petsoftware_cliente AS cliente \n"
                    + "ON \n"
                    + "cliente.ID_CLIENTE = agenda.pk_cliente WHERE pk_cliente = ?";
*/