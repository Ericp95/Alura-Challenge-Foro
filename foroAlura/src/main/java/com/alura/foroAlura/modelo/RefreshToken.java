package com.alura.foroAlura.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Entity(name = "Refresh_Token")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RefreshToken {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "token", nullable = false)
	private String token;

	@Column(name = "fecha_expiracion", nullable = false)
	private LocalDateTime fechaExpiracion;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;

	public Date getFechaExpiracion() {
		return Date.from(this.fechaExpiracion.atZone(ZoneId.systemDefault()).toInstant());
	}
}