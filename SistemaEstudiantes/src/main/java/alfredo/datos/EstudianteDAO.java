package alfredo.datos;

import alfredo.dominio.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static alfredo.conexion.Conexion.getConexion;

//DAO -> Data Access Object
public class EstudianteDAO {
    public List<Estudiante> listarEstudiantes(){
        List<Estudiante> estudiantes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM estudiante ORDER BY id_estudiante";
        try {
            ps = con.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()){
                var estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("id_estudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setEmail(rs.getString("email"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiantes.add(estudiante);
            }
        } catch (Exception e){
            System.out.println("Ocurrion un error al seleccionar los datos: "+ e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("ocurrio un error al cerrar la conexion: "+e.getMessage() );
            }
        }
        return estudiantes;
    }

    public boolean buscarEstudiantePorId(Estudiante estudiante){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM estudiante WHERE id_estudiante = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            rs = ps.executeQuery(); //se usa executeQuery cuando se va a recuperar informacion de la base de datos
            if(rs.next()){
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setEmail(rs.getString("email"));
                estudiante.setTelefono(rs.getString("telefono"));
                return true;
            }
        } catch (Exception e){
            System.out.println("Ocurrio un error en la consult a la base de datos: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Ocurrio un error al cerrar la conexion: "+ e.getMessage());
            }
        }
        return false;
    }

    public boolean agregarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "INSERT INTO estudiante(nombre, apellido, telefono, email)"+
                "VALUES(?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4,estudiante.getEmail());
            ps.execute(); //se usa execute cuando se va a almacenar informacion en la base de datos
            return true;
        }catch (Exception e){
            System.out.println("Error al agregar estudiante: "+ e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println("ocurrio un error al cerrar conexion: "+ e.getMessage());
            }

        }
        return false;
    }

    public boolean modificarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "UPDATE estudiante SET nombre=?, apellido=?, telefono=?," +
                "email=? WHERE id_estudiante=?";
        try {
            ps= con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.setInt(5, estudiante.getIdEstudiante());
            ps.execute();
            return true;

        }catch (Exception e){
            System.out.println("Ocurrio un error al actualizar el estudiante: "+ e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println("Ocurrio un error al cerrar la conexion: "+ e.getMessage());
            }
        }
        return false;
    }

    public boolean eliminarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "DELETE FROM estudiante WHERE id_estudiante=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            ps.execute();
            return true;
        } catch (Exception e){
            System.out.println("Ocurrio un error al borrar al estudiante: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
        return false;

    }

    public static void main(String[] args) {
        var estudianteDAO = new EstudianteDAO();

        //PRUEBAS DE FUNCIONES CRUD
        //Agregar estudiante:
//        var nuevoEstudiante = new Estudiante(
//                "juan",
//                "perez",
//                "55663322",
//                "juan@perez.com");
//        var agregado = estudianteDAO.agregarEstudiante(nuevoEstudiante);
//        if(agregado)
//            System.out.println("Estudiante agregado: "+ nuevoEstudiante);
//        else
//            System.out.println("ocurrio un error al agregar el estudiante: " + nuevoEstudiante);
//        System.out.println();

        //Modificar estudiante: id:2
//        var estudianteModificar = new Estudiante(2,
//                "pedro",
//                "perez",
//                "564565465456",
//                "pedro@perez.com");
//        var modificado = estudianteDAO.modificarEstudiante(estudianteModificar);
//        if(modificado)
//            System.out.println("El estudiante con id 2 fue modificado");
//        else
//            System.out.println("El estudiante con id 2 no se pudo modificar");
//        System.out.println();

        //Eliminar estudiante id:2
        var estudianteEliminar = new Estudiante(2);
        var eliminar = estudianteDAO.eliminarEstudiante(estudianteEliminar);
        if(eliminar)
            System.out.println("Se elimino correctamente el estudiante");
        else
            System.out.println("No se pudo eliminar el estudiante");


        //Listar los estudiantes:
        System.out.println("Listado de estudiantes: ");
        List<Estudiante> estudiantes = estudianteDAO.listarEstudiantes();
        estudiantes.forEach(System.out::println);

        //Buscar por id
//        var estudiante1 = new Estudiante(2);
//        System.out.println("Estudiante antes de la busqueda: "+ estudiante1);
//        var encontrado = estudianteDAO.buscarEstudiantePorId(estudiante1);
//        if(encontrado)
//            System.out.println("Estudiante encontrado: "+ estudiante1);
//        else
//            System.out.println("No se encontro el estudiante: "+ estudiante1.getIdEstudiante());
    }
}
