package com.mycompany.proyectoluis;

/**
 *
 * @author Javier
 */
public class DiaParcialDTO {

    private boolean id;
    private boolean diurno;
    private boolean nocturno;

    public DiaParcialDTO() {
    }

    public DiaParcialDTO(boolean id, boolean diurno, boolean nocturno) {
        this.id = id;
        this.diurno = diurno;
        this.nocturno = nocturno;
    }

    public boolean isId() {
        return id;
    }

    public void setId(boolean id) {
        this.id = id;
    }

    public boolean isDiurno() {
        return diurno;
    }

    public void setDiurno(boolean diurno) {
        this.diurno = diurno;
    }

    public boolean isNocturno() {
        return nocturno;
    }

    public void setNocturno(boolean nocturno) {
        this.nocturno = nocturno;
    }

}
