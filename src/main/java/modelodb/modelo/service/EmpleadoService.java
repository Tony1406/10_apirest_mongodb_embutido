package modelodb.modelo.service;

import java.util.List;

import org.bson.types.ObjectId;

import mongodb.modelo.collection.Empleado;

public interface EmpleadoService {

	Empleado buscarUno(ObjectId id);
	List<Empleado> buscarTodos();
	Empleado insertOne(Empleado empleado);
	Empleado updateOne(Empleado empleado);
	int deleteOne(ObjectId id);
	List<Empleado> buscarPorSalarioMayor(double salario);
}
