package infrastructure;

import java.util.ArrayList;

import domain.Alumno;
import domain.AlumnoRepository;

public class AlumnoRepositoryImpl implements AlumnoRepository{
    public ArrayList<Alumno> alumnos = new ArrayList();

    public Alumno getById(int id) {
        Alumno alumno = null;

        for(Alumno alu : this.alumnos){
            if(alu.id == id){
                alumno = alu;
            }
        }

        return alumno;
    }
}
