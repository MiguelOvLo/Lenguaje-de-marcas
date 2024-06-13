package org.example.modelo;

public class Personajes {
    
    private String id;
    private String nombre;
    private String edad;


    public Personajes(String nombre, String edad) {
        this.nombre = nombre;
        this.edad = edad;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getedad() {
        return edad;
    }


    public void setedad(String edad) {
        this.edad = edad;
    }


    @Override
    public String toString() {
        return "Protas [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]";
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Personajes other = (Personajes) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


    

}
