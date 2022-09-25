public class Estados extends Hospital{
   
    ArrayList<Hospital> nombresdeHospitales;
    String Status;
    String NombreEstado1;
    int CantidadQPuedeDonar;

    //Se necesita para checar el estatus del estado, se necesitaria despues del constructor.
    public static String checarEstatus(){
        CantidadQPuedeDonar=0;
        this.estatus="Available";
        for(int i=0;i<nombresdeHospitales.size;i++){
            if(nombresHospitales.get[i].estatus!="Available"){
                this.estatus="Unavailable";
                System.out.println("This estate can't donate vaccines.");
                return this.estatus;
            }
        }
        if(this.estatus.compareTo("Available")==0){
            CantidadQPuedeDonar=nombresdeHospitales.get[i].vacunas-nombresdeHospitales.get[i].colchon+CantidadQPuedeDonar;
            System.out.println("Esta es la cantidad que puede donar: "+""+CantidadQPuedeDonar);
            return this.estatus;
        }
    }
    public Estados(String nombre, int vacunas, int solicitudes, String NombreEstado2) {
        super(nombre, vacunas, solicitudes, NombreEstado2);
        //TODO Auto-generated constructor stub
    }
     
}