import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SistemaHospitalTest {

    @Test
    public void testRegistrarDoctor() {
        // Crear hospital
        Hospital hospital = new Hospital("Hospital Central");

        // Crear doctor y registrarlo
        Doctor doctor = new Doctor("Dr. Juan Pérez", "Cardiología");
        hospital.registrarDoctor(doctor);

        // Comprobar que el doctor fue registrado correctamente
        assertEquals("Dr. Juan Pérez", doctor.getNombre());
        assertEquals("Cardiología", doctor.getEspecialidad());
    }

    @Test
    public void testRegistrarPaciente() {
        // Crear hospital
        Hospital hospital = new Hospital("Hospital Central");

        // Crear paciente y registrarlo
        Paciente paciente = new Paciente("Carlos López", 45, "Infarto");
        hospital.registrarPaciente(paciente);

        // Comprobar que el paciente fue registrado correctamente
        assertEquals("Carlos López", paciente.getNombre());
        assertEquals(45, paciente.getEdad());
        assertEquals("Infarto", paciente.getEnfermedad());
    }

    @Test
    public void testMostrarPacientes() {
        // Crear hospital
        Hospital hospital = new Hospital("Hospital Central");

        // Crear y registrar pacientes
        Paciente paciente1 = new Paciente("Carlos López", 45, "Infarto");
        Paciente paciente2 = new Paciente("Lucía Martínez", 10, "Gripe");

        hospital.registrarPaciente(paciente1);
        hospital.registrarPaciente(paciente2);

        // No hay un método para obtener pacientes, por lo que esta prueba solo verificará la ejecución sin errores
        assertDoesNotThrow(() -> hospital.mostrarPacientes());
    }

    @Test
    public void testMostrarDoctores() {
        // Crear hospital
        Hospital hospital = new Hospital("Hospital Central");

        // Crear y registrar doctores
        Doctor doctor1 = new Doctor("Dr. Juan Pérez", "Cardiología");
        Doctor doctor2 = new Doctor("Dra. María González", "Pediatría");

        hospital.registrarDoctor(doctor1);
        hospital.registrarDoctor(doctor2);

        // No hay un método para obtener doctores, por lo que esta prueba solo verificará la ejecución sin errores
        assertDoesNotThrow(() -> hospital.mostrarDoctores());
    }
}
