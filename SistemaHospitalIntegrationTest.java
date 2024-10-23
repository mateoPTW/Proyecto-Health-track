import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SistemaHospitalIntegrationTest {

    @Test
    public void testFlujoCompletoRegistroYConsulta() {
        // Crear hospital
        Hospital hospital = new Hospital("Hospital General");

        // Registrar doctor y paciente
        Doctor doctor = new Doctor("Dr. Mateo Torres", "Neurología");
        Paciente paciente = new Paciente("Laura Sánchez", 30, "Migraña");

        hospital.registrarDoctor(doctor);
        hospital.registrarPaciente(paciente);

        // Comprobar que se han registrado correctamente
        assertEquals(1, hospital.getDoctores().size());
        assertEquals(1, hospital.getPacientes().size());

        // Mostrar pacientes y doctores sin lanzar excepciones
        assertDoesNotThrow(() -> hospital.mostrarDoctores());
        assertDoesNotThrow(() -> hospital.mostrarPacientes());
    }
}
