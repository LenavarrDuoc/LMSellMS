package cl.duoc.lmsellms.services;

import cl.duoc.lmsellms.dtos.DescuentoInputDTO;
import cl.duoc.lmsellms.dtos.DescuentoResponseDTO;
import cl.duoc.lmsellms.dtos.DescuentoUpdateDTO;
import cl.duoc.lmsellms.exceptions.IdNoExisteException;
import cl.duoc.lmsellms.exceptions.NombreDctoNoExisteException;
import cl.duoc.lmsellms.mapper.DescuentoInputMapper;
import cl.duoc.lmsellms.mapper.DescuentoResponseMapper;
import cl.duoc.lmsellms.mapper.DescuentoUpdateMapper;
import cl.duoc.lmsellms.models.Descuento;
import cl.duoc.lmsellms.repositories.DescuentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DescuentoService {

    @Autowired
    private DescuentoRepository descuentoRepository;

    @Autowired
    private DescuentoResponseMapper descuentoResponseMapper;

    @Autowired
    private DescuentoInputMapper descuentoInputMapper;
    @Autowired
    private DescuentoUpdateMapper descuentoUpdateMapper;

    //CREATE:
    @Transactional
    public DescuentoResponseDTO save(DescuentoInputDTO dto){
        if (descuentoRepository.existsByNombre((dto.getNombre()))){
            throw new NombreDctoNoExisteException("Nombre de descuento ya existe.");
        }


        return descuentoResponseMapper.toDto(descuentoRepository.save(descuentoInputMapper.toEntity(dto)));
    }


    //READ:
    @Transactional(readOnly = true)
    public List<DescuentoResponseDTO> findAll(){
        return descuentoRepository.findAll().stream().map(descuentoResponseMapper::toDto).toList();
    }

    @Transactional
    public Boolean existsById(Long id){
        return descuentoRepository.existsById(id);
    }

    @Transactional(readOnly = true)
    public DescuentoResponseDTO findById(Long id){
        return descuentoResponseMapper.toDto(descuentoRepository.findById(id).orElseThrow(() -> new IdNoExisteException("ID de descuento no existe."))) ;
    }

    @Transactional(readOnly = true)
    public Double findValueByIdForSelling(Long id){
        return (descuentoRepository.findById(id).orElseThrow(() -> new IdNoExisteException("ID de descuento no existe."))).getPorcentajeDcto() ;
    }

    @Transactional(readOnly = true)
    public DescuentoResponseDTO findByNombre(String nombre){
        Descuento ent = descuentoRepository.findByNombre(nombre);
        if (ent == null){
            throw new NombreDctoNoExisteException("Nombre de descuento no existe.");
        }
        return descuentoResponseMapper.toDto(ent);
    }




    //UPDATE:
    @Transactional
    public DescuentoResponseDTO update(DescuentoUpdateDTO dto){

        //TODO: Se debe arregllar: expone a la entidad Descuento directamente en Service cuando se podría procesar en el mapper.
        Descuento ent = descuentoRepository.findById(dto.getId()).orElseThrow(() -> new IdNoExisteException("ID de descuento no existe."));
        return descuentoResponseMapper.toDto(descuentoRepository.save(descuentoUpdateMapper.toEntity(ent, dto)));
    }

    //DELETE:
    @Transactional
    public Boolean deleteDescuentoById(Long id){
        Boolean centinela = false;
        if (descuentoRepository.existsById(id)){
            descuentoRepository.deleteById(id);
            centinela = true;
        } else {
            throw new IdNoExisteException("ID de descuento no existe.");
        }
        return centinela;
    }
}
