package sena.ejemplo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.ejemplo.model._Equipo;

import java.util.List;

@Service
public class _EquipoServiceImpl implements IEquipoService {

    @Autowired
    private sena.ejemplo.repository.equipoRepository equipoRepository;

    @Override
    public List<_Equipo> findAll() {
        return (List<_Equipo>) equipoRepository.findAll();
    }

    @Override
    public _Equipo save(_Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @Override
    public List<_Equipo> findBydocumento(String documento) {
        return equipoRepository.findByDocumento(documento);
    }


    @Override
    public _Equipo findById(Integer id) {

        return equipoRepository.findById(id).orElse(null);
    }
}

