package foro.hub.challenge.controller;


import foro.hub.challenge.domain.topico.DatosDetalleTopico;
import foro.hub.challenge.domain.topico.DatosRegistroTopico;
import foro.hub.challenge.domain.topico.Topico;
import foro.hub.challenge.domain.topico.TopicoRepository;
import foro.hub.challenge.domain.topico.DatosActualizarTopico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
        topicoRepository.save(new Topico(datosRegistroTopico));
    }

    @GetMapping
    public ResponseEntity<List<DatosDetalleTopico>> listadoTopicos(){
        return ResponseEntity.ok(topicoRepository.findAll().stream().map(DatosDetalleTopico::new).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> detalleTopico(@PathVariable @NotNull @Min(1) Long id){
        return ResponseEntity.ok(new DatosDetalleTopico(topicoRepository.getReferenceById(id)));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizacionTopico(@PathVariable @NotNull @Min(1) Long id ,@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Optional<Topico> topicoExistente = Optional.of(topicoRepository.getReferenceById(id));

       if (topicoExistente.isPresent()) {
           Topico topico = topicoExistente.get();
           topico.actualizarTopico(datosActualizarTopico);
            return ResponseEntity.ok(new DatosDetalleTopico(id, topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getFechaActualizacion(), topico.getStatus().toString(), topico.getAutor(), topico.getCurso()));
        }
       return null;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarMedico(@PathVariable @NotNull @Min(1) Long id) {
        Optional<Topico> topicoExistente = Optional.of(topicoRepository.getReferenceById(id));

        if (topicoExistente.isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.ok("El elemento fue eliminado exitosamente de la base de datos");
        }
        return null;
    }


}
