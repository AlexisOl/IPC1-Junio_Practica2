import java.util.*;
public class Practica2 {

    Scanner lector = new Scanner(System.in);
    /**
     * Variables de uso
     */
    
    int contadorPeliculas=0;
    int contadorClientes=0;
    int inicioMenu=0;
    static int numeroT=0;
    int idCLienteTemporal =0;
    int contadorPrestamo=0;
    int contadorDevolucion=0;
      int idPeliculaTemporal =0;
    
    /** 
     Ingreso de variables
     del objeto cliente
     */
    String[] nombreClientes = new String[30];
    int [] idClientes = new int[30];
    int [] telefonoClientes = new int [30];
    boolean [] peliculaPrestada = new boolean[30];
    int idClienteTemporal=0;
    
   /**
    *ingreso de variblaes del tipo peliculas 
    */
    int [] idPeliculas = new int[30];
    String [] nombrePelicula = new String [30];
    int [] añoPelicula = new int [30];
    String [] categoriaPelicula = new String [30];
    boolean [] disponiblePelicula = new boolean [30];
    String [] ordenamientoCategoria = new String[30];
    String [] ordenPeliculas = new String[30];
    int [] ordendePeliculasSolicitadas = new int [3000];
    /**
     * Ingreso de variables de prestamoPelicula
     */
    int [] idPelicula = new int [3000];
    int [] idCliente = new int [3000];
    int [] diasPrestamo = new int [3000];
    int contadorpeliculasPrestadas=0;
    int [] registrodeCompras = new int [3000];
    int [] contadorPrestadas = new int [30];
   
    String[] ordenPeliculasPrestadas= new String[3000];
    String[] peliculassegunGenero = new String[30];
    int contadorPeliculasGenero=0;
    
    public static void main(String[] args) {
        Practica2 inicio = new Practica2();
    }
    
    public Practica2(){
        mostrarInterfaz();
    }
    
      //--------------------------------------------------------
    // Metodo de mustra de interfaz 
    
    public void mostrarInterfaz(){
        while (inicioMenu==0){
        System.out.print("Bievenido a Memorabilia, escoga una opcion:\n");
        System.out.println("_____________________________");
        System.out.println("|1 - Prestamo de peliculas   |");
        System.out.println("|2 - Devolucion de peliculas |");
        System.out.println("|3 - Mostrar las peliculas   |");
        System.out.println("|4 - ingreso de peliculas    |");
        System.out.println("|5 - ordenar las peliculas   |");
        System.out.println("|6 - ingresar clientes nuevos|");
        System.out.println("|7 - Mostrar clientes        |");
        System.out.println("|8 - Reportes                |");
        System.out.println("|9 - salir                   |");
        System.out.println("_____________________________");
        
        int seleccion = Integer.valueOf(lector.nextLine());
        if (seleccion > 9 || seleccion < 1){
            System.out.println("No existe esa opcion, intente de nuevo");
            inicioMenu=0;
        } else {
        inicioMenu=1;
        switch(seleccion){
            case 1: prestamo();
				break;
            case 2: devolucionPeliculas();
				//regreso = true;
				break;
            case 3: mostrarPeliculas();
				break;
            case 4: ingresoPeliculas();
				break;
            case 5: orden();
				break;
            case 6: ingresoClientes();
				break;
            case 7: mostrarClientes();
				break;
            case 8: inicioMenu=5;
                    InterfazReportes() ;
		//		break;
            case 9: System.out.println("Adios, regresa pronto!!");
				break;
        }      
        
        }
        
        }
    }
    
    public void mostrarPrestamoPeliculas(){
        System.out.println("");
       int busqueda = Integer.valueOf(lector.nextLine());
     
        System.out.println(buscarIndicePelicula(busqueda));
    }
        //--------------------------------------------------------
    // Metodo de busqueda de indice pelicula
    
    public void buscarIndicePeliculasGenero(String Caracter){
        int [] posP= new int [30];
        String [] peli = new String[30];
        int pos =-1;
        for (int i = 0; i < contadorPeliculas; i++) {
            if(categoriaPelicula[i].equalsIgnoreCase(Caracter)){
                pos =i;
                contadorPeliculasGenero++;
                posP[i]=pos;
                peli[i]=nombrePelicula[i];
                System.out.println(peli[i]);
            }
        }
        
    }
     //--------------------------------------------------------
    // Metodo de busqueda de indice pelicula
    
    public int buscarIndicePelicula(int numero){
        int pos =-1;
        for (int i = 0; i < contadorPeliculas; i++) {
            if(idPeliculas[i]==numero){
                pos =i;
            }
        }
        
     return pos;   
    }
      //--------------------------------------------------------
    // Metodo de busqueda de indice cliente
    
    public int buscarIndiceClientes(int numero){
        int pos =-1;
        for (int i = 0; i < contadorClientes; i++) {
            if(idClientes[i]==numero){
                pos =i;
            }
        }
        
     return pos;   
    }
       //--------------------------------------------------------
    // Metodo de busqueda de indice cliente
    
    public int buscarIndiceCompras(int numero){
        int pos =-1;
        for (int i = 0; i < contadorpeliculasPrestadas; i++) {
            if(registrodeCompras[i]==numero){
                pos =i;
            }
        }
        
     return pos;   
    }
    
       //--------------------------------------------------------
    // Metodo de prestamo de peliculas

    public void prestamo(){
        int indice=0;
        int idclientePrestamo=0;
    while (inicioMenu ==1){
         System.out.println("Ingrese el id del cliente");
            idclientePrestamo = Integer.valueOf(lector.nextLine());
            indice= buscarIndiceClientes(idclientePrestamo);
                if (indice ==-1){
                    System.out.println("No existe ese id");
                    inicioMenu =0;
                    break;
                } else {
                    if (peliculaPrestada[indice]==true){
                    System.out.println("ya tiene una pelicula, intente de nuev0");
                    inicioMenu =0;
                    break;      
                    } else {
                        
                        inicioMenu =3;
                        }
                
                }
    }
                while (inicioMenu ==3){
                System.out.println("Seleccione la pelicula que desea");
                  for (int i = 0; i < contadorPeliculas; i++) {
                      System.out.println(idPeliculas[i]+" - "+nombrePelicula[i]+",  "+ mostrarDisponibilidad());
                   }
                   int opcion = Integer.valueOf(lector.nextLine());
                    if (buscarIndicePelicula(opcion)!= -1){
                        if ((disponiblePelicula[buscarIndicePelicula(opcion)])==true){
             //inicioMenu =0;
                            while (inicioMenu ==3){
                                idPelicula[contadorpeliculasPrestadas]  =opcion;
                                disponiblePelicula[buscarIndicePelicula(opcion)]= false;
                                peliculaPrestada[indice]=true;
                                idCliente[contadorpeliculasPrestadas]=idclientePrestamo;
                                 int contadorPeliPrestada=0;
                                for (int i = 0; i < contadorPeliculas; i++) {
                                    
                                
                                    if (idPelicula[contadorpeliculasPrestadas]==idPelicula[i]){
                                        
                                        contadorPeliPrestada++;
                                        contadorPrestadas[buscarIndicePelicula(opcion)]=contadorPeliPrestada;
                                       
                                    }
                                    System.out.println(contadorPrestadas[i]);
                                }
                                        
                                inicioMenu=2;
                //mostrarInterfaz();
              
                            }
                        } else {
                            System.out.println("Esta pelicula ya no esta disponible");
                            inicioMenu =0;
                            break;
                        }
                    } else {
                        System.out.println("El usuario no existe");
                        inicioMenu =0;
                        break;
                    }
                }
                while (inicioMenu ==2){
                  System.out.println("Ingrese la cantidad de dias del prestamo");
                   int diasPrestamos = Integer.valueOf(lector.nextLine());
                   diasPrestamo[contadorpeliculasPrestadas]=diasPrestamos;
                  registrodeCompras[contadorpeliculasPrestadas]=contadorpeliculasPrestadas;
                  System.out.println("su registro de compra es: " +contadorpeliculasPrestadas);
       //contadorPrestamo++;
                  contadorpeliculasPrestadas++;
            
                   System.out.println("Prestamo exitoso");
                    inicioMenu=4;
                }
    
    
    inicioMenu=0;
    mostrarInterfaz();
    
    
    }
      //--------------------------------------------------------
    // Metodo de devolucion de peliculas 
    
    public void devolucionPeliculas(){
        System.out.println("Escriba su registro de compras");
        int opcion = Integer.valueOf(lector.nextLine());
        if(buscarIndiceCompras(opcion)==-1){
             System.out.println("No existe esta opcion, ingrese nuevamente");
        } else {
            System.out.println("Su id de cliente es: "+idCliente[buscarIndiceCompras(opcion)]);
            System.out.println("El id de la pelicula es: "+idPelicula[buscarIndiceCompras(opcion)]);
            System.out.println("Desea devolverla, escriba 1, para confirmar");
            int seleccion = Integer.valueOf(lector.nextLine());
            if (seleccion ==1){
                peliculaPrestada[buscarIndiceClientes(idCliente[buscarIndiceCompras(opcion)])]=false;
                disponiblePelicula[buscarIndicePelicula(idPelicula[buscarIndiceCompras(opcion)])]=true;
                inicioMenu = 0;
                System.out.println("Se efectuo la devolucion");
                
            } else {
                System.out.println("No se efectuo la devolucion");
            }
        }
        
    }
    
    
    public String mostrarDisponibilidad(){
        String mensaje="a";
        for (int i = 0; i < contadorPeliculas; i++) {
            if (disponiblePelicula[i]==false){
                mensaje=("La pelicula no esta disponible");
            } else {
                mensaje=("La pelicula si esta disponible");
            } 
        }
        return mensaje;
    }
      //--------------------------------------------------------
    // Metodo de mustra de peliculas
    
    
    public void mostrarPeliculas(){
        System.out.println("Las peliculas registradas son:");
        for (int i = 0; i < contadorPeliculas; i++) {
            System.out.println("El nombre de la pelicula es :"+nombrePelicula[i]);
            System.out.println("El id de la pelicula es: " + idPeliculas[i]);
            System.out.println("El año de la pelicual es:" + añoPelicula[i]);
            System.out.println("La categoria es: "+categoriaPelicula[i]);
             if (disponiblePelicula[i]==false){
                System.out.println("La pelicula no esta disponible");
            } else {
                System.out.println("La pelicula si esta disponible");
            }
        }
      regresodeModulo();

            
        
    }
      //--------------------------------------------------------
    // Metodo de ordenamiento
  
    
    public void orden(){
       Ordenamiento();
       MostrarOrden();
       regresodeModulo();
    }
    public void MostrarOrden(){
     for (int k = 0; k < contadorPeliculas; k++) {
            System.out.println(ordenPeliculas[k]);
    }
    }
    
    public void Ordenamiento(){
        for (int k = 0; k < contadorPeliculas; k++) {
            ordenPeliculas[k]=nombrePelicula[k];
        }
        for (int i = 0; i < contadorPeliculas; i++) {
            for (int j = 0; j < contadorPeliculas && i != j; j++) {
                if (ordenPeliculas[i].compareToIgnoreCase(ordenPeliculas[j])<0) {
                String aux = ordenPeliculas[i];
                ordenPeliculas[i]=ordenPeliculas[j];
                ordenPeliculas[j]=aux;
                }
            }
        }
        
    }
       //--------------------------------------------------------
    // Metodo para regresar al modulo principal

      //--------------------------------------------------------
    // Metodo para regresar al modulo principal
    public void regresodeModulo(){
        while(inicioMenu==1){
        System.out.println("Presione 1 para regresar");
        int seleccion = Integer.valueOf(lector.nextLine());
            if (seleccion ==1){
                inicioMenu = 0;
            } else {
                System.out.println("No existe esta opcion intente nuevamente");
            }
        }
    }
    

    
      //--------------------------------------------------------
    // Metodo de ingreso de clientes
    public void ingresoClientes(){
        if (contadorClientes>30) {
            System.out.println("No puede ingresar mas");   
            mostrarInterfaz();
        } else {
        System.out.println("Bienvenido ingrese su nombre");
        String nombre = lector.nextLine();
        nombreClientes[contadorClientes] = nombre;
        while(inicioMenu==1){
            System.out.println("ingrese el id del cliente");
              if (contadorClientes<1){
                   idClienteTemporal = Integer.valueOf(lector.nextLine());

                //  idClientes[contadorClientes]= idClienteTemporal;
                  inicioMenu=0;
              }else{
                 idClienteTemporal = Integer.valueOf(lector.nextLine());
                  for (int i = 0; i <=contadorClientes; i++) {
                      if (idClientes[i]==idClienteTemporal) {
                       System.out.println("No puede ingresar el mismo id");  
                       inicioMenu=1;
                       break;
                      } else {
                            inicioMenu=0;
                      }
                  }
                  
              }
        } 
        idClientes[contadorClientes] = idClienteTemporal;

            System.out.println(idClientes[contadorClientes]);
        System.out.println("Ingreso de telefono");
       // int numeroTel = Integer.valueOf(lector.nextLine());
        //    System.out.println(numeroTel);
        telefonoClientes[contadorClientes]=  Integer.valueOf(lector.nextLine());;
            
        peliculaPrestada[contadorClientes]= false;
        contadorClientes++;
        contadorPrestamo++;
        System.out.println("Cliente ingresado");
        inicioMenu = 0;
        }
        mostrarInterfaz();
    }
    
    
    
      //--------------------------------------------------------
    // Metodo de ingreso de peliculas
    public void ingresoPeliculas(){
        if (contadorPeliculas>30){
            System.out.println("No puede ingresar mas");   
            mostrarInterfaz();
        } else {
        System.out.println("Ingrese el nombre de la pelicula");
        String ingreso = lector.nextLine();
        nombrePelicula[contadorPeliculas]=ingreso;
        while (inicioMenu ==1){
        System.out.println("Ingrese el id de la pelicula");
        if (contadorPeliculas<1){
            idPeliculaTemporal = Integer.valueOf(lector.nextLine());
            idPeliculas[contadorPeliculas]=idPeliculaTemporal;
            inicioMenu=0;
        } else {
         idPeliculaTemporal = Integer.valueOf(lector.nextLine());
            for (int i = 0; i <=contadorPeliculas; i++) {
                     if (idPeliculaTemporal == idPeliculas[i]){
                           System.out.println("No puede ingresar el mismo id");
                           inicioMenu=1;
                           break;
                     } else {
                            inicioMenu=0;
                    }
                }
        }
        }
         idPeliculas[contadorPeliculas]=idPeliculaTemporal;
        System.out.println("ingrese el año de la pelicula");
        int añoP = Integer.valueOf(lector.nextLine());
        añoPelicula[contadorPeliculas] = añoP;
        System.out.println("ingrese categoria de la pelicula");
        String categoriaP = lector.nextLine();
        categoriaPelicula[contadorPeliculas]=categoriaP;
        disponiblePelicula[contadorPeliculas]=true;
        contadorPeliculas++;
        System.out.println("Pelicula agregada");
        inicioMenu=0;
        }
        mostrarInterfaz();
    }
    
    
    //--------------------------------------------------------
    // Metodo de mustra de clientes
    public void mostrarClientes(){
        System.out.println("Los clientes registrados son:");
        for (int i = 0; i <contadorClientes ; i++) {
            System.out.println("El nombre del clientes es: "+ nombreClientes[i]);
            System.out.println("El id del cliente es: "+idClientes[i] );
            System.out.println("El telefono del cliente es: "+telefonoClientes[i]);
            if (peliculaPrestada[i]==false){
                System.out.println("El cliente no tiene prestada alguna pelicula");
            } else {
                System.out.println("El cliente si tiene prestada alguna pelicula");
            }
        }
    regresodeModulo();
    }
    
    public void mostrarTelefono(){
        for (int i = 0; i < contadorClientes; i++) {
             System.out.println(telefonoClientes.length);
        }
    }
    
    
    //Reportes---------------------------------------------------------------------------
    
    public void InterfazReportes(){
          while (inicioMenu==5){
        System.out.print("Bievenido a reportes, escoga una opcion:\n");
        System.out.println("_____________________________");
        System.out.println("|1 - cantidad de peliculas por categoria   |");
        System.out.println("|2 - peliculas de una categotria |");
        System.out.println("|3 - peliculas y cantidad de veces que se presta   |");
        System.out.println("|4 - Pelicula mas prestada    |");
        System.out.println("|5 - pelicula menos prestada   |");
        System.out.println("|6 - regresar                  |");
        int seleccion = Integer.valueOf(lector.nextLine());
        if (seleccion > 6 || seleccion < 1){
            System.out.println("No existe esa opcion, intente de nuevo");
            inicioMenu=5;
        } else {
        inicioMenu=4;
        switch(seleccion){
            case 1: CantidaddePeliculasporCategoria();
				break;
            case 2: peliculasporCategorias();
				//regreso = true;
				break;
            case 3: CantidaddePeliculasPrestadas();
				break;
            case 4: peliculaMasprestada();
				break;
            case 5: peliculaMenosprestada();
				break;
            case 6: inicioMenu=0;
                    mostrarInterfaz();
				break;
        }      
        
        }
        
        }
    }
     public void OrdenamientoPeliculasPrestadas(){
         for (int i = 0; i < contadorpeliculasPrestadas; i++) {
             ordenPeliculasPrestadas[i]=nombrePelicula[buscarIndicePelicula(idPelicula[i])];
         }
         for (int i = 0; i < contadorpeliculasPrestadas; i++) {
             for (int j = 0; j < contadorpeliculasPrestadas && i!=j; j++) {
                 if(ordenPeliculasPrestadas[i].compareToIgnoreCase(ordenPeliculasPrestadas[j])<0){
                     String aux = ordenPeliculasPrestadas[i];
                     ordenPeliculasPrestadas[i]=ordenPeliculasPrestadas[j];
                     ordenPeliculasPrestadas[j]=aux;
                 }
             }
         }
     }
     //Ordenamiento de categoria---------------------------------------------------------------------------
     public void OrdenamientoCategoria(){
        for (int k = 0; k < contadorPeliculas; k++) {
            ordenamientoCategoria[k]=categoriaPelicula[k];
        }
        for (int i = 0; i < contadorPeliculas; i++) {
            for (int j = 0; j < contadorPeliculas && i != j; j++) {
                if (ordenamientoCategoria[i].compareToIgnoreCase(ordenamientoCategoria[j])<0) {
                String aux = ordenamientoCategoria[i];
                ordenamientoCategoria[i]=ordenamientoCategoria[j];
                ordenamientoCategoria[j]=aux;
                }
            }
        }
       
    }
       //cantidad de peliculas por categoria---------------------------------------------------------------------------
   
    public void CantidaddePeliculasporCategoria(){
        OrdenamientoCategoria();
        int contadorCat=0;
        int pos=0;
        String aux = ordenamientoCategoria[0];
        for (int i = 0; i < contadorPeliculas; i++) {
            if (ordenamientoCategoria[i].equalsIgnoreCase(aux)){
                contadorCat++;
                if (i ==contadorPeliculas ){
                    System.out.println("La categoria es: " +ordenamientoCategoria[(i)] + " contiene: "+contadorCat+ " peliculas");
                }
            } else {
                if (i== (contadorPeliculas-1)){
                    System.out.println("La categoria es: " +ordenamientoCategoria[(i)] + " contiene: "+contadorCat+ " peliculas");
                } else {
                System.out.println("La categoria es:" +ordenamientoCategoria[(i-1)] + " contiene: "+contadorCat+ " peliculas");
                contadorCat=1;
                pos =i;
                aux=ordenamientoCategoria[i];
                }
            }
            
        }
        System.out.println("La categoria: "+ aux+ " contiene "+ contadorCat + " peliculas");
        inicioMenu=0;
        mostrarInterfaz();
        
    }
    
    int [] cantidad = new int [3000];
     public void CantidaddePeliculas(){
        OrdenamientoPeliculasPrestadas();
        int contadorP =0;
        String aux = ordenPeliculasPrestadas[0];
        for (int i = 0; i < contadorpeliculasPrestadas; i++) {
            if (ordenPeliculasPrestadas[i].equalsIgnoreCase(aux)) {
                contadorP++;
              
                
            } else {
                    cantidad[i]=contadorP;
                    contadorP=1;
                    aux = ordenPeliculasPrestadas[i];
            }
        }
         cantidad[contadorpeliculasPrestadas]=contadorP;
        
    }
    public void CantidaddePeliculasPrestadas(){
        OrdenamientoPeliculasPrestadas();
        int contadorP =0;
        String aux = ordenPeliculasPrestadas[0];
        for (int i = 0; i < contadorpeliculasPrestadas; i++) {
            if (ordenPeliculasPrestadas[i].equalsIgnoreCase(aux)) {
                contadorP++;
              
                
            } else {
                     System.out.println("La pelicula es: " +ordenPeliculasPrestadas[(i-1)] + " prestada: "+contadorP+ " prestada");
                    contadorP=1;
                    aux = ordenPeliculasPrestadas[i];
            }
        }
        System.out.println("La pelicula es: "+aux+" prestada: "+ contadorP+" prestada");
        
    }
    //Metodo de peliculas por categoria---------------------------------------------------------------------------

    public void peliculasporCategorias(){
        System.out.println("Ingrese la categoria a buscar");
        String opcion = lector.nextLine();
        buscarIndicePeliculasGenero(opcion);
     
        inicioMenu=0;
        mostrarInterfaz();        
    }
    
    // Meotodo para mostrar la pelicula mas prestada
    public void peliculaMasprestada(){
        int indice = buscarIndicePelicula(ValorMarepetido());
        System.out.println("La pelicula mas prestada y sus datos son:");
            System.out.println("El nombre de la pelicula es :"+nombrePelicula[indice]);
            System.out.println("El id de la pelicula es: " + idPeliculas[indice]);
            System.out.println("El año de la pelicual es:" + añoPelicula[indice]);
            System.out.println("La categoria es: "+categoriaPelicula[indice]);
             if (disponiblePelicula[indice]==false){
                System.out.println("La pelicula no esta disponible");
            } else {
                System.out.println("La pelicula si esta disponible");
            }
              inicioMenu=0;
                    mostrarInterfaz();
    }
    public void peliculaMenosprestada(){
        
        menosRepetido(idPelicula,contadorpeliculasPrestadas);
        System.out.println("El nombre de la pelicula es :"+nombrePelicula[buscarIndicePelicula(menosRepetido(idPelicula,contadorpeliculasPrestadas))]);
            System.out.println("El id de la pelicula es: " + idPeliculas[buscarIndicePelicula(menosRepetido(idPelicula,contadorpeliculasPrestadas))]);
            System.out.println("El año de la pelicual es:" + añoPelicula[buscarIndicePelicula(menosRepetido(idPelicula,contadorpeliculasPrestadas))]);
            System.out.println("La categoria es: "+categoriaPelicula[buscarIndicePelicula(menosRepetido(idPelicula,contadorpeliculasPrestadas))]);
             if (disponiblePelicula[buscarIndicePelicula(menosRepetido(idPelicula,contadorpeliculasPrestadas))]==false){
                System.out.println("La pelicula no esta disponible");
            } else {
                System.out.println("La pelicula si esta disponible");
            }
        regresodeModulo();
    }
    // Metodo para determinar el valor mas repetido;
      public int ValorMarepetido(){
          int elemento=0;
          int contador=0;
          for (int i = 0; i < contadorpeliculasPrestadas; i++) {
              int ElemeTempo =idPelicula[i];
              int contaTempo =0;
              for (int j = 0; j < contadorpeliculasPrestadas; j++) {
                  if(idPelicula[j]==ElemeTempo)
                      contaTempo++;
                  if (contaTempo>contador) {
                      elemento=ElemeTempo;
                      contador=contaTempo;
                  }
              }
              
          }
          return elemento;
      }
      
     
        public int Valormenosrepetido(){
          int elemento=0;
          int contador=0;
          for (int i = 0; i < contadorpeliculasPrestadas; i++) {
              int ElemeTempo =idPelicula[i];
              int contaTempo =0;
              for (int j = 0; j < contadorpeliculasPrestadas; j++) {
                  if(idPelicula[j]==ElemeTempo)
                      contaTempo++;
                  if (contaTempo<contador) {
                      elemento=ElemeTempo;
                      contador=contaTempo;
                  }
              }
              
          }
          return elemento;
      }
      

        public int menosRepetido(int arr[], int n){
           // Sort the array
        Arrays.sort(arr);
     
        // find the min frequency using
        // linear traversal
        int min_count = n+1, res = -1;
        int curr_count = 1;
         
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1])
                curr_count++;
            else {
                if (curr_count < min_count) {
                    min_count = curr_count;
                    res = arr[i - 1];
                }
                 
                curr_count = 1;
            }
        }
     
        // If last element is least frequent
        if (curr_count < min_count)
        {
            min_count = curr_count;
            res = arr[n - 1];
        }
        return res;
        }
    /* 
     public void reportePeliculasPrestadas(){
         int contadorM =0;
         int aux=0;
         OrdenamientoSolicitudPrestadas();
        aux = ordendePeliculasSolicitadas[0];
         for (int i = 0; i < contadorpeliculasPrestadas; i++) {
             if (aux==ordendePeliculasSolicitadas[i]) {
                 contadorM++;
                 
             } else {
                 System.out.println("La pelicula: "+nombrePelicula[buscarIndicePelicula(aux)] +" se repite"+ contadorM + " veces");
                 contadorM=1;
                 aux = ordendePeliculasSolicitadas[i];
             }
             System.out.println("La pelicula: "+nombrePelicula[buscarIndicePelicula(aux)] +" se repite"+ contadorM + " veces");
         }
         
     }
*/
}
