package model.dto;

public class TareaDTO {
    private int id;
    private String descripcion;
    private int to_do;
    private int doing;
    private int done;
    private String fecha;

    public TareaDTO() {
    }

    public TareaDTO(int id, String descripcion, int to_do, int doing, int done, String fecha) {
        this.id = id;
        this.descripcion = descripcion;
        this.to_do = to_do;
        this.doing = doing;
        this.done = done;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTo_do() {
        return to_do;
    }

    public void setTo_do(int to_do) {
        this.to_do = to_do;
    }

    public int getDoing() {
        return doing;
    }

    public void setDoing(int doing) {
        this.doing = doing;
    }

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
