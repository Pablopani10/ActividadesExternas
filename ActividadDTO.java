
package com.mycompany.proyectoluis;
import java.util.Date;
/**
 *
 * @author Javier
 */
public class ActividadDTO {

private int id;
private String nombre;
private String profesor;
private Date fechaRealizar;
private Date fechaActual;
private int diaP;

    public ActividadDTO() {
    }

    public ActividadDTO(int id, String nombre, String profesor, Date fechaRealizar, Date fechaActual, int diaP) {
        this.id = id;
        this.nombre = nombre;
        this.profesor = profesor;
        this.fechaRealizar = fechaRealizar;
        this.fechaActual = fechaActual;
        this.diaP = diaP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public Date getFechaRealizar() {
        return fechaRealizar;
    }

    public void setFechaRealizar(Date fechaRealizar) {
        this.fechaRealizar = fechaRealizar;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public int getDiaP() {
        return diaP;
    }

    public void setDiaP(int diaP) {
        this.diaP = diaP;
    }



    
}
