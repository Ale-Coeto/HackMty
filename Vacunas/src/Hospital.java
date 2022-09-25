import java.util.ArrayList;
import java.util.Hashtable;

public class Hospital{
    String nombre;
    int colchon;
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
        this.colchon=solicitudes + solicitudes/20;
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

    public int getColchon(){
        return colchon;
    }

    public int getVacunas(){
        return vacunas;
    }

    public int getNecesidad(){
        return necesidad;
    }

    public void setVacunas(int vacunas){
        this.vacunas = vacunas;
    }

    public void setColchon(int colchon){
        this.colchon = colchon;
    }


     public static ArrayList<Hospital> Solicitar(Hospital solicitante){
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
        for (int i=0; i<aceptablesD.size()-1 && swap;i++){
            swap=false;
            for (int j=0;j<aceptablesD.size()-1-i;j++){
                if(aceptablesD.get(j).compareTo(aceptablesD.get(+1))>0){
                    double temp=aceptablesD.get(j);
                    aceptablesD.set(j, aceptablesD.get(j+1));
                    aceptablesD.set(j+1, temp);

                    Hospital temp2=aceptablesH.get(j);
                    aceptablesH.set(j, aceptablesH.get(j+1));
                    aceptablesH.set(j+1, temp2);
                    swap=true;
                }
            }
        }
        ArrayList<Hospital> HospitalesQDonaron = DonacionVacunas(aceptablesH, aceptablesD, solicitante);

        return HospitalesQDonaron;
    }
    public static ArrayList<Hospital> DonacionVacunas(ArrayList<Hospital> aceptablesH, ArrayList<Double> aceptablesD, Hospital solicitate){
        ArrayList<Hospital> HospitalesQDonaron=new ArrayList<>();
        int CantidadDonacion=0;
        for (int i=0;i<aceptablesH.size();i++){
            CantidadDonacion=aceptablesH.get(i).getVacunas()-aceptablesH.get(i).getColchon()+CantidadDonacion;
            aceptablesH.get(i).setVacunas(aceptablesH.get(i).getColchon());
            aceptablesH.get(i).setColchon(aceptablesH.get(i).getVacunas() + aceptablesH.get(i).getVacunas()/20);
            HospitalesQDonaron.add(aceptablesH.get(i));
            if(CantidadDonacion>= solicitate.getNecesidad()){
                System.out.println("Se obtuvo el numero esperado ");
                
                break;
            }
        }
        if(CantidadDonacion<solicitate.getNecesidad()){
            System.out.println("No hay suficientes vacunas en los hospitales de la zona.");
        }
        System.out.println("Estos son los hospitales que donaron: ");
        return HospitalesQDonaron;
    } 
    

}