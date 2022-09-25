import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;


public class WindowPrincipal{
    
    private JFrame frmPrincipal; 
    private JPanel panelPrincipal;
	private JLabel lblNombreHospital, lblSolicitar, lblVacunas, lblEstatus;
	private JComboBox<String> cbNombreHospital;
	private JTextField tfVacunas;
	private JButton btnSolicitar;

	public static ArrayList<Hospital> listaHospitales;
	
    
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

		crearHospitales();

		primerPanel();
	}

    public void primerPanel(){
        panelPrincipal = new JPanel();
        panelPrincipal.setBounds(403, 380, 80, 30);
		panelPrincipal.setBackground(Color.black);
        panelPrincipal.setLayout(null);
		frmPrincipal.getContentPane().add(panelPrincipal);

        lblNombreHospital = new JLabel("Hospital:");
        panelPrincipal.add(lblNombreHospital);
        lblNombreHospital.setForeground(Color.white);
        lblNombreHospital.setBounds(100, 200, 200, 50);
        lblNombreHospital.setFont(new Font("Helvetica", Font.PLAIN, 30));

		//crearHospitales();
		cbNombreHospital = new JComboBox<String>();
			if(listaHospitales.size() < 1){
				JOptionPane.showMessageDialog(frmPrincipal, "No hay hospitales disponibles.");
				System.out.println("Nel");
			} else{
				System.out.println("Siu");
				cbNombreHospital.addItem("");
				for(int i = 0 ; i < listaHospitales.size(); i++){
					cbNombreHospital.addItem(listaHospitales.get(i).getNombre());
					
				}
				cbNombreHospital.setVisible(true);
				cbNombreHospital.setSelectedIndex(0);
				cbNombreHospital.setBounds(250, 200, 300, 60);
				cbNombreHospital.setFont(new Font("Helvetica", Font.PLAIN, 25));
				panelPrincipal.add(cbNombreHospital);
				
				cbNombreHospital.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						String nombre = cbNombreHospital.getSelectedItem().toString();
						Hospital temp = buscarHospital(nombre);
						tfVacunas.setText("" + temp.getVacunas());
						lblVacunas.setText("Vacunas: " + temp.getVacunas());
						lblEstatus.setText("Estatus: " + temp.getEstatus());
					}
				});
				
			}
		

		lblSolicitar = new JLabel("Solicitar:");
		panelPrincipal.add(lblSolicitar);
		lblSolicitar.setForeground(Color.white);
		lblSolicitar.setBounds(100, 550, 200, 50);
		lblSolicitar.setFont(new Font("Helvetica", Font.PLAIN, 30));

		tfVacunas = new JTextField();
		panelPrincipal.add(tfVacunas);
		tfVacunas.setBounds(300, 550, 150, 50);
		tfVacunas.setFont(new Font("Helvetica", Font.PLAIN, 25));
		tfVacunas.setEditable(true);

		lblVacunas = new JLabel("");
		panelPrincipal.add(lblVacunas);
		lblVacunas.setForeground(Color.white);
		lblVacunas.setBounds(300, 300, 200, 50);
		lblVacunas.setFont(new Font("Helvetica", Font.PLAIN, 25));

		lblEstatus = new JLabel("");
		panelPrincipal.add(lblEstatus);
		lblEstatus.setForeground(Color.white);
		lblEstatus.setBounds(600, 300, 200, 50);
		lblEstatus.setFont(new Font("Helvetica", Font.PLAIN, 25));
    }

	public static void crearHospitales(){
		listaHospitales = new ArrayList<Hospital>();
		Hospital h1 = new Hospital("Cruz roja", 400, 20, "Monterrey", 10, 200);
		listaHospitales.add(h1);
			
		Hospital h2 = new Hospital("Coet", 60, 10, "Saltillo", 100, 5);
		listaHospitales.add(h2);
		Hospital h3 = new Hospital("DR Andrik", 50, 300, "Monterrey", 10, 15);
		listaHospitales.add(h3);


		ArrayList<Hospital> lista = Hospital.Solicitar(h3);
		System.out.println("Lista: " + lista.get(0).getNombre());
		//System.out.println("Lista: " + lista.get(1).getNombre());

		
	}

	public static Hospital buscarHospital(String nombre){
		for(int i = 0; i < listaHospitales.size(); i++) {
			if(listaHospitales.get(i).getNombre().equals(nombre)) {
				Hospital temp = listaHospitales.get(i);
				return temp;
			}
		}
		return null;
	}

	
}

