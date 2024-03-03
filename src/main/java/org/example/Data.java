package org.example;

import org.example.domain.Cliente.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<Cliente> generateClientes() {
        List<Cliente> listaClientes = new ArrayList<>();

        listaClientes.add(new Cliente("Alejandro Gonzalez", "Masculino", 70.50, 25, 175.00, "Activo", "Cliente activo, sin observaciones", 1722.25, 2066.70));
        listaClientes.add(new Cliente("Sofia Ramirez", "Femenino", 60.00, 30, 160.50, "Moderado", "Cliente moderadamente activo", 1356.88, 2106.47));
        listaClientes.add(new Cliente("Javier Fernandez", "Masculino", 80.20, 35, 180.00, "Muy Activo", "Cliente muy activo", 1894.03, 2651.64));
        listaClientes.add(new Cliente("Maria Lopez", "Femenino", 55.50, 28, 155.00, "Sedentario", "Cliente sedentario", 1180.53, 1416.64));
        listaClientes.add(new Cliente("Carlos Rodriguez", "Masculino", 68.70, 22, 170.50, "Moderado", "Cliente moderadamente activo", 1571.28, 2177.71));
        listaClientes.add(new Cliente("Laura Hernandez", "Femenino", 63.30, 32, 165.00, "Activo", "Cliente activo, sin observaciones", 1474.40, 2116.59));
        listaClientes.add(new Cliente("Diego Martinez", "Masculino", 75.00, 27, 178.00, "Sedentario", "Cliente sedentario", 1575.00, 1890.00));
        listaClientes.add(new Cliente("Valentina Diaz", "Femenino", 58.90, 29, 162.50, "Moderado", "Cliente moderadamente activo", 1347.53, 2090.55));
        listaClientes.add(new Cliente( "Gabriel Sanchez", "Masculino", 82.10, 40, 185.00, "Muy Activo", "Cliente muy activo", 2034.73, 2841.61));
        listaClientes.add(new Cliente("Camila Torres", "Femenino", 57.20, 26, 158.00, "Sedentario", "Cliente sedentario", 1268.68, 1522.42));
        listaClientes.add(new Cliente( "Eduardo Jimenez", "Masculino", 72.30, 31, 177.50, "Activo", "Cliente activo, sin observaciones", 1682.58, 2019.10));
        listaClientes.add(new Cliente( "Isabella Gomez", "Femenino", 61.80, 33, 163.00, "Moderado", "Cliente moderadamente activo", 1448.48, 2251.82));
        listaClientes.add(new Cliente("Lucas Perez", "Masculino", 78.50, 28, 182.00, "Muy Activo", "Cliente muy activo", 1808.55, 2521.17));
        listaClientes.add(new Cliente( "Matias Ramos", "Masculino", 69.90, 29, 173.00, "Moderado", "Cliente moderadamente activo", 1613.65, 2235.91));
        listaClientes.add(new Cliente( "Valeria Gutierrez", "Femenino", 54.60, 24, 157.50, "Sedentario", "Cliente sedentario", 1200.30, 1440.36));

        return listaClientes;
    }
}
