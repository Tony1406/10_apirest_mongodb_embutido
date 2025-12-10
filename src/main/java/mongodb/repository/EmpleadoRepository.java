package mongodb.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import mongodb.modelo.collection.Empleado;

public interface EmpleadoRepository extends MongoRepository<Empleado, ObjectId> {
	@Query ("{'trabajo.salario': {$gt: ?0}}")
	public List<Empleado> findByTrabajo_salarioGreaterThan(double salario);
	
}
