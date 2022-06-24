import java.util.Scanner;
import javax.swing.JOptionPane; // Importamos las librerias

class ColaD { // creamos la clase Cola
    Nodo Primero, Final;
    int pos;
    Scanner t = new Scanner(System.in);

    public ColaD(){  //Declaramos el Primero que apunte a nada= null, igual que el Final apuntando a nada=null
        Primero = null;
        Final = null;
        pos = 0;
    }
    private Boolean esVacia() { //Creamos el meotodo para saber si la cola esta vacia
        return this.Primero == null;
    }
    private void mensaje(String cad) {
        System.out.println(cad);
    }
    private int LeerDato() { // creamos el metodo para la entrada de los datos
        mensaje(" INGRESE EL DATO : ");
        return t.nextInt();
    }
    private void InsertaPrimero(int dato) { // Metodo para insertar primero
        Nodo nuevo = new Nodo(dato);
        Primero = nuevo;
        Final = nuevo;
        pos++;
    }
    private void InsertaFinal() { // Metodo para insertar los datos al final de la cola
                int dato;
                dato = LeerDato();
                if (esVacia()) // hacemos la comparacion, si es vacia, insertamos el nodo en primer lugar
                    InsertaPrimero(dato);
                else { // sino es vacia, insertamos el nuevo nodo al final de la cola
                    Nodo nuevo = new Nodo(dato);
                    Final.setEnlace(nuevo);
                    Final = nuevo;
                    pos++;
                }
                JOptionPane.showMessageDialog(null, " DATO INSERTADO "); // mensaje de que el nodo se ha insertado correctamente
    }
    private void EliminarInicio() { // metodo para eliminar el nodo del inicio
        if (esVacia()) // hacemos la comparacion, si es vacia, mandamos un mensaje de que la cola esta vacia
            JOptionPane.showMessageDialog(null, " LA LISTA ESTA VACIA ", " ERROR ", JOptionPane.ERROR_MESSAGE);
        else { // si no es vacia, entonces pasamos a eliminar el primer nodo de la cola
            Primero = Primero.getEnlace();
            pos--;
            JOptionPane.showMessageDialog(null, " ELEMENTO ELIMINADO ");
        }
        Listar(); // Listamos de nuevo los nodos disponibles de la cola
    }
    private void Listar() { // Metodo para mostrar los datos disponibles e insertados de la cola
        if (esVacia()) // hacemos la comparacion, si es vacia, entonces mostramos un mensaje de que la cola esta vacia
            JOptionPane.showMessageDialog(null, " LISTA VACIA ", " ERROR ", JOptionPane.ERROR_MESSAGE);
        else { // si no es vacia, entonces mostamos los datos diponibles en la cola
            Nodo n;
            n = Primero;
            while (n != null) {
                mensaje(" --------------------------------------------");
                mensaje("  VALOR INSERTADO = " + n.getInfo() + " , DIRECCION = [" + n.getEnlace() + "]" );
                mensaje(" --------------------------------------------");
                n = n.getEnlace();
            }
            mensaje ("********** LISTADO TERMINADO **********"); // mensaje de que el listado ah terminado
        }
    }
    public void menu() { // Metodo donde va el menu de las opciones a realizar
        int v ;
        int op;
        do{
            try{
                v=0;
                do {   // Menu //
                    mensaje(" ________________________ ");
                    mensaje("|     MENU DE OPCIONES   |");
                    mensaje("|                        |");
                    mensaje("|  1. INSERTAR AL FINAL  |");
                    mensaje("|  2. ELIMINAR INICIO    |");
                    mensaje("|  3. LISTAR ELEMENTOS   |");
                    mensaje("|  4. SALIR              |");
                    mensaje("|                        |");
                    mensaje("|------------------------|");
                    mensaje("|     ELIJA SU OPCION    |");
                    mensaje(" ------------------------ ");
                    op = t.nextInt();
                        switch (op) { // Creamos un switch donde iran las funciones
                        case 1:InsertaFinal();
                            break;
                        case 2:EliminarInicio();
                            break;
                        case 3:Listar();
                            break;
                        case 4:
                            break;
                        default:
                        JOptionPane.showMessageDialog(null, " NO EXISTE ESA OPCION ", " ERROR ", JOptionPane.ERROR_MESSAGE); // mensaje de error cuando el usuario ingrese una opcion que no exista en el menu de opciones 
                    }
                } while (op != 4);
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, " INGRESE SOLO NUMEROS ENTEROS ", " ERRORS ",JOptionPane.ERROR_MESSAGE); // Mensaje de error cuando el usuario ingrese datos no validos
                v = 1;
                t.nextLine();
            }
        } while (v != 0); // final de la validacion
    }
    public static void main(String[] args) {
        ColaD c = new ColaD();
        c.menu();
    }
}