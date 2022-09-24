import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.EventQueue;
<<<<<<< HEAD
import java.util.ArrayList;
=======
import java.awt.Font;
>>>>>>> 438fac496044e7addd9db5abde213765885c45db
import java.awt.Color;


public class WindowPrincipal{
    
    private JFrame frmPrincipal; 
    private JPanel panelPrincipal;
<<<<<<< HEAD
	private static ArrayList<Hospital> listaHospitales;
	
=======
    private JLabel lblNombreHospital;
>>>>>>> 438fac496044e7addd9db5abde213765885c45db
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowPrincipal window = new WindowPrincipal();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public WindowPrincipal() {
        frmPrincipal = new JFrame();
		frmPrincipal.setSize(1000, 700);
		frmPrincipal.setResizable(false);
		frmPrincipal.setTitle("Vacunas");
		frmPrincipal.setForeground(Color.black);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		primerPanel();
	}

    public void primerPanel(){
        panelPrincipal = new JPanel();
        panelPrincipal.setBounds(403, 380, 80, 30);
		panelPrincipal.setBackground(Color.black);
        panelPrincipal.setLayout(null);
		frmPrincipal.getContentPane().add(panelPrincipal);

        lblNombreHospital = new JLabel("Hospital");
        panelPrincipal.add(lblNombreHospital);
        lblNombreHospital.setForeground(Color.white);
        lblNombreHospital.setBounds(100, 200, 100, 50);
        lblNombreHospital.setFont(new Font("Helvetica", Font.PLAIN, 20));
    }

	void crearHospitales(){
		Hospital h1 = new Hospital("Cruz roja", 500, 50, "Monterrey");
		listaHospitales.add(h1);
	}
}

