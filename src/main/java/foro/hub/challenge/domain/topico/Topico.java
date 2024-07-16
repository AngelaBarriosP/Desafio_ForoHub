package foro.hub.challenge.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;
    @Column(name = "fecha_actualizacion", nullable = false, updatable = true)
    private LocalDateTime fechaActualizacion;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String autor;
    private String curso;

    public Topico (DatosRegistroTopico datosRegistroTopico){
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.fechaActualizacion = LocalDateTime.now();
        this.status = status.NUEVO;
        this.autor = datosRegistroTopico.autor();
        this.curso = datosRegistroTopico.curso();
    }


    public void actualizarTopico(DatosActualizarTopico datosActualizarTopico) {
        this.titulo = datosActualizarTopico.titulo();
        this.mensaje = datosActualizarTopico.mensaje();
        this.fechaActualizacion = LocalDateTime.now();
        this.status = status.NUEVO;
        this.autor = datosActualizarTopico.autor();
        this.curso = datosActualizarTopico.curso();
    }
}
