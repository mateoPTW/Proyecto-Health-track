import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private Doctor doctorAsignado;

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

    public Doctor getDoctorAsignado() {
        return doctorAsignado;
    }

    public void asignarDoctor(Doctor doctor) {
        this.doctorAsignado = doctor;
    }

    @Override
    public String toString() {
        return "Paciente: " + nombre + ", Edad: " + edad + ", Enfermedad: " + enfermedad +
                (doctorAsignado != null ? ", Doctor Asignado: " + doctorAsignado.getNombre() : "");
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
    public List<Doctor> getDoctores() {
        return doctores;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void registrarDoctor(Doctor doctor) {
        doctores.add(doctor);         
        System.out.println("Doctor registrado: " + doctor.getNombre());
    }

    public void registrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        System.out.println("Paciente registrado: " + paciente.getNombre());
    }

    public void mostrarPacientes() {
        System.out.println("Lista de pacientes en el hospital:");
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

    public void asignarDoctorAPaciente(String nombrePaciente, String nombreDoctor) {
        Paciente paciente = buscarPacientePorNombre(nombrePaciente);
        Doctor doctor = buscarDoctorPorNombre(nombreDoctor);
        
        if (paciente != null && doctor != null) {
            paciente.asignarDoctor(doctor);
            System.out.println("Doctor " + doctor.getNombre() + " asignado al paciente " + paciente.getNombre());
        } else {
            System.out.println("Doctor o paciente no encontrado.");
        }
    }

    public List<Paciente> buscarPacientesPorEnfermedad(String enfermedad) {
        List<Paciente> pacientesConEnfermedad = new ArrayList<>();
        for (Paciente paciente : pacientes) {
            if (paciente.getEnfermedad().equalsIgnoreCase(enfermedad)) {
                pacientesConEnfermedad.add(paciente);
            }
        }
        return pacientesConEnfermedad;
    }

    public Map<String, Integer> contarDoctoresPorEspecialidad() {
        Map<String, Integer> conteoPorEspecialidad = new HashMap<>();
        for (Doctor doctor : doctores) {
            conteoPorEspecialidad.put(
                doctor.getEspecialidad(), 
                conteoPorEspecialidad.getOrDefault(doctor.getEspecialidad(), 0) + 1
            );
        }
        return conteoPorEspecialidad;
    }

    public Paciente buscarPacientePorNombre(String nombre) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNombre().equalsIgnoreCase(nombre)) {
                return paciente;
            }
        }
        return null;
    }

    public Doctor buscarDoctorPorNombre(String nombre) {
        for (Doctor doctor : doctores) {
            if (doctor.getNombre().equalsIgnoreCase(nombre)) {
                return doctor;
            }
        }
        return null;
    }

    public void resumenHospital() {
        System.out.println("Resumen del hospital " + nombre);
        System.out.println("Número de doctores: " + doctores.size());
        System.out.println("Número de pacientes: " + pacientes.size());
        System.out.println("Doctores por especialidad: " + contarDoctoresPorEspecialidad());
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

        // Mostrar doctores y pacientes
        hospital.mostrarDoctores();
        hospital.mostrarPacientes();

        // Asignar doctor a paciente
        hospital.asignarDoctorAPaciente("Carlos López", "Dr. Juan Pérez");

        // Buscar pacientes por enfermedad
        System.out.println("Pacientes con gripe:");
        List<Paciente> pacientesConGripe = hospital.buscarPacientesPorEnfermedad("Gripe");
        for (Paciente paciente : pacientesConGripe) {
            System.out.println(paciente);
        }

        // Resumen del hospital
        hospital.resumenHospital();
    }
}
