package sv.edu.udb.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.annotation.Commit;

import sv.edu.udb.repository.domain.Alumno;
import sv.edu.udb.repository.domain.Materia;
import sv.edu.udb.repository.MateriaRepository;
import sv.edu.udb.repository.AlumnoRepository;

import jakarta.persistence.EntityManager;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Commit
public class DBTest {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional
    public void testInsertData() {
        // Obtener materias desde la base de datos
        Optional<Materia> optMateria1 = materiaRepository.findByNombre("Matemáticas");
        Optional<Materia> optMateria2 = materiaRepository.findByNombre("Lenguaje");

        assertThat(optMateria1).isPresent();
        assertThat(optMateria2).isPresent();

        Materia materia1 = optMateria1.get();
        Materia materia2 = optMateria2.get();

        // Insertando nuevos alumnos
        Alumno alumno1 = new Alumno("Francisco", "Alarcon", materia1);
        Alumno alumno2 = new Alumno("Raul", "Gonzales", materia2);
        alumnoRepository.save(alumno1);
        alumnoRepository.save(alumno2);

        // Forzar persistencia en la BD
        entityManager.flush();

        // Verificar que los datos fueron insertados correctamente
        long totalAlumnos = alumnoRepository.count();
        assertThat(totalAlumnos).isGreaterThanOrEqualTo(5);
    }
}