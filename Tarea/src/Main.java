import javax.swing.*; // Importación necesaria para JFrame y JLabel

public class Main extends JFrame {

    public Main() {
        // Corrección de comillas manual para evitar errores de pegado
        JLabel lblSaludo = new JLabel("Hola Mundo. Creando mi primer ejemplo");
        add(lblSaludo);

        this.setSize(400, 200);
        this.setTitle("JFrame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        // Ejecución en el hilo de despacho de eventos (buena práctica)
        SwingUtilities.invokeLater(() -> {
            Main main = new Main();
        });
    }
}