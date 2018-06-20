package obligatorio_algoritmo;

public class Sistema implements ISistema
{
    private int maxZonas;
    private ListaZonas lz;
    private ListaMoviles lm;
    private ListaChoferes lc;
    
	
	public Sistema() 
        {
                this.maxZonas = 0;
                this.lz = null;
                this.lm = null;
                this.lc = null;
	}

    @Override
    public Retorno crearSistemaEmergencias(int maxZonas) 
    {
        if(maxZonas > 0){
                this.maxZonas = maxZonas;
        	return new Retorno(Retorno.Resultado.OK);
        }
        else{
            return new Retorno(Retorno.Resultado.ERROR_1);
        }
    }

    @Override
    public Retorno destruirSistemaEmergencias() 
    {
                this.maxZonas = 0;
                this.lc = null;
                this.lm = null;
                this.lz = null;
                return new Retorno(Retorno.Resultado.OK);
    }

       @Override
    public Retorno registrarMovil(String movilID, int zonaID) 
    {
    	Retorno retFinal = new Retorno(Retorno.Resultado.ERROR_1);
        Zona newZona = lz.buscarElementoPorId(zonaID);
        if(newZona != null)
        {
            Movil newMovil = lm.buscarElementoPorString(movilID);
            if(newMovil != null)
            {
               lm.agregarMovil(newMovil);
               newZona.ListaMoviles().agregarMovil(newMovil);
               retFinal = new Retorno(Retorno.Resultado.OK);
            }
        }
    
        return retFinal;
    } 

    @Override
    public Retorno deshabilitarMovil(String movilID) 
    {
       Retorno retFinal = new Retorno(Retorno.Resultado.ERROR_1);
       //en lista general de moviles.
       //primero chequeo si existe el movilid..
       Movil auxMov = lm.buscarElementoPorString(movilID);
       if (auxMov!=null)
       {
           //si entra aca el movil existe
           
       }
        return retFinal;
       }
       


    @Override
    public Retorno habilitarMovil(String movilID) {
       Retorno retAux = new Retorno(Retorno.Resultado.ERROR_1);
       if(this.movilElementos>0)
       {
        if(this.movilElementos == 1 && this.movilInicio.getDato().equals(movilID) && this.movilInicio.estado == Estado.NO_DISPONIBLE)
        {
            this.movilInicio.estado = Estado.DISPONIBLE;
            this.movilFin.estado = Estado.DISPONIBLE;
            retAux = new Retorno(Retorno.Resultado.OK);
        }
        else if(this.movilElementos > 1)
        {
            Movil auxMov = this.movilInicio;
            while(auxMov != null)
            {
                if(auxMov.getDato().equals(movilID))
                {
                    if(auxMov.estado == Estado.NO_DISPONIBLE)
                    {
                        auxMov.estado = Estado.DISPONIBLE;
                        retAux = new Retorno(Retorno.Resultado.OK);
                    }
                }
                auxMov.getSig();
            }
        }     
       }
       return retAux;
    }

    @Override
    public Retorno eliminarMovil(String movilID) {
      Retorno retAux = new Retorno(Retorno.Resultado.ERROR_1);
      
      //primero me fijo que la cant elementos de movil sea mayor a 0
      if(this.movilElementos > 0)
      {
          //chequeo si hay solo un elemento y si este existe
          if(this.movilInicio.getDato().equals(movilID) && 1 == this.movilElementos)
          {
              this.movilInicio = null;
              this.movilFin = null;
              retAux = new Retorno(Retorno.Resultado.OK);
          }
          
          //si hay mas de un elemento tengo que recorrer y verificar si existe
          else if(movilElementos > 1)
          {
              Movil auxMovil = this.movilInicio;
              
              while(auxMovil != null){
              if(auxMovil.getDato().equals(movilID)) //si entra a este if,existe,entonces tengo que borrar referencias
              {
                  auxMovil.getSig().setAnt(auxMovil.getAnt());
                  auxMovil.getAnt().setSig(auxMovil.getSig());     
                   retAux = new Retorno(Retorno.Resultado.OK);
              }
              auxMovil.getSig();
              }
          }
      }
      return retAux;
    }

    @Override
    public Retorno buscarMovil(String movilID) {
        Retorno retFinal = new Retorno(Retorno.Resultado.ERROR_1);
        if(this.movilElementos > 0)
        {
            if(this.movilElementos == 1 && this.movilInicio.getDato().equals(movilID))
            {
                 //Datos móvil: RAM1392|Estado: NO_DISPONIBLE|Zona: Cerro|#Emergencias: 20
                System.out.println("Datos móvil: " + this.movilInicio.getDato() + "| Estado: " + this.movilInicio.estado.toString() + "| Zona: Cerro" + "| asd");
                retFinal = new Retorno(Retorno.Resultado.OK);
            }
           
        }
        return retFinal;
    }

    @Override
    public Retorno informeMovil() {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno informeMovil(int zonaID) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno cambiarUbicacion(String movilID, int zonaID) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno agregarZona(String zonaNombre) {
        Retorno retFinal = new Retorno(Retorno.Resultado.ERROR_1);
       if(this.zonaElementos == 0)
       {
           this.zonaInicio = new Zona(zonaNombre);
           this.zonaFin = this.zonaInicio;
           this.zonaFin.setSig(null);
           this.zonaElementos++;
           retFinal = new Retorno(Retorno.Resultado.OK);
       }
       else
       {
           Zona auxZona = this.zonaInicio;
           Retorno retAux = new Retorno(Retorno.Resultado.OK);
           while(auxZona != null)
           {
               if(auxZona.getString().equals(zonaNombre))
               {
               retAux = new Retorno(Retorno.Resultado.ERROR_1);
               }
               auxZona = auxZona.getSig();
           }
          
           if(retAux.resultado == Retorno.Resultado.OK)
           {
               Zona nuevaZona = new Zona(zonaNombre);
               this.zonaFin.setSig(nuevaZona);
               nuevaZona.setSig(null);
               this.zonaFin = nuevaZona;
               this.zonaElementos++;
               retFinal = new Retorno(Retorno.Resultado.OK);
           }
       }
       return retFinal;
    }

    @Override
    public Retorno listarZonas() {
        if(this.zonaElementos > 0)
        {
            if(this.zonaElementos == 1)
            {
            System.out.println("ID ZONA: " + this.zonaInicio.getString() + "NOMBRE: " + this.zonaInicio.nombreZona);
            }
            if(this.zonaElementos > 1)
            {
                Zona auxZona = this.zonaInicio;
              while(auxZona!=null)
              {
                  System.out.println("ID ZONA: " + auxZona.getString() + "NOMBRE: " + auxZona.nombreZona);
                   auxZona = auxZona.getSig();
              }
            }
        }
        
        return new Retorno(Retorno.Resultado.OK);
       
       
    }

    @Override
    public Retorno agregarRuta(int zonaOrigen, int zonaDestino, int minutosViaje) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno modificarDemora(int zonaOrigen, int zonaDestino, int minutosViaje) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno movilMasCercano(int zonaID) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno rutaMasRapida(int zonaOrigen, int zonaDestino) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno informeZonas() {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno zonasEnRadio(int zonaID, int duracionViaje) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno registrarChofer(String movilID, String nombre, String cedula) {
        Retorno retFinal = new Retorno(Retorno.Resultado.ERROR_1);
        if(this.movilElementos > 0)
        {
            if(this.movilElementos == 1)
            {
                if(this.movilInicio.getDato().equals(movilID))
                {
                    retFinal = new Retorno(Retorno.Resultado.OK);
                    Chofer nuevoChofer = new Chofer(movilID,nombre,cedula);
                    this.choferInicio = nuevoChofer;
                    this.choferFin = nuevoChofer;
                    this.choferFin.setAnt(choferInicio);
                    this.choferInicio.setSig(choferFin);
                    this.choferElementos++;
                }
            }
            else if(this.movilElementos > 1)
            {
                Movil auxMov = this.movilInicio;
                while(auxMov!=null)
                {
                    if(auxMov.getDato().equals(movilID))
                    {   
                        Chofer nuevoChofer = new Chofer(movilID,nombre,cedula);
                        this.choferFin.getSig().setSig(nuevoChofer);
                        nuevoChofer.setAnt(choferFin);
                        this.choferFin = nuevoChofer;
                        retFinal = new Retorno(Retorno.Resultado.OK);
                    }
                    auxMov = auxMov.getSig();
                }
            }
        }
        return retFinal;
    }

    @Override
    public Retorno eliminarChofer(String movilID, String cedula) {
        Retorno retFinal = new Retorno(Retorno.Resultado.ERROR_1);
        if(this.movilElementos>0)
        {
            if(this.choferElementos > 0){
                if(this.movilElementos == 1 && this.movilInicio.getDato().equals(movilID)) //si entra aca, el unico movil q hay en el sistema coincide con el movilID del parametro
                {
                    if(this.choferElementos == 1 && this.choferInicio.getCedula().equals(cedula)) //si entra aca, el  unico chofer q hay en el sistema coincide con la cedula del parametro
                    {
                        this.choferInicio = null;
                        this.choferFin = null;
                        this.choferElementos = 0;
                    }
                    else if(this.choferElementos > 1)
                    {
                        Chofer auxChofer = this.choferInicio;
                        while(auxChofer!=null)
                        {
                            if(auxChofer.getCedula().equals(cedula))
                            {
                                
                            }
                            auxChofer = auxChofer.getSig();
                        }
                    }
                }
            }
        }
        return retFinal;
    }

    @Override
    public Retorno informeChoferes(String movilID) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno registrarAbonadol(int abonadoID, String abonadoNombre, String abonadoDireccion, String abonadoTel, int zonaID) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno eliminarAbonado(int abonadoID) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno informeAbonadosZona(int zonaID) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno registrarCiudad(String ciudad) {
        Retorno retFinal = new Retorno(Retorno.Resultado.ERROR_1);
        if(ciudad.equals("Montevideo"))
        {
            retFinal = new Retorno(Retorno.Resultado.OK); 
        }
        return retFinal;
    }

    Object crearSistemaReservas(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
