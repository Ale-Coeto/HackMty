public class Hospital{
    String nombre;
    double colchon;
    int vacunas;
    //double [] coordenadas;
    int solicitudes;
    String nombreEstado2;
    String estado;
    //Metodo Constructor
    public Hospital(String nombre,int vacunas,int solicitudes, String NombreEstado2 ){
        this.nombre=nombre;
        this.colchon=solicitudes*1.2;
        this.vacunas=vacunas;
        //this.coordenadas=coordenadas;
       // this.estado=Estado;
        this.nombreEstado2=NombreEstado2;
    }
    // public static String Solicitar(){

    // }
    // public static void main(String[] args) {
    //     Hospital Hospital1=new Hospital("Muguerza",1000,2000,"Nuevo Leon");
    //     System.out.println()
    // }

}