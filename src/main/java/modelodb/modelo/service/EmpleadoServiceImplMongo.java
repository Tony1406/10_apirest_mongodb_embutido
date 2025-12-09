package modelodb.modelo.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import mondodb.repository.EmpleadoRepository;
import mongodb.modelo.collection.Empleado;

public class EmpleadoServiceImplMongo implements EmpleadoService{
	
	@Autowired
    private EmpleadoRepository empleadoRepository; 

	@Override
	public Empleado buscarUno(ObjectId id) {
		// TODO Auto-generated method stub
		return empleadoRepository.findById(id).orElse(null);
	}

	@Override
	public List<Empleado> buscarTodos() {
		// TODO Auto-generated method stub
		return empleadoRepository.findAll();
	}

	@Override
	public Empleado insertOne(Empleado empleado) {
		// TODO Auto-generated method stub
		if(!empleadoRepository.existsById(empleado.getId()))
	}

	@Override
	public Empleado updateOne(Empleado empleado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteOne(Object id) {
		// TODO Auto-generated method stub
		/*if(empleadoRepository.existById(id)) {
			empleadoRepository.delete(id);
			return 1;
		}*/
		return 0;
	}

	@Override
	public List<Empleado> buscarPorSalarioMayor(double salario) {
		// TODO Auto-generated method stub
		return null;
	}

}
