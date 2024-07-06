package logica;
import java.util.ArrayList;

public class Becas {
	private static final int MAX_ESTUDIANTES = 100;
    private ArrayList<Estudiantes> estudiantes;

    public Becas() {
        estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiantes estudiante) {
        if (estudiantes.size() < MAX_ESTUDIANTES) {
            estudiantes.add(estudiante);
        } else {
            System.out.println("No se puede agregar más estudiantes. Límite alcanzado.");
        }
    }
    
    public Estudiantes buscarEstudiantePorCedula(String cedula) {
        for (Estudiantes estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                return estudiante;
            }
        }
        return null; // Retorna null si no se encuentra ningún estudiante con la cédula especificada
    }
    
    

    public ArrayList<String> obtenerEstudiantesBecados() {
        ArrayList<String> estudiantesBecados = new ArrayList<>();

        for (Estudiantes estudiante : estudiantes) {
            if (estudiante.getIndiceAcademico() >= 2.0) {
                estudiantesBecados.add(estudiante.getNombre());
            }
        }

        return estudiantesBecados;
    }
    
    public ArrayList<Estudiantes> buscarEstudiantesPorCarreraYSexo(String carrera, String sexo) {
        ArrayList<Estudiantes> estudiantesFiltrados = new ArrayList<>();

        for (Estudiantes estudiante : estudiantes) {
            if (estudiante.getCarrera().equalsIgnoreCase(carrera) &&
                estudiante.getSexo().equalsIgnoreCase(sexo) &&
                estudiante.getIndiceAcademico() >= 2.0) {
            	System.out.println(estudiante.getNombre());
                
                estudiantesFiltrados.add(estudiante);
            }
        }

        return estudiantesFiltrados;
    }

}
