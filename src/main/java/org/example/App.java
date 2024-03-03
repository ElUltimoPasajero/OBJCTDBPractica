package org.example;

import org.example.domain.Cliente.Cliente;
import org.example.domain.Cliente.ClienteDAO;
import org.example.domain.Cliente.ClienteDAOImplement;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ClienteDAOImplement clienteDAO = new ClienteDAOImplement();
        List<Cliente> clientes = clienteDAO.getAll();

        if (clientes.isEmpty()) {
            clientes = Data.generateClientes();
            clienteDAO.saveAllClientes(clientes);
        }

        System.out.println(clientes);

        Integer idCliente = 190;
        Cliente cliente = clienteDAO.get(idCliente);

        if (cliente != null) {
            // Imprimir detalles del cliente por consola
            System.out.println("ID: " + cliente.getId());
            System.out.println("Nombre: " + cliente.getNombreCliente());
            System.out.println("Sexo: " + cliente.getSexo());
            // Agrega aquí más atributos según tu modelo Cliente




        } else {
            System.out.println("Cliente con ID " + idCliente + " no encontrado.");
        }

       // System.out.println(clienteDAO.getAllMenoresEdad(30));

        //clienteDAO.updateCliente(2,"antoñito","cosA");

        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setNombreCliente("pepilloooooooooooooooooooOOOOooooo ");
        nuevoCliente.setSexo("Masculino");
        nuevoCliente.setPeso(70.5);
        nuevoCliente.setEdad(25);
        nuevoCliente.setTalla(175.0);
        nuevoCliente.setTipoActividad("Activo");
        nuevoCliente.setObservaciones("Nuevo cliente, sin observaciones");
        nuevoCliente.setGER(1722.25);
        nuevoCliente.setGET(2066.70);

// Llamar al método para guardar el nuevo cliente en la base de datos
        clienteDAO.saveCliente(nuevoCliente);
        System.out.println(clienteDAO.getClienteConMaxGer());

    }
}





/*CREATE TABLE `informacioncliente` (
  `id` int(11) NOT NULL,
  `NombreCliente` varchar(255) NOT NULL,
  `Sexo` varchar(10) NOT NULL,
  `Peso` decimal(5,2) NOT NULL,
  `Edad` int(11) NOT NULL,
  `Talla` decimal(5,2) NOT NULL,
  `TipoActividad` varchar(50) NOT NULL,
  `Observaciones` text DEFAULT NULL,
  `GER` decimal(7,2) DEFAULT NULL,
  `GET` decimal(7,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `informacioncliente`
--

INSERT INTO `informacioncliente` (`id`, `NombreCliente`, `Sexo`, `Peso`, `Edad`, `Talla`, `TipoActividad`, `Observaciones`, `GER`, `GET`) VALUES
(1, 'Alejandro Gonzalez', 'Masculino', '70.50', 25, '175.00', 'Activo', 'Cliente activo, sin observaciones', '1722.25', '2066.70'),
(2, 'Sofia Ramirez', 'Femenino', '60.00', 30, '160.50', 'Moderado', 'Cliente moderadamente activo', '1356.88', '2106.47'),
(3, 'Javier Fernandez', 'Masculino', '80.20', 35, '180.00', 'Muy Activo', 'Cliente muy activo', '1894.03', '2651.64'),
(4, 'Maria Lopez', 'Femenino', '55.50', 28, '155.00', 'Sedentario', 'Cliente sedentario', '1180.53', '1416.64'),
(5, 'Carlos Rodriguez', 'Masculino', '68.70', 22, '170.50', 'Moderado', 'Cliente moderadamente activo', '1571.28', '2177.71'),
(6, 'Laura Hernandez', 'Femenino', '63.30', 32, '165.00', 'Activo', 'Cliente activo, sin observaciones', '1474.40', '2116.59'),
(7, 'Diego Martinez', 'Masculino', '75.00', 27, '178.00', 'Sedentario', 'Cliente sedentario', '1575.00', '1890.00'),
(8, 'Valentina Diaz', 'Femenino', '58.90', 29, '162.50', 'Moderado', 'Cliente moderadamente activo', '1347.53', '2090.55'),
(9, 'Gabriel Sanchez', 'Masculino', '82.10', 40, '185.00', 'Muy Activo', 'Cliente muy activo', '2034.73', '2841.61'),
(10, 'Camila Torres', 'Femenino', '57.20', 26, '158.00', 'Sedentario', 'Cliente sedentario', '1268.68', '1522.42'),
(11, 'Eduardo Jimenez', 'Masculino', '72.30', 31, '177.50', 'Activo', 'Cliente activo, sin observaciones', '1682.58', '2019.10'),
(12, 'Isabella Gomez', 'Femenino', '61.80', 33, '163.00', 'Moderado', 'Cliente moderadamente activo', '1448.48', '2251.82'),
(13, 'Lucas Perez', 'Masculino', '78.50', 28, '182.00', 'Muy Activo', 'Cliente muy activo', '1808.55', '2521.17'),
(14, 'Valeria Gutierrez', 'Femenino', '54.60', 24, '157.50', 'Sedentario', 'Cliente sedentario', '1200.30', '1440.36'),
(15, 'Matias Ramos', 'Masculino', '69.90', 29, '173.00', 'Moderado', 'Cliente moderadamente activo', '1613.65', '2235.91');
*/