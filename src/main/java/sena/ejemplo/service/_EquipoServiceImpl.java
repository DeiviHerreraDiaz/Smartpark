package sena.ejemplo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.ejemplo.model.Equipo;

import java.util.List;

@Service
public class _EquipoServiceImpl implements IEquipoService {

    @Autowired
    private sena.ejemplo.repository.equipoRepository equipoRepository;

    @Override
    public List<Equipo> findAll() {
        return (List<Equipo>) equipoRepository.findAll();
    }

    @Override
    public Equipo save(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @Override
    public List<Equipo> findBydocumento(String documento) {
        return equipoRepository.findByDocumento(documento);
    }


    @Override
    public Equipo findById(Integer id) {

        return equipoRepository.findById(id).orElse(null);
    }
}

