package animal;

public class Animal {
	
	private String identificacion;
	private String nombre;
	private String genero;
	private String color;
	private int edad;
	private String especie;
	
	public Animal() {
		
	}
	
	public Animal(String identificacion, String nombre, String color, String genero, String especie, int edad) {
		setIdentificacion(identificacion);;
		setNombre(nombre);
		setColor(color);
		setGenero(genero);
		setEspecie(especie);
		setEdad(edad);
	}
	
	public String hacerSonido() {
	    String sonido = "";

	    if (especie.equalsIgnoreCase("perro")) {
	        sonido = "¡Guau guau!";
	    } else if (especie.equalsIgnoreCase("gato")) {
	        sonido = "¡Miau miau!";
	    } else if (especie.equalsIgnoreCase("vaca")) {
	        sonido = "¡Muu muu!";
	    } else if (especie.equalsIgnoreCase("cerdo")) {
	        sonido = "¡Oink oink!";
	    } else if (especie.equalsIgnoreCase("caballo")) {
	        sonido = "¡Relincho!";
	    } else if (especie.equalsIgnoreCase("oveja")) {
	        sonido = "¡Beee beee!";
	    } else if (especie.equalsIgnoreCase("pato")) {
	        sonido = "¡Cua cua!";
	    } else if (especie.equalsIgnoreCase("loro")) {
	        sonido = "¡Cricri!";
	    } else if (especie.equalsIgnoreCase("rana")) {
	        sonido = "¡Croac croac!";
	    } else if (especie.equalsIgnoreCase("león")) {
	        sonido = "¡Rugido!";
	    } else {
	        sonido = "La mascota no hace sonidos conocidos.";
	    }

	    return sonido;
	}

	
    public String saltar() {
    	
    	String mensaje = "¡" + nombre + " esta saltando!";
    	
    	return mensaje;
    }

    public String jugar () {
    	
    	String mensaje = "¡" + nombre + " esta jugando!";
    	
    	return mensaje;
    }
    
   public String dormir () {
    	
    	String mensaje = "¡" + nombre + " esta durmiendo!";
    	
    	return mensaje;
    }
   
   public String correr () {
   	
   	String mensaje = "¡" + nombre + " esta corriendo!";
   	
   	return mensaje;
   }
    
	public String getEspecie() {
		return especie;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	
	
}
