package grafico;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Becas;
import logica.Estudiantes;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Reportes extends JFrame {
    private JTextArea textAreaBecados;
    private JTextArea textAreaBusquedaC;
    private JTextArea textAreaBusquedaSexo; // Campo de instancia correcto
    private JComboBox<String> comboBoxSexo;
    private JComboBox<String> comboBoxCarrera;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldCadula;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        Becas becas = new Becas();
        Estudiantes estudiante1 = new Estudiantes("Juan", "11111", "Ingeniería Civil", 2.5, "Hombre");
        Estudiantes estudiante2 = new Estudiantes("María", "22222", "Ingeniería Eléctrica", 3.0, "Mujer");
        Estudiantes estudiante3 = new Estudiantes("Pedro", "33333", "Ingeniería Civil", 1.8, "Hombre");
        Estudiantes estudiante4 = new Estudiantes("Ana", "44444", "Ingeniería Civil", 2.2, "Mujer");
        Estudiantes estudiante5 = new Estudiantes("Carlos", "55555", "Ingeniería Civil", 2.9, "Hombre");

        becas.agregarEstudiante(estudiante1);
        becas.agregarEstudiante(estudiante2);
        becas.agregarEstudiante(estudiante3);
        becas.agregarEstudiante(estudiante4);
        becas.agregarEstudiante(estudiante5);
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Reportes frame = new Reportes(becas);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Reportes(Becas becas) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 847, 483);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Reportes");
        lblNewLabel.setBounds(238, 10, 149, 46);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Estudiantes Becados:");
        lblNewLabel_1.setBounds(52, 106, 221, 35);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(lblNewLabel_1);
        
        textAreaBecados = new JTextArea();
        textAreaBecados.setEditable(false);
        textAreaBecados.setBounds(52, 151, 184, 220);
        contentPane.add(textAreaBecados);
        
        textAreaBusquedaC = new JTextArea(); // Inicialización del campo de instancia
        textAreaBusquedaC.setEditable(false);
        textAreaBusquedaC.setBounds(274, 183, 184, 240);
        contentPane.add(textAreaBusquedaC);
        
        JLabel lblNewLabel_1_1 = new JLabel("Busqueda por cedula");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1.setBounds(274, 71, 221, 35);
        contentPane.add(lblNewLabel_1_1);
        
        textFieldCadula = new JTextField();
        textFieldCadula.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textFieldCadula.setBounds(274, 110, 184, 35);
        contentPane.add(textFieldCadula);
        textFieldCadula.setColumns(10);
        mostrarBecados(becas);
        JButton btnBuscarC = new JButton("Buscar");
        btnBuscarC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarCedula(becas);
            }
        });
        btnBuscarC.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnBuscarC.setBounds(320, 147, 96, 28);
        contentPane.add(btnBuscarC);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Busqueda por carrera y sexo");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1_1.setBounds(527, 71, 262, 35);
        contentPane.add(lblNewLabel_1_1_1);
        
        comboBoxSexo = new JComboBox<>();
        comboBoxSexo.setModel(new DefaultComboBoxModel<>(new String[] {"Hombre", "Mujer"}));
        comboBoxSexo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        comboBoxSexo.setBounds(601, 111, 102, 28);
        contentPane.add(comboBoxSexo);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("Sexo");
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1_1_1.setBounds(537, 106, 54, 35);
        contentPane.add(lblNewLabel_1_1_1_1);
        
        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Carrera");
        lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1_1_1_1.setBounds(503, 142, 88, 35);
        contentPane.add(lblNewLabel_1_1_1_1_1);
        
        comboBoxCarrera = new JComboBox<>();
        comboBoxCarrera.setModel(new DefaultComboBoxModel<>(new String[] {"Ingeniería Civil", "Ingeniería Eléctrica", "Ingeniería Industrial", "Ingeniería en Sistemas", "Ingeniería Mecánica", "Ingeniería Marítima"}));
        comboBoxCarrera.setFont(new Font("Tahoma", Font.PLAIN, 16));
        comboBoxCarrera.setBounds(601, 153, 149, 28);
        contentPane.add(comboBoxCarrera);
        
        JButton btnBuscarSexo = new JButton("Buscar");
        btnBuscarSexo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarSexo(becas);
            }
        });
        btnBuscarSexo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnBuscarSexo.setBounds(590, 185, 96, 28);
        contentPane.add(btnBuscarSexo);
        
        textAreaBusquedaSexo = new JTextArea(); // Inicialización correcta del campo de instancia
        textAreaBusquedaSexo.setEditable(false);
        textAreaBusquedaSexo.setBounds(551, 223, 184, 213);
        contentPane.add(textAreaBusquedaSexo);
    }
    
    void buscarSexo(Becas becas) {
        String sexo = (String) comboBoxSexo.getSelectedItem();
        String carrera = (String) comboBoxCarrera.getSelectedItem();
        
        ArrayList<Estudiantes> estudiantes = becas.buscarEstudiantesPorCarreraYSexo(carrera, sexo);
        
        if (!estudiantes.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Estudiantes encontrados:\n");

            for (Estudiantes estudiante : estudiantes) {
                sb.append("Nombre: ").append(estudiante.getNombre()).append("\n");
                sb.append("Carrera: ").append(estudiante.getCarrera()).append("\n");
                sb.append("Índice Académico: ").append(estudiante.getIndiceAcademico()).append("\n");
                sb.append("Sexo: ").append(estudiante.getSexo()).append("\n\n");
            }

            textAreaBusquedaSexo.setText(sb.toString());
        } else {
            textAreaBusquedaSexo.setText("No se encontraron estudiantes becados para la carrera y sexo especificados.");
        }
    }
    
    void buscarCedula(Becas becas) {
         String cedula = textFieldCadula.getText();
         Estudiantes estudiante = becas.buscarEstudiantePorCedula(cedula);
         if (estudiante != null) {
             StringBuilder sb = new StringBuilder();
             sb.append("Se encontró el siguiente estudiante:\n");
             sb.append("Nombre: ").append(estudiante.getNombre()).append("\n");
             sb.append("Carrera: ").append(estudiante.getCarrera()).append("\n");
             sb.append("Índice Académico: ").append(estudiante.getIndiceAcademico()).append("\n");
             sb.append("Sexo: ").append(estudiante.getSexo()).append("\n");

             textAreaBusquedaC.setText(sb.toString());
         } else {
             textAreaBusquedaC.setText("No se encontró ningún estudiante con la cédula especificada.");
         }
    }
    
    void mostrarBecados(Becas becas) {
        System.out.println("Estudiantes becados obtenidos: " + becas.obtenerEstudiantesBecados().size());

        StringBuilder sb = new StringBuilder();
        sb.append("Nombres de los Estudiantes:\n");

        for (String nombre : becas.obtenerEstudiantesBecados()) {
            sb.append(nombre).append("\n");
        }

        textAreaBecados.setText(sb.toString());
    }
}
