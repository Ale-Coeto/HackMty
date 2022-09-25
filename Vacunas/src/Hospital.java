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
    int necesidad;
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
        this.necesidad=solicitudes-vacunas;
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
        boolean swap=true;
        for (int i=0; i<aceptablesD.size-1 && swap;i++){
            swap=false;
            for (int j=0;j<aceptablesD.size-1-i;j++){
                if(aceptablesD.get[j].compareTo(aceptablesD.get[j+1])>0){
                    double temp=aceptablesD.get[j];
                    aceptablesD.get[j]=aceptablesD.get[j+1];
                    aceptablesD.get[j+1]=temp;

                    Object temp2=aceptablesD.get[j];
                    aceptablesH.get[j]=aceptablesH.get[j];
                    aceptablesH.get[j+1]=temp2;
                    swap=true;
                }
            }
        }
        return null;
    }
    public static ArrayList<Hospital> DonacionVacunas(ArrayList<Hospital> aceptablesH, ArrayList<Double> aceptablesD){
        ArrayList<Hospital> HospitalesQDonaron=new ArrayList<>();
        int CantidadDonacion=0;
        for (int i=0;i<aceptablesH.size;i++){
            CantidadDonacion=aceptablesH.get[i].vacunas-aceptablesH.get[i].colchon+CantidadDonacion;
            aceptablesH.get[i].vacunas=aceptablesH.get[i].colchon;
            aceptablesH.get[i].colchon=aceptablesH.get[i].vacunas*1.2;
            HospitalesQDonaron.add(aceptablesH.get[i]);
            if(CantidadDonacion>=this.necesidad){
                System.out.println("Se obtuvo el numero esperado ");
                
                break;
            }
        }
        if(CantidadDonacion<this.necesidad){
            System.out.println("No hay suficientes vacunas en los hospitales de la zona.");
        }
        System.out.println("Estos son los hospitales que donaron: ")
        return HospitalesQDonaron;
    } 
    

}