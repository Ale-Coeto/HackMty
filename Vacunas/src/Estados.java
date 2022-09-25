import java.util.ArrayList;

public class Estados{
   
    public Estados(String nombre, String estatus) {
        this.nombreEstado = nombre;
        this.estatus = estatus;
    }

    static ArrayList<Hospital> nombresdeHospitales = new ArrayList<>();
     String estatus;
    String nombreEstado;
    int CantidadQPuedeDonar;

    //Se necesita para checar el estatus del estado, se necesitaria despues del constructor.
    public  String checarEstatus(){
        int CantidadQPuedeDonar=0;
        estatus="Available";
        for(int i=0;i<nombresdeHospitales.size();i++){
            if(nombresdeHospitales.get(i).estatus!="Available"){
                estatus="Unavailable";
                System.out.println("This estate can't donate vaccines.");
                return estatus;
            }
            if(estatus.compareTo("Available")==0){
                CantidadQPuedeDonar = nombresdeHospitales.get(i).vacunas-nombresdeHospitales.get(i).colchon+CantidadQPuedeDonar;
                System.out.println("Esta es la cantidad que puede donar: "+""+CantidadQPuedeDonar);
                return estatus;
        
    }
        }
        
           
    return null;

    }
    //public Estados(String nombre, int vacunas, int solicitudes, String NombreEstado2) {
        //super(nombre, vacunas, solicitudes, NombreEstado2);
        //TODO Auto-generated constructor stub
    //}

    public ArrayList<Hospital> getNombresdeHospitales() {
        return nombresdeHospitales;
    }

    //public void setNombresdeHospitales(ArrayList<Hospital> nombresdeHospitales) {
       // nombresdeHospitales = nombresdeHospitales;
    //}

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getNombreEstado1() {
        return nombreEstado;
    }

    public void setNombreEstado1(String nombreEstado1) {
        nombreEstado = nombreEstado1;
    }

    public int getCantidadQPuedeDonar() {
        return CantidadQPuedeDonar;
    }

    public void setCantidadQPuedeDonar(int cantidadQPuedeDonar) {
        CantidadQPuedeDonar = cantidadQPuedeDonar;
    }
     
}