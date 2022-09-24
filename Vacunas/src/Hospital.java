import java.util.ArrayList;
import java.util.Hashtable;

public class Hospital{
    String nombre;
    double colchon;
    int vacunas;
    double x;
    double y;
    int solicitudes;
    String nombreEstado2;
    String estatus;
    //Metodo Constructor
    public Hospital(String nombre,int vacunas,int solicitudes, String NombreEstado2, double x, double y){
        this.nombre=nombre;
        this.colchon=solicitudes*1.2;
        this.vacunas=vacunas;
        //this.coordenadas=coordenadas;
       // this.estado=Estado;
        this.nombreEstado2=NombreEstado2;
        this.x = x;
        this.y = y;
    }

    public String getEstatus(){
        return estatus;
    }

    public double getX (){
        return x;
    }

    public double getY (){
        return y;
    }

    public String getNombre(){
        return nombre;
    }


     public static Hospital Solicitar(Hospital solicitante){
        ArrayList<Hospital> aceptablesH = new ArrayList<>();
        ArrayList<Double> aceptablesD = new ArrayList<>();

        for(int i = 0; i < WindowPrincipal.listaHospitales.size(); i++){
            Hospital opcion = WindowPrincipal.listaHospitales.get(i);
            if (opcion.getEstatus() == "Available"){
                double distancia = Math.sqrt(Math.pow(opcion.getX()-solicitante.getX(), 2) + Math.pow(opcion.getY()-solicitante.getY(), 2));
                aceptablesH.add(opcion);
                aceptablesD.add(distancia);
            }
        }
        return null;
    }
    // public static void main(String[] args) {
    //     Hospital Hospital1=new Hospital("Muguerza",1000,2000,"Nuevo Leon");
    //     System.out.println()
    // }

}