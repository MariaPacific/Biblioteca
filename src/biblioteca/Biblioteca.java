
package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;


public class Biblioteca {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[40m";

    static class NodoLibro{
        String id;
        String nombre;
        String autor;
        NodoLibro izquierdo, derecho;
        
        
        public NodoLibro(String id, String nombre, String autor) {
            this.id = id;
            this.nombre = nombre;
            this.autor = autor; 
            this.izquierdo = this.derecho = null;
        }
    }
    static class NodoUsuario{
        int cedula;
        String nombre;
        String apellidos;
        NodoUsuario izquierdo, derecho;
        
        public NodoUsuario(int cedula, String nombre, String apellidos) {
            this.cedula = cedula;
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.izquierdo = this.derecho = null;
        }
    } 
    
    public static void main(String[] args) {
        
        NodoLibro raizLibros = null;
        NodoUsuario raizUsuarios = null; 
        ArrayList<NodoLibro> librosPrestados = new ArrayList<>();
        
        Scanner entrada = new Scanner(System.in);
        
        int opcion; 
        do{
            System.out.println(ANSI_BLUE + "=============================================" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "    MARIA FERNANDA CASTILLO CC: 1003526557   " + ANSI_RESET);
            System.out.println(ANSI_BLUE + "=============================================" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "=============================================" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "       SISTEMA DE GESTION DE BIBLIOTECA      " + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "=============================================" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "1. Menu de Libro" + ANSI_RESET);
            System.out.println(ANSI_RED + "2. Menu de Usuarios" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "3. Prestar Libro" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "4. Devolver Libro" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "5. Listar Libros Prestados" + ANSI_RESET);
            System.out.println(ANSI_BLUE+ "6. Listar Libros Disponible" + ANSI_RESET);
            System.out.println(ANSI_RED + "7. Salir" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "Seleccione una opcion: " + ANSI_RESET);
             
            opcion = entrada.nextInt();
               
            switch(opcion){
                case 1:
                    int opcionLibros;
                    do{
                        System.out.println(ANSI_RED + "===== Menu de Libros =====" + ANSI_RESET);
                        System.out.println(ANSI_BLUE + "1. Agregar Libro" + ANSI_RESET);
                        System.out.println(ANSI_BLUE + "2. Eliminar Libro" + ANSI_RESET);
                        System.out.println(ANSI_BLUE + "3. Listar Libros" + ANSI_RESET);
                        System.out.println(ANSI_BLUE + "4. volver al menu Principal" + ANSI_RESET);
                        opcionLibros = entrada.nextInt();
                        entrada.nextLine();
                        if(opcionLibros ==1){
                            System.out.println(ANSI_BLUE + "Ingresa el ID del libros: " + ANSI_RESET);
                            String id = entrada.nextLine();
                            if(buscarLibro(raizLibros,id)){
                                System.out.println(ANSI_BLUE + "El libro con ID "+id+" ya existe" + ANSI_RESET);
                        }else{
                            System.out.println(ANSI_BLUE + "Ingrese el nombre del libro: " + ANSI_RESET);
                            String nombre = entrada.nextLine();
                            System.out.println(ANSI_BLUE + "Ingrese el autor del libro: " + ANSI_RESET);
                            String autor = entrada.nextLine();
                            NodoLibro nuevoLibro = new NodoLibro(id,nombre, autor);
                            raizLibros = agregarLibro(raizLibros, nuevoLibro);
                            System.out.println(ANSI_BLUE + "Libro Agregado Exitosamente!!!" + ANSI_RESET);
                        }
                    }else if( opcionLibros == 2){
                        //Eliminar Libro
                        System.out.println("Ingrese el ID del libro a eliminar: ");
                        String idEliminar = entrada.nextLine();
                        if(buscarLibro(raizLibros, idEliminar)){
                            raizLibros = eliminarLibro(raizLibros, idEliminar);
                            System.out.println("Libro Eliminado Exitosamente!!! ");
                        }else{
                            System.out.println("El libro con el ID"+ idEliminar+ "No se pudo eliminar");
                        }
                    }else if(opcionLibros ==3){
                            System.out.println("Libros en la Biblioteca");
                            System.out.printf("%-10s %-20s %-20s%n ","ID","nombre","Autor");
                            listarLibros(raizLibros);
                    } 
                     
                    }while (opcionLibros !=4);
                    break;
                case 2:
                    int opcionUsuarios;
                    do{
                        System.out.println(ANSI_RED +"===== Menu de Libros ====="+ ANSI_RESET);
                        System.out.println(ANSI_BLUE +"1. Agregar Libro"+ ANSI_RESET);
                        System.out.println(ANSI_BLUE +"2. Eliminar Libro"+ ANSI_RESET);
                        System.out.println(ANSI_BLUE +"3. Listar Libros"+ ANSI_RESET);
                        System.out.println(ANSI_BLUE +"4. volver al menu Principal"+ ANSI_RESET);
                        opcionUsuarios = entrada.nextInt();
                        entrada.nextLine();
                        if( opcionUsuarios == 1){
                            System.out.println("Ingresa la cedula del usuario: ");
                            int cedula = entrada.nextInt();
                            if(buscarUsuario(raizUsuarios,cedula)){
                                System.out.println("El usuario con cedula "+cedula+" ya existe");
                        }else{
                            System.out.println("Ingrese el nombre del usuario: ");
                            String nombre = entrada.nextLine();
                            System.out.println("Ingrese los apellidos de los usuarios: ");
                            String apellidos = entrada.nextLine();
                            NodoUsuario nuevoUsuario = new NodoUsuario(cedula,nombre, apellidos);
                            if(raizUsuarios == null){
                                raizUsuarios = nuevoUsuario;
                        }else{
                                NodoUsuario actual = raizUsuarios;
                                while(true){
                                    if(cedula<actual.cedula){
                                        if(actual.izquierdo == null){
                                            actual.izquierdo = nuevoUsuario;
                                            break;
                                        }
                                        actual = actual.izquierdo;
                                    }else{
                                        if(actual.derecho == null);
                                        actual.derecho = nuevoUsuario;
                                        break;
                                    }
                                    actual = actual.derecho;
                                }
                            }
                            System.out.println("Usuario Agregado Exitosamente!!!");
                        }
                    }else if( opcionUsuarios == 2){
                        //Eliminar Usuarios
                        System.out.println("Ingrese la cedula del  usuario a eliminar: ");
                        int cedulaEliminar = entrada.nextInt();
                        if(buscarUsuario(raizUsuarios, cedulaEliminar)){
                            raizUsuarios = eliminarUsuario(raizUsuarios, cedulaEliminar);
                            System.out.println("Usuario Eliminado Exitosamente!!! ");
                        }else{
                            System.out.println("El usuario con la cedula"+ cedulaEliminar+ "No se pudo eliminar");
                        }
                    }else if(opcionUsuarios ==3){
                        //listar usuarios
                            System.out.println("Usuarios en la Biblioteca");
                            System.out.printf("%-10s %-20s %-20s%n ","ID","nombre","Autor");
                            listarUsuarios(raizUsuarios);
                    } 
                     
                    }while (opcionUsuarios !=4);
                    break;
                case 3:
                    System.out.println("Ingresar el Id del libro a prestar");
                    String idPrestar = entrada.next();
                    System.out.println("Ingrese la cedula del usuario");
                    int cedulaPrestar = entrada.nextInt();
                    entrada.nextLine();
                    
                    if(buscarLibro(raizLibros, idPrestar) && buscarUsuario(raizUsuarios, cedulaPrestar)){
                        NodoLibro libroPrestado = obtenerLibro(raizLibros, idPrestar);
                        if(libroPrestado  !=null){
                        librosPrestados.add(libroPrestado);
                        raizLibros = eliminarLibro(raizLibros, idPrestar);
                        System.out.println(String.format("Libros %s prestado exitosamente al usuario con cedula %d", idPrestar, cedulaPrestar));
                    }else   {
                        System.out.println("Error No se encontro el libro a prestar");
                        }
                    }else{
                        System.out.println("No se puede prestar el libro: verificar que el libro y el usuario existan");    
                            }
                    break;
                case 4:
                    System.out.println("Ingrese el ID del libro a devolver");
                    String idDevolver = entrada.next();
                    NodoLibro libroDevolver = null;
                    for(NodoLibro libro : librosPrestados){
                        if(libro.id.equals(idDevolver)){
                            libroDevolver = libro;
                            break;
                        }
                    }
                    if(libroDevolver != null){
                        raizLibros = agregarLibro(raizLibros, libroDevolver);
                        librosPrestados.remove(libroDevolver);
                        System.out.println(String.format("Libro %s (%s) devuelto exitosamente", libroDevolver.id, libroDevolver.nombre));
                    }else{
                        System.out.println("El libro no se encuentra en el registro de libros a devolver");
                    }
                    break;
                case 5:
                    if(librosPrestados.isEmpty()){
                        System.out.println("No hay libros prestados actualmente");
                    }else{
                        System.out.println("Libros prestados");
                        System.out.printf("%-10s %-20s %-20s%n", "ID", "Nombre", "Autor");
                        for(NodoLibro libro: librosPrestados){
                            System.out.printf("%-10s %-20s %-20s%n", libro.id, libro.nombre, libro.autor);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Libros Dispobles para prestar");
                    System.out.printf("%-10s %-20s %-20s%n", "ID", "Nombre", "Autor");
                    listarLibros(raizLibros);
                    break;
                case 7:
                    System.out.println("Vuelva pronto");
                    break; 
                default:
                    System.out.println("Opcion no valida, Intente nuevamente.");
            }            
        } while (opcion !=7);
 
    }
    public static boolean buscarLibro(NodoLibro nodo, String id){
        if(nodo == null) return false;
        if(id.equals(nodo.id)) return true;
        return id.compareTo(nodo.id)< 0 ? buscarLibro(nodo.izquierdo, id): buscarLibro(nodo.derecho,id);
    }
    public static NodoLibro agregarLibro(NodoLibro raiz, NodoLibro nuevo){
        if (raiz == null) return nuevo;
        if(nuevo.id.compareTo(raiz.id)<0) raiz.izquierdo = agregarLibro(raiz.izquierdo, nuevo);
        else raiz.derecho = agregarLibro(raiz.derecho, nuevo);
        return raiz;
    }
    
    public static NodoLibro eliminarLibro(NodoLibro nodo, String id){
        if (nodo == null) return null;
        if(id.compareTo(nodo.id) <0) nodo.izquierdo = eliminarLibro(nodo.izquierdo, id);
        else if (id.compareTo(nodo.id)>0) nodo.derecho = eliminarLibro(nodo.derecho, id);
        else{
        if(nodo.izquierdo == null) return nodo.derecho;
        if(nodo.derecho == null) return nodo.izquierdo;
        }
        return nodo;
    }
    public static void listarLibros(NodoLibro nodo){
        if(nodo != null){
            listarLibros(nodo.izquierdo);
            System.out.printf("%-10s %-20s %-20s%n", nodo.id, nodo.nombre, nodo.autor);
            listarLibros(nodo.derecho);
        }
    }
     public static boolean buscarUsuario(NodoUsuario nodo, int cedula){
        if(nodo == null) return false;
        if(cedula == nodo.cedula) return true;
        return cedula< nodo.cedula ? buscarUsuario(nodo.izquierdo, cedula): buscarUsuario(nodo.derecho,cedula);
    }
     public static NodoUsuario eliminarUsuario(NodoUsuario nodo, int cedula){
        if (nodo == null) return null;
        if(cedula<nodo.cedula) nodo.izquierdo = eliminarUsuario(nodo.izquierdo, cedula);
        else if (cedula<nodo.cedula) nodo.derecho = eliminarUsuario(nodo.derecho, cedula);
        else{
        if(nodo.izquierdo == null) return nodo.derecho;
        if(nodo.derecho == null) return nodo.izquierdo;
        }
        return nodo;
    }
     public static void listarUsuarios(NodoUsuario nodo){
        if(nodo != null){
            listarUsuarios(nodo.izquierdo);
            System.out.printf("%-10s %-20s %-20s%n", nodo.cedula, nodo.nombre, nodo.apellidos);
            listarUsuarios(nodo.derecho);
        }
     }
     public static NodoLibro obtenerLibro(NodoLibro nodo, String id){
         if(nodo == null) return null;
         if(id.equals(nodo.id)) return nodo;
         return id.compareTo(nodo.id) <0 ? obtenerLibro(nodo.izquierdo, id): obtenerLibro(nodo.derecho,id);
     }
}
