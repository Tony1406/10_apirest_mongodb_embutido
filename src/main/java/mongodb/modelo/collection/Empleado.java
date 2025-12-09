package mongodb.modelo.collection;


import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data @Builder
@EqualsAndHashCode(of = "id")
@Document(collection = "empleados")
public class Empleado {
	@Id
	//@JsonSerialize(using=ToStringSerializer.class)
	private ObjectId id;
	private String nombre;
	private int edad;
	//Embutidos 
	private Trabajo trabajo;
	private Departamento departamento;
	private List<String> aficiones;

}
