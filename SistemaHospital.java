import java.util.ArrayList;
import java.util.List;

// Clase Doctor
class Doctor {
    private String nombre;
    private String especialidad;

    public Doctor(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public String toString() {
        return "Doctor: " + nombre + ", Especialidad: " + especialidad;
    }
}

// Clase Paciente
class Paciente {
    private String nombre;
    private int edad;
    private String enfermedad;

    public Paciente(String nombre, int edad, String enfermedad) {
        this.nombre = nombre;
        this.edad = edad;
        this.enfermedad = enfermedad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

   @Override
    public String toString() {
        return "Paciente: " + nombre + ", Edad: " + edad + ", Enfermedad: " + enfermedad;
    }
}

// Clase Hospital
class Hospital {
    private String nombre;
    private List<Doctor> doctores;
    private List<Paciente> pacientes;

    public Hospital(String nombre) {
        this.nombre = nombre;
        this.doctores = new ArrayList<>();
        
        this.pacientes = new ArrayList<>();
    }

    public void registrarDoctor(Doctor doctor) {
        doctores.add(doctor);         
        System.out.println("Doctor registrado: " + doctor.getNombre());
    }

    public void registrarPaciente(Paciente paciente) {
        // ERROR: Intento de agregar a una lista no inicializada si 'pacientes' fuera null
        pacientes.add(paciente);
        System.out.println("Paciente registrado: " + paciente.getNombre());
    }

    public void mostrarPacientes() {
        System.out.println("Lista de pacientes en el hospital:");
        // ERROR: Acceso a la lista de pacientes si está vacía (lógica incorrecta para una lista vacía)
        // if (pacientes != null) {
        //     System.out.println(pacientes);
        // }
        for (Paciente paciente : pacientes) {
            System.out.println(paciente);
        }
    }

    public void mostrarDoctores() {
        System.out.println("Lista de doctores en el hospital:");
        for (Doctor doctor : doctores) {
            System.out.println(doctor);
        }
    }
}

// Clase principal
public class SistemaHospital {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("Hospital Central");

        // Crear y registrar doctores
        Doctor doctor1 = new Doctor("Dr. Juan Pérez", "Cardiología");
        Doctor doctor2 = new Doctor("Dra. María González", "Pediatría");

        hospital.registrarDoctor(doctor1);
        hospital.registrarDoctor(doctor2);

        // Crear y registrar pacientes
        Paciente paciente1 = new Paciente("Carlos López", 45, "Infarto");
        Paciente paciente2 = new Paciente("Lucía Martínez", 10, "Gripe");

        hospital.registrarPaciente(paciente1);
        hospital.registrarPaciente(paciente2);

        // ERROR: Método llamado con sintaxis incorrecta (falta paréntesis)
        // hospital.mostrarDoctores;
        hospital.mostrarDoctores();

        hospital.mostrarPacientes();
    }
}
