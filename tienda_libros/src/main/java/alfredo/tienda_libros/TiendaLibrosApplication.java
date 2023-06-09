package alfredo.tienda_libros;

import alfredo.tienda_libros.vista.LibroForm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.awt.*;

@SpringBootApplication
public class TiendaLibrosApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext contextoSpring =
				new SpringApplicationBuilder(TiendaLibrosApplication.class).headless(false)
						.web(WebApplicationType.NONE).run(args);
		//Ejecucion de  odigo para cargar el formulario
		EventQueue.invokeLater(()->{
			// Se obtiene el objeto form a traves de spring
			LibroForm libroForm = contextoSpring.getBean(LibroForm.class);
			libroForm.setVisible(true);
		});
	}

}
