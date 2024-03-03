package org.example.domain.Cliente;

import lombok.var;
import org.example.ObjectDBUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImplement implements ClienteDAO {
    @Override
    public ArrayList<Cliente> getAll() {
        var salida = new ArrayList<Cliente>(0);
        EntityManager entityManager = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Cliente> query = entityManager.createQuery("select c from Cliente c", Cliente.class);
            salida = (ArrayList<Cliente>) query.getResultList();
        } finally {
            entityManager.close();
        }
        return salida;
    }

    public ArrayList<Cliente> getAllMenoresEdad(int edadMax) {
        var salida = new ArrayList<Cliente>(0);
        EntityManager entityManager = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Cliente> query = entityManager.createQuery("select c from Cliente c where c.edad < :edadMax", Cliente.class);
            query.setParameter("edadMax", edadMax);
            salida = (ArrayList<Cliente>) query.getResultList();
        } finally {
            entityManager.close();
        }
        return salida;
    }

    public Cliente getClienteConMaxGer() {
        Cliente cliente = null;
        EntityManager entityManager = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            // Utiliza JPQL para obtener el cliente con el GER más alto
            TypedQuery<Cliente> query = entityManager.createQuery("SELECT c FROM Cliente c ORDER BY c.GET DESC", Cliente.class);
            query.setMaxResults(1); // Limita el resultado a un solo cliente
            List<Cliente> resultado = query.getResultList();

            if (!resultado.isEmpty()) {
                cliente = resultado.get(0);
            }
        } finally {
            entityManager.close();
        }
        return cliente;
    }


    public void updateCliente(Integer id, Cliente nuevoCliente) {
        EntityManager entityManager = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            // Obtener el cliente existente por su ID
            Cliente clienteExistente = entityManager.find(Cliente.class, id);

            // Verificar si el cliente existe antes de intentar actualizarlo
            if (clienteExistente != null) {
                // Actualizar los atributos del cliente existente con los valores del nuevo cliente
                clienteExistente.setNombreCliente(nuevoCliente.getNombreCliente());
                clienteExistente.setEdad(nuevoCliente.getEdad());
                clienteExistente.setPeso(nuevoCliente.getPeso());
                clienteExistente.setSexo(nuevoCliente.getSexo());
                clienteExistente.setTalla(nuevoCliente.getTalla());
                clienteExistente.setTipoActividad(nuevoCliente.getTipoActividad());
                clienteExistente.setObservaciones(nuevoCliente.getObservaciones());
                clienteExistente.setGER(nuevoCliente.getGER());
                clienteExistente.setGET(nuevoCliente.getGET());

                transaction.commit();
            } else {
                System.out.println("Cliente con ID " + id + " no encontrado.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void saveAllClientes(List<Cliente> clientes) {

        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            for (Cliente cliente : clientes) {
                em.persist(cliente);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }






    public Cliente get(Integer id) {
        Cliente exit = null;
        EntityManager entityManager = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Cliente> query = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.id = :id", Cliente.class);
            query.setParameter("id", id);
            List<Cliente> resultado = query.getResultList();
            if (!resultado.isEmpty()) {
                exit = resultado.get(0);
            }
        } finally {
            entityManager.close();
        }
        return exit;
    }



    public void saveCliente(Cliente nuevoCliente) {
        EntityManager entityManager = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            // Verificar si el cliente ya está gestionado por el EntityManager
            if (!entityManager.contains(nuevoCliente)) {
                // Si no está gestionado, persistir el nuevo cliente en la base de datos
                entityManager.persist(nuevoCliente);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }


    public void updateCliente(Integer id, String nuevoNombre, String nuevoSexo) {
        EntityManager entityManager = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            // Obtener el cliente existente por su ID
            Cliente clienteExistente = entityManager.find(Cliente.class, id);

            // Verificar si el cliente existe antes de intentar actualizarlo
            if (clienteExistente != null) {
                // Establecer nuevos valores para el nombre y el sexo (y otros atributos si es necesario)
                clienteExistente.setNombreCliente(nuevoNombre);
                clienteExistente.setSexo(nuevoSexo);
                // Modifica otros atributos según sea necesario

                transaction.commit();
            } else {
                System.out.println("Cliente con ID " + id + " no encontrado.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}


