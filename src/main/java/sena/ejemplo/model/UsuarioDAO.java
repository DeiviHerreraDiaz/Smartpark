package sena.ejemplo.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UsuarioDAO implements IUsuario{
    @PersistenceContext
    private EntityManager em;

    // Obtencion de datos para la consulta (Listar)

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> findAll(){
        return em.createQuery("from Usuario", Usuario.class).getResultList();
    }

    // Obtencion de datos para registrar un Usuario 

    @Transactional
    @Override
    public void save (Usuario usuario){
        em.persist(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario findByDocumento(String documento) {
        // Crear una consulta para obtener el objeto Usuario asociado con el documento especificado
        String jpql = "SELECT u FROM Usuario u WHERE u.documento = :documento";
        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
        query.setParameter("documento", documento);
        // Ejecutar la consulta y obtener el objeto Usuario
        Usuario usuario = query.getSingleResult();
        return usuario;
    }

   
}
