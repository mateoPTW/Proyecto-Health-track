import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SistemaHospitalPerformanceTest {

    @Test
    public void testTiempoRegistroPacientes() {
        Hospital hospital = new Hospital("Hospital Central");

        // Medir tiempo de registrar 1000 pacientes
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            Paciente paciente = new Paciente("Paciente " + i, i % 100, "Enfermedad");
            hospital.registrarPaciente(paciente);
        }
        long endTime = System.nanoTime();

        long duration = (endTime - startTime) / 1_000_000; // Convertir a milisegundos
        System.out.println("Tiempo de registro de 1000 pacientes: " + duration + " ms");

        // Verificar que se registraron todos los pacientes
        assertEquals(1000, hospital.getPacientes().size());
    }

    @Test
    public void testTiempoRegistroDoctores() {
        Hospital hospital = new Hospital("Hospital Central");

        // Medir tiempo de registrar 100 doctores
        long startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            Doctor doctor = new Doctor("Doctor " + i, "Especialidad " + i);
            hospital.registrarDoctor(doctor);
        }
        long endTime = System.nanoTime();

        long duration = (endTime - startTime) / 1_000_000; // Convertir a milisegundos
        System.out.println("Tiempo de registro de 100 doctores: " + duration + " ms");

        // Verificar que se registraron todos los doctores
        assertEquals(100, hospital.getDoctores().size());
    }
}
