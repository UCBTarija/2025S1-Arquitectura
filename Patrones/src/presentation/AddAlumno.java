package presentation;

import domain.Curso;
import infrastructure.AlumnoRepositoryImpl;

public class AddAlumno {
    public void Execute(int alumnoId) {
        AlumnoRepositoryImpl repositorio = new AlumnoRepositoryImpl();
        Curso curso = new Curso(repositorio);
        curso.inscribir(10);

    }
}
