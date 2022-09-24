public class Hospital{
    String nombre;
    double colchon;
    int vacunas;
    //double [] coordenadas;
    int solicitudes;
    String NombreEstado;
    //Metodo Constructor
    public Hospital(String nombre,int vacunas,int solicitudes, String NombreEstado ){
        this.nombre=nombre;
        this.colchon=vacunas*1.2;
        this.vacunas=vacunas;
        //this.coordenadas=coordenadas;
        this.NombreEstado=NombreEstado;
    }
    public static String Solicitar(){

    }
    public static void main(String[] args) {
        Hospital Hospital1=new Hospital("Muguerza",1000,2000,"Nuevo Leon");
        System.out.println()
    }

}