package maciel.lazaro.exemplosql2.repository;

import maciel.lazaro.exemplosql2.model.ClientEntety;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends CrudRepository<ClientEntety, Long> {
}
