package mongodb.modelo.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mongodb.modelo.collection.Empleado;
import mongodb.repository.EmpleadoRepository;

@Service
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
		if(empleado.getId() == null ||!empleadoRepository.existsById(empleado.getId()))
			return empleadoRepository.save(empleado);
		return null;
	}

	@Override
	public Empleado updateOne(Empleado empleado) {
		// TODO Auto-generated method stub
		if(!empleadoRepository.existsById(empleado.getId()))
			return empleadoRepository.save(empleado);
		return null;
	}

	@Override
	public int deleteOne(ObjectId id) {
		// TODO Auto-generated method stub
		if(empleadoRepository.existsById(id)) {
			empleadoRepository.deleteById(id);
			return 1;
		}
		return 0;
	}

	@Override
	public List<Empleado> buscarPorSalarioMayor(double salario) {
		// TODO Auto-generated method stub
		return empleadoRepository.findByTrabajo_salarioGreaterThan(salario);
	}

}
