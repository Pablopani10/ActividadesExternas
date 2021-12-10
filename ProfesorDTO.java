
package com.mycompany.proyectoluis;

/**
 *
 * @author Javier
 */
public class ProfesorDTO {

private String dni;
private String nrp;
private String nombre;
private String domicilio;
private String telefono;
private String asignatura;

    public ProfesorDTO() {
    }


    public ProfesorDTO(String dni, String nrp, String nombre, String domicilio, String telefono, String asignatura) {
        this.dni = dni;
        this.nrp = nrp;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.asignatura = asignatura;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }


    
}
