package mongodb.modelo.collection;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data @Builder
@Document(collection = "empleados")
public class Trabajo {
	private String titulo;
	private double salario;
	@Field("fecha_inicio")
	private double bonos;
	private LocalDate fechaInicio;
}
