import java.util.ArrayList;
import java.util.Hashtable;

//import org.apache.commons.math3.optim.linear.SolutionCallback;

//Objeto Hospital
public class Hospital{
    //Atributos
    String nombre;
    int colchon;
    int vacunas;
    double x;
    double y;
    int solicitudes;
    String nombreEstado2;
    String estatus;
    int necesidad;
    int donacion;

    //Metodo Constructor
    public Hospital(String nombre,int vacunas,int solicitudes, String NombreEstado2, double x, double y){
        this.nombre = nombre;
        this.colchon = solicitudes + solicitudes/20;
        this.vacunas = vacunas;
        //Solicitudes es de solicitar.
        this.solicitudes = solicitudes;
        this.nombreEstado2 = NombreEstado2;
        this.x = x;
        this.y = y;
        this.necesidad = solicitudes-vacunas;

        setEstatus();
    }


    private void setEstatus() {
        if(vacunas > solicitudes && colchon < vacunas){
            this.estatus = "Available";

        }else {
            this.estatus = "Not Available";
        }
    }


    //Getters
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

    public int getDonacion(){
        return donacion;
    }

    public int setDonacion(){
        return donacion;
    }

    public int getSolicitudes(){
        return solicitudes;
    }


    public static double getDistancia(Hospital hospital1, Hospital hospital2){
        return Math.sqrt(Math.pow(hospital1.getX()-hospital2.getX(), 2) + Math.pow(hospital1.getY()-hospital2.getY(), 2));
         
    }

    //Setters
    public void setVacunas(int vacunas){
        this.vacunas = vacunas;
    }

    public void setColchon(int colchon){
        this.colchon = colchon;
    }

    public void setSolicitudes(int solicitudes){
        this.solicitudes = solicitudes;
        this.necesidad = solicitudes-vacunas;
        setEstatus();
    }

    public void setDonacion(int donacion){
        this.donacion = donacion;
    }
    

    //Método para regresar la lista de los hospitales que pueden donar sus vacunas al solicitante
     public static ArrayList<Hospital> Solicitar(Hospital solicitante){
        ArrayList<Hospital> aceptablesH = new ArrayList<>();
        ArrayList<Double> aceptablesD = new ArrayList<>();

        //Lista de hospitales que pueden donar
        for(int i = 0; i < WindowPrincipal.listaHospitales.size(); i++){
            Hospital opcion = WindowPrincipal.listaHospitales.get(i);
            if (opcion.getEstatus() == "Available"){
                double distancia = getDistancia(opcion, solicitante);
                aceptablesH.add(opcion);
                aceptablesD.add(distancia);
                System.out.println("Available" + opcion.getNombre());
            }
        }

        //Ordenamiento de los hospitales en base a su distancia del solicitante
        boolean swap=true;
        for (int i=0; i<aceptablesD.size()-1 && swap;i++){
            swap=false;
            for (int j=0;j<aceptablesD.size()-1-i;j++){
                if(aceptablesD.get(j).compareTo(aceptablesD.get(j+1))>0){
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

    
    //Método para retornar los hospitales que pueden donar y mantener su colchón

    public static ArrayList<Hospital> DonacionVacunas(ArrayList<Hospital> aceptablesH, ArrayList<Double> aceptablesD, Hospital solicitante){
        ArrayList<Hospital> HospitalesQDonaron=new ArrayList<>();
        int CantidadDonacion = 0;
        for (int i=0;i<aceptablesH.size();i++){
           // aceptablesH.get(i).setDonacion(aceptablesH.get(i).getVacunas()-aceptablesH.get(i).getColchon());
            int donado = aceptablesH.get(i).getVacunas()-aceptablesH.get(i).getColchon();
            aceptablesH.get(i).setDonacion(donado);
            
            CantidadDonacion += donado;
            System.out.println("solic " + solicitante.getSolicitudes() + " nece " + solicitante.getNecesidad());
            System.out.println("---Donado " + donado + " n " + CantidadDonacion);

            aceptablesH.get(i).setVacunas(aceptablesH.get(i).getColchon());
            //aceptablesH.get(i).setColchon(aceptablesH.get(i).getVacunas() + aceptablesH.get(i).getVacunas()/20);
            HospitalesQDonaron.add(aceptablesH.get(i));

            if(CantidadDonacion >= solicitante.getNecesidad()){
                System.out.println("Se obtuvo el numero esperado ");
                return HospitalesQDonaron;
                //break;
            }
        }

        if(CantidadDonacion < solicitante.getNecesidad()){
            System.out.println("No hay suficientes vacunas en los hospitales de la zona.");
            
            WindowPrincipal.alert();
            return HospitalesQDonaron;

           // System.out.println("Estos son los hospitales que donaron: " + HospitalesQDonaron.get(0).getNombre());
            //return HospitalesQDonaron;
    }
    return null;
}
       
    

    

}