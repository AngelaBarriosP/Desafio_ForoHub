package foro.hub.challenge.domain.topico;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        LocalDateTime fechaActualizacion,
        String status,
        String autor,
        String curso
) {
    public DatosDetalleTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getFechaActualizacion(),
                topico.getStatus().toString(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}
