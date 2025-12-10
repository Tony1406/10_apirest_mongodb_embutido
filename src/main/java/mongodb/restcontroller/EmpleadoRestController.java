package mongodb.restcontroller;

import java.util.List; 

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mongodb.modelo.collection.Empleado;
import mongodb.modelo.service.EmpleadoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/empleados")
public class EmpleadoRestController {

	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping("/")
	public ResponseEntity<List<Empleado>> todos(){
		return ResponseEntity.status(200).body(empleadoService.buscarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> uno(@PathVariable ObjectId id){
		Empleado empleado = empleadoService.buscarUno(id);
		
		if(empleadoService.buscarUno(id) != null)
			return ResponseEntity.status(200).body(empleado);
		else 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado no existe");
		
	}
	
	@GetMapping("/salario-mayor/{salario}")
	public ResponseEntity<?> uno(@PathVariable double salario){
		return ResponseEntity.status(200).body(empleadoService.buscarPorSalarioMayor(salario));
	}
	
	@PostMapping("/")
	public ResponseEntity<?> alta(@RequestBody Empleado empleado){
		return ResponseEntity.status(201).body(empleadoService.insertOne(empleado));
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Empleado empleado){
		if(empleadoService.updateOne(empleado) != null)
			return ResponseEntity.status(200).body("Empleado modificado" + empleadoService.updateOne(empleado));
		else 
			return ResponseEntity.status(400).body("Empleado nooo modificado");	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable ObjectId id){
		if(empleadoService.deleteOne(id) == 1)
			return ResponseEntity.status(200).body("Empleado modificado");
		else 
			return ResponseEntity.status(400).body("Empleado nooo modificado");
		
	}
}


