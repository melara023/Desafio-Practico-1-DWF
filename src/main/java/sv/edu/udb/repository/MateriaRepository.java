package sv.edu.udb.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.edu.udb.repository.domain.Materia;

import java.util.Optional;

@Repository
public interface MateriaRepository extends JpaRepository <Materia, Long> {
    Optional<Materia> findByNombre(String nombre);
}
