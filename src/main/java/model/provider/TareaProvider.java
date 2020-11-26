package model.provider;

import db.MySQLConnection;
import entity.Tarea;
import model.dto.TareaDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TareaProvider {

    public void insertTarea(Tarea tarea) {
        MySQLConnection connection = new MySQLConnection();
        String sql = "INSERT INTO tareasJaimeCardona (descripcion,to_do,doing,done,fecha) VALUES ('$descripcion',$to_do,$doing,$done,'$fecha') ";
        sql = sql.replace("$descripcion", tarea.getDescripcion());
        sql = sql.replace("$to_do", ""+tarea.getTo_do());
        sql = sql.replace("$doing", ""+tarea.getDoing());
        sql = sql.replace("$done", ""+tarea.getDone());
        sql = sql.replace("$fecha", tarea.getFecha());
        connection.executeSQL(sql);
    }

    public boolean deleteTarea(int id) {
        MySQLConnection connection = new MySQLConnection();
        String sql = "DELETE FROM tareasJaimeCardona WHERE id="+id;
        return connection.executeSQL(sql);
    }


    public Tarea mapDTO(TareaDTO tareaDTO) {
        Tarea tarea = new Tarea();
        tarea.setDescripcion(tareaDTO.getDescripcion());
        tarea.setTo_do(tareaDTO.getTo_do());
        tarea.setDone(tareaDTO.getDone());
        tarea.setDoing(tareaDTO.getDoing());
        tarea.setFecha(tareaDTO.getFecha());
        return tarea;
    }

    public ArrayList<TareaDTO> getAllTareasToDo() {
        ArrayList<TareaDTO> out = new ArrayList<>();
        MySQLConnection connection = new MySQLConnection();
        String sql = "SELECT id, descripcion, to_do,doing,done,fecha FROM tareasJaimeCardona";
        ResultSet resultSet = connection.query(sql);
        try {
            while(resultSet.next()){
                if(resultSet.getInt(3) == 1) {
                    out.add(new TareaDTO(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getInt(3),
                            resultSet.getInt(4),
                            resultSet.getInt(5),
                            resultSet.getString(6)

                    ));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        connection.disconnect();
        return out;
    }

    public ArrayList<TareaDTO> getAllTareasDoing() {
        ArrayList<TareaDTO> out = new ArrayList<>();
        MySQLConnection connection = new MySQLConnection();
        String sql = "SELECT id, descripcion, to_do,doing,done,fecha FROM tareasJaimeCardona";
        ResultSet resultSet = connection.query(sql);
        try {
            while(resultSet.next()){
                if(resultSet.getInt(4) == 1) {
                    out.add(new TareaDTO(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getInt(3),
                            resultSet.getInt(4),
                            resultSet.getInt(5),
                            resultSet.getString(6)

                    ));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        connection.disconnect();
        return out;
    }

    public ArrayList<TareaDTO> getAllTareasDone() {
        ArrayList<TareaDTO> out = new ArrayList<>();
        MySQLConnection connection = new MySQLConnection();
        String sql = "SELECT id, descripcion, to_do,doing,done,fecha FROM tareasJaimeCardona";
        ResultSet resultSet = connection.query(sql);
        try {
            while(resultSet.next()){
                if(resultSet.getInt(5) == 1) {
                    out.add(new TareaDTO(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getInt(3),
                            resultSet.getInt(4),
                            resultSet.getInt(5),
                            resultSet.getString(6)

                    ));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        connection.disconnect();
        return out;
    }

    public boolean editTarea(TareaDTO tareaDTO) {
        MySQLConnection connection = new MySQLConnection();
        String sql = "UPDATE tareasJaimeCardona set descripcion='$descripcion', to_do=$to_do, doing=$doing, done=$done, fecha='$fecha' WHERE id='$id'";
        sql = sql.replace("$id", ""+tareaDTO.getId());
        sql = sql.replace("$descripcion", tareaDTO.getDescripcion());
        sql = sql.replace("$to_do", ""+tareaDTO.getTo_do());
        sql = sql.replace("$doing", ""+tareaDTO.getDoing());
        sql = sql.replace("$done", ""+tareaDTO.getDone());
        sql = sql.replace("$fecha", ""+tareaDTO.getFecha());
        boolean success = connection.executeSQL(sql);
        return success;
    }
}
