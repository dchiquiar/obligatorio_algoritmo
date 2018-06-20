
package obligatorio_algoritmo;

public class Obligatorio {

    public static void main(String[] args) {
        // TODO code application logic here
        
        Sistema s = new Sistema();
        Prueba p = new Prueba();
//       s.crearSistemaReservas(5);
        prueba1(s,p);
        //prueba2(s,p);
        
        
    }
    
    static void prueba1(Sistema s, Prueba p){
//           p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se agrego Montevideo");
//           p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.ERROR_1, "Se intentoagregar Montevideo que ya existe");
//           p.ver(s.registrarCiudad("Punta del Este").resultado, Retorno.Resultado.OK, "Se agrego Punta del Este");
//           p.ver(s.registrarCiudad("La Paloma").resultado, Retorno.Resultado.OK, "Se agrego La Paloma");
//           p.ver(s.registrarCiudad("Maldonado").resultado, Retorno.Resultado.ERROR_2, "Se intento agregar Maldonado pero el sistema esta completo");   
//       //    p.ver(s.registrarMovil("moviltest",1).resultado,Retorno.Resultado.ERROR_1,"Se intenta agregar movil con zona inexistente");
//       p.ver(s.agregarZona("hola chiche").resultado,Retorno.Resultado.OK,"Se agrega hola chiche a la lista de zonas");
//         p.ver(s.agregarZona("hola chiche").resultado,Retorno.Resultado.ERROR_1,"se agrega una ciudad que ya existe,se espera error_1");
//           p.imprimirResultadosPrueba();
        p.ver(s.registrarCiudad("Montevideo").resultado,Retorno.Resultado.OK,"Se agrega Montevideo, debe dar OK");
        p.ver(s.registrarCiudad("Paysandu").resultado,Retorno.Resultado.ERROR_1,"Se agrega Paysandu, debe dar  ERROR,porque la unica ciudad deberia ser Montevideo");
        p.ver(s.agregarZona("Prado").resultado,Retorno.Resultado.OK,"Se agrega Prado,debe dar OK");
        p.ver(s.agregarZona("Malvin").resultado,Retorno.Resultado.OK,"Se agrega Malvin,debe dar OK");
        p.ver(s.agregarZona("Buceo").resultado,Retorno.Resultado.OK,"Se agrega Buceo,debe dar OK");
        p.ver(s.agregarZona("Prado").resultado,Retorno.Resultado.ERROR_1,"Se agrega Prado nuevamente,debe dar ERROR,porque ya existe");
        p.ver(s.listarZonas().resultado,Retorno.Resultado.OK,"hola");
        p.imprimirResultadosPrueba();
    }

//static void prueba2(Sistema s, Prueba p){
//        p.imprimirComentario("CREAMOS SISTMA PARA 0 CIUDADES");
//        p.ver(s.crearSistemaEmergencias(0).resultado, Retorno.Resultado.ERROR_1, "Se creÃ³ el sistema de reservas.");
//        p.imprimirComentario("CREAMOS SISTMA PARA 5 CIUDADES");
//        p.ver(s.crearSistemaEmergencias(5).resultado, Retorno.Resultado.OK, "Se creÃ³ el sistema de reservas.");
//        p.imprimirComentario("INGRESAMOS CIUDADES");
//        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se ingresa Montevideo");
//        p.ver(s.registrarCiudad("Santiago").resultado, Retorno.Resultado.OK, "Se ingresa Santiago");
//        p.ver(s.registrarCiudad("Lima").resultado, Retorno.Resultado.OK, "Se ingresa Lima");
//        p.ver(s.registrarCiudad("San Pablo").resultado, Retorno.Resultado.OK, "Se ingresa San Pablo");
//        p.ver(s.registrarCiudad("New York").resultado, Retorno.Resultado.OK, "Se ingresa New York");
//        p.imprimirComentario("INGRESAMOS CIUDAD REPETIDA");
//        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.ERROR_1, "Montevideo ya existe");
//        p.imprimirComentario("INTENTAMOS SOBREPASAR EL LIMITE DE CIUDADES");
//        p.ver(s.registrarCiudad("Buenos Aires").resultado, Retorno.Resultado.ERROR_2, "Se sobrepasa el límite de ciudades gestionados por el sistema");
//        p.imprimirResultadosPrueba();   
//    }
                      
    
    
}
