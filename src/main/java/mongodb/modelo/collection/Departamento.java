package mongodb.modelo.collection;


import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data @Builder
public class Departamento {
	
	private String nombre;
	@Field("ubicacion")
	private String ubicacion;

}
