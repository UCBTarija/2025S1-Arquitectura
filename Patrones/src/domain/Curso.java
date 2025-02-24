package domain;

public class Curso {
    public AlumnoRepository repository;

    public Curso(AlumnoRepository repository){
        this.repository = repository;
    }

    public void inscribir(int alumnoID) {
        Alumno alumno = repository.getById(alumnoID);


    }
}
