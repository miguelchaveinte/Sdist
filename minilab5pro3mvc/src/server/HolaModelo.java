package server;

// nuestro Modelo observable.
public class HolaModelo {
  java.util.Map<service.HolaVista,String> mapaObservadores =
          new java.util.HashMap<>();

  // agrega un Observador (HolaVista)
  public void setHola(String saludo, service.HolaVista obs) {
    mapaObservadores.put(obs, saludo);
    System.out.println("Realizado un puts con el saludo: "+saludo);
    notificaObservadores() ;
  }

  public void unsetHola(service.HolaVista obs) {
    mapaObservadores.remove(obs);
  }

  // En muchas ocasiones la notificación se delega en el
  // controlador, sobre todo en interfaces Web.
  void notificaObservadores() {
    String[] lista = new String[1];
    String[] saludos = mapaObservadores.values().toArray(lista);
    System.out.print("[");           // printout para depurar
    for ( String saludo : saludos)   // la lista de saludos
      System.out.print(saludo+", "); // que enviamos a los asistentes.
    System.out.println("]");

    mapaObservadores.forEach( (observador,mensaje) ->
       { try {
            observador.notify(saludos);
         } catch (java.rmi.RemoteException re) {}
       } );
  }
  // Aquí podrás poner más métodos para manipular/acceder al estado
  // del modelo desde dentro del servidor o mediante otros controladores.
}