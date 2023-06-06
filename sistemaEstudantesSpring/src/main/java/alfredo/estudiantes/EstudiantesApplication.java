package alfredo.estudiantes;

import alfredo.estudiantes.modelo.Estudiante;
import alfredo.estudiantes.servicio.EstudianteServcio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner {

	@Autowired
	private EstudianteServcio estudianteServcio;

	private static final Logger logger = LoggerFactory.getLogger(EstudiantesApplication.class);

	String nl = System.lineSeparator();
	public static void main(String[] args) {
		logger.info("Iniciando la aplicacion...");
		SpringApplication.run(EstudiantesApplication.class, args);
		logger.info("Aplicacion Finalizada!");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(nl +"Ejecutando metodo run de Spring..." +nl);
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir){
			mostrarMenu();
			salir = ejecutarOpciones(consola);
			logger.info(nl);
		}//fin while
	}

	private void mostrarMenu(){
		logger.info(nl);
		logger.info("""
				*** Sistema de Estudiantes ***
				1. Lista estudiantes
				2. Buscar estudiante
				3. Agregar estudiante 
				4. Modificar estudiante 
				5. Eliminar estudiante
				6. Salir
				Elige una opcion: """);
	}
	private boolean ejecutarOpciones(Scanner consola){
		var opcion = Integer.parseInt(consola.nextLine());
		var salir= false;
		switch (opcion){
			case 1 ->{
				//Listar estudiantes
				logger.info(nl + "Listado de Estudiantes: "+nl);
				List<Estudiante> estudiantes = estudianteServcio.listarEstudiantes();
				estudiantes.forEach((estudiante -> logger.info(estudiante.toString() + nl)));
			}
			case 2->{
				//Buscar estudiante por id
				logger.info("Introduce el id del estudiante: ");
				var idEsudiante = Integer.parseInt(consola.nextLine());
				Estudiante estudiante = estudianteServcio.buscarEstudiantePorId(idEsudiante);
				if(estudiante!=null){
					logger.info("Estudiante encontrado: "+ estudiante+ nl);
				}
				else {
					logger.info("Estudiante no encontrado con id: "+ idEsudiante);
				}
			}
			case 3->{
				//Agregar estudiante
				logger.info("Agregar estudiante: " + nl);
				logger.info("Nombre: ");
				var nombre = consola.nextLine();
				logger.info("Apellido: ");
				var apellido = consola.nextLine();
				logger.info("Telefono: ");
				var telefono = consola.nextLine();
				logger.info("Email: ");
				var email = consola.nextLine();
				//crear objeto estudiante sin id
				var estudiante = new Estudiante();
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
				estudiante.setTelefono(telefono);
				estudiante.setEmail(email);
				estudianteServcio.guardarEstudiante(estudiante);
				logger.info("Estudiante agregado: " + estudiante + nl);
			}
			case 4 -> {
				//Modificar estudiante
				logger.info("Modificar estudiante: " + nl);
				logger.info("Id del estudiante: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				//Buscar estudiante a modificar
				Estudiante estudiante = estudianteServcio.buscarEstudiantePorId(idEstudiante);
				if(estudiante!= null){
					logger.info("Nombre: ");
					var nombre = consola.nextLine();
					logger.info("Apellido: ");
					var apellido = consola.nextLine();
					logger.info("Telefono: ");
					var telefono = consola.nextLine();
					logger.info("Email: ");
					var email = consola.nextLine();

					estudiante.setNombre(nombre);
					estudiante.setApellido(apellido);
					estudiante.setTelefono(telefono);
					estudiante.setEmail(email);
					estudianteServcio.guardarEstudiante(estudiante);
				}
				else {
					logger.info("Estudiante no encontrado con id: " + idEstudiante +nl );
				}
			}
			case 5 ->{
				//Eliminar estudiante
				logger.info("Eliminar estudiante: "+ nl);
				logger.info("id Estudiante a eliminar: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				//Se busca el id a eliminar
				var estudiante = estudianteServcio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null){
					estudianteServcio.eliminarEstudiante(estudiante);
					logger.info("Estudiante eliminado: " + estudiante + nl);
				}
				else{
					logger.info("Estudiante no encontrado con id: "+ idEstudiante + nl);
				}

			}
			case 6 -> {//salir
				logger.info("Hasta pronto!" +nl + nl);
				salir = true;
			}
			default -> logger.info("Opcion incorrecta: "+ opcion + nl);
		}//fin swith
		return salir ;
	}
}
