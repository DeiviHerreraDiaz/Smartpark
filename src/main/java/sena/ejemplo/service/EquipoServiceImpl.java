package sena.ejemplo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sena.ejemplo.model.Equipo;
import sena.ejemplo.model.*;

import java.util.List;

@Service
public class EquipoServiceImpl implements IEquipoService {

    @Autowired
    private IEquipo equipoRepository;

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
        return (List<Equipo>) equipoRepository.findByDocumento(documento);
    }

    @Override
    public Equipo findById(Integer id) {
        return equipoRepository.findById(id).orElse(null);
    }
}

