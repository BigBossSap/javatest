package formulari;

 
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import java.time.LocalDate;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class AlesancoFormulari {

	protected Shell shell;
	private Composite compositeDadesClient;
	private Label lblDadesClient;
	private Label lblAnyNaixement;
	private Label lblFumador;
	private Label lblProfessio;
	private Text textAnyNaixement;
	private Combo comboFumador;
	private Combo comboProfessio;
	private Button btnAcceptar;
	private Composite composite;
	private Text textError;
	private Composite compositeDadesAsseguranca;
	private Label lblDadesAsseguranca;
	private Label lblQuantitat;
	private Text textQuantitat;
	private Label lblTipus;
	private Combo comboTipus;
	private Label lblPreus;
	private Label lblMenusal;
	private Label lblSemestral;
	private Label lblAnual;
	private Text textMensual;
	private Text textSemestral;
	private Text textAnual;
	private Label lblNewLabel;
	private Label lblNewLabel_1;
	private Label lblNewLabel_2;
	private Button btnRestablir;
	private Label lblNewLabel_3;
	private Label lblErrors;
	private Button btnCalcular;
	private Label lblNewLabel_4;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AlesancoFormulari window = new AlesancoFormulari();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		Display display = Display.getDefault();
		shell = new Shell();
		shell.setMinimumSize(new Point(136, 47));
		shell.setSize(450, 657);
		shell.setText("ALESANCO Assegurançes");
		
	
		compositeDadesClient = new Composite(shell, SWT.BORDER);
		compositeDadesClient.setForeground(SWTResourceManager.getColor(0, 0, 0));
		compositeDadesClient.setBounds(10, 33, 413, 151);
		
		lblAnyNaixement = new Label(compositeDadesClient, SWT.NONE);
		lblAnyNaixement.setBounds(24, 28, 82, 15);
		lblAnyNaixement.setText("Any naixement:");
		
		lblFumador = new Label(compositeDadesClient, SWT.NONE);
		lblFumador.setBounds(24, 66, 108, 15);
		lblFumador.setText("Fumador/a habitual:");
		
		lblProfessio = new Label(compositeDadesClient, SWT.NONE);
		lblProfessio.setBounds(25, 105, 95, 15);
		lblProfessio.setText("Professió de risc:");
		
		textAnyNaixement = new Text(compositeDadesClient, SWT.BORDER);
		textAnyNaixement.setToolTipText("Introdueix la teva data de naixement");
		textAnyNaixement.setBounds(152, 25, 136, 21);
		
		comboFumador = new Combo(compositeDadesClient, SWT.NONE);
		comboFumador.setToolTipText("Selecciona una opció");
		String[] opcionsFumador =  { "Sí","No" };
		comboFumador.setItems(opcionsFumador);
		comboFumador.setBounds(152, 63, 136, 23);
		
		comboProfessio = new Combo(compositeDadesClient, SWT.NONE);
		comboProfessio.setToolTipText("Selecciona una opció");
		comboProfessio.setBounds(152, 105, 136, 23);
		String[] opcionsProfessio = {"Risc baix","Risc moderat", "Risc alt"};
		comboProfessio.setItems(opcionsProfessio);
		
		btnAcceptar = new Button(compositeDadesClient, SWT.NONE);
		btnAcceptar.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnAcceptar.setBounds(311, 61, 75, 25);
		btnAcceptar.setText("ACCEPTAR");
		
		btnAcceptar.addListener(SWT.Selection, e -> {
			
			 try {
	                int anyNaixement = Integer.parseInt(textAnyNaixement.getText());
	                int anyActual = LocalDate.now().getYear();
	                int edat =  anyActual - anyNaixement;
	                if (edat < 18 || edat > 70) {
	                	textAnyNaixement.selectAll();
	                	textAnyNaixement.setFocus();
	                	textError.setText("Error: No s'accepten edats inferiors a 18 anys o superiors a 70 anys.");
	                    return;
	                }
	            } catch (NumberFormatException ex) {
	            	textAnyNaixement.selectAll();
	            	textAnyNaixement.setFocus();
	                textError.setText("Error:  Any de naixement incorrecte.");
	                return;
	            }
           

			 if (comboFumador.getSelectionIndex() == -1) {
           	comboFumador.setFocus();
               textError.setText("Error: Camp Fumador habitual obligatori.");
               return;
           }

           if (comboProfessio.getSelectionIndex() == -1) {
           	comboProfessio.setFocus();
           	textError.setText("Error: Camp Professio de risc obligatori.");
               return;
           }
           	
           else {
           	compositeDadesClient.setEnabled(false);                        
           	compositeDadesAsseguranca.setEnabled(true);
           }
           	
           textError.setText("");                      
		});	
		
		lblDadesClient = new Label(shell, SWT.NONE);
		lblDadesClient.setBounds(10, 12, 66, 15);
		lblDadesClient.setText("Dades Client");
		
		composite = new Composite(shell, SWT.BORDER);
		composite.setBounds(10, 533, 413, 64);
		
		textError = new Text(composite, SWT.BORDER);
		textError.setEditable(false);
		textError.setBounds(10, 21, 393, 21);
		
		compositeDadesAsseguranca = new Composite(shell, SWT.BORDER);
		compositeDadesAsseguranca.setBounds(10, 211, 413, 269);
		compositeDadesAsseguranca.setEnabled(false);	
    	compositeDadesAsseguranca.setBackground(SWTResourceManager.getColor(240, 240, 240));   	    			
		lblQuantitat = new Label(compositeDadesAsseguranca, SWT.NONE);
		lblQuantitat.setBounds(7, 10, 131, 15);
		lblQuantitat.setText("Quantitat a assegurar: ");
		
		textQuantitat = new Text(compositeDadesAsseguranca, SWT.BORDER);
		textQuantitat.setToolTipText("Introdueix la quantitat que vols assegurar");
		textQuantitat.setBounds(144, 7, 238, 21);
		
		lblTipus = new Label(compositeDadesAsseguranca, SWT.NONE);
		lblTipus.setBounds(7, 51, 55, 15);
		lblTipus.setText("Tipus: ");
		
		comboTipus = new Combo(compositeDadesAsseguranca, SWT.NONE);
		comboTipus.setToolTipText("Selecciona una opció");
		comboTipus.setBounds(68, 48, 314, 23);
		String[] opcionsTipus = {"Mort o invalidesa","Mort o invalidesa per accident ", "Mort o invalidesa o malaltia greu"};
		comboTipus.setItems(opcionsTipus);
		
		lblPreus = new Label(compositeDadesAsseguranca, SWT.CENTER);
		lblPreus.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblPreus.setBounds(165, 155, 55, 15);
		lblPreus.setText("PREUS");
		
		lblMenusal = new Label(compositeDadesAsseguranca, SWT.CENTER);
		lblMenusal.setBounds(21, 183, 55, 15);
		lblMenusal.setText("Mensual");
		
		lblSemestral = new Label(compositeDadesAsseguranca, SWT.CENTER);
		lblSemestral.setBounds(154, 183, 55, 15);
		lblSemestral.setText("Semestral");
		
		lblAnual = new Label(compositeDadesAsseguranca, SWT.CENTER);
		lblAnual.setBounds(288, 183, 55, 15);
		lblAnual.setText("Anual");
		
		textMensual = new Text(compositeDadesAsseguranca, SWT.BORDER);
		textMensual.setEditable(false);
		textMensual.setBounds(10, 204, 76, 21);
		
		textSemestral = new Text(compositeDadesAsseguranca, SWT.BORDER);
		textSemestral.setEditable(false);
		textSemestral.setBounds(144, 204, 76, 21);
		
		textAnual = new Text(compositeDadesAsseguranca, SWT.BORDER);
		textAnual.setEditable(false);
		textAnual.setBounds(277, 204, 76, 21);
		
		lblNewLabel = new Label(compositeDadesAsseguranca, SWT.NONE);
		lblNewLabel.setBounds(92, 207, 21, 15);
		lblNewLabel.setText("€");
		
		lblNewLabel_1 = new Label(compositeDadesAsseguranca, SWT.NONE);
		lblNewLabel_1.setBounds(226, 207, 12, 15);
		lblNewLabel_1.setText("€");
		
		lblNewLabel_2 = new Label(compositeDadesAsseguranca, SWT.NONE);
		lblNewLabel_2.setBounds(359, 207, 12, 15);
		lblNewLabel_2.setText("€");
		
		btnRestablir = new Button(compositeDadesAsseguranca, SWT.NONE);
		btnRestablir.setToolTipText("Esborra tot i torna a començar.");
		btnRestablir.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				
				textAnyNaixement.setText("");
				textQuantitat.setText("");
				comboTipus.setText("");
				textAnual.setText("");
				textSemestral.setText("");
				textMensual.setText("");
				comboFumador.setText("");
				comboProfessio.setText("");							
				compositeDadesClient.setEnabled(true);
				compositeDadesAsseguranca.setEnabled(false);												
			}
		});
		btnRestablir.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnRestablir.setBounds(55, 82, 131, 35);
		btnRestablir.setText("RESTABLIR");
		
		btnCalcular = new Button(compositeDadesAsseguranca, SWT.NONE);
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				
				textError.setText(""); 
							
				try {
	                double quantitat = Double.parseDouble(textQuantitat.getText());	                
	                if (quantitat<50000) {
	                	textQuantitat.selectAll();
	                	textQuantitat.setFocus();
	                	textError.setText("Error: Quantitat minima 50.000 euros");
	                    return;
	                }
	            } catch (NumberFormatException ex) {
	            	textQuantitat.selectAll();
	            	textQuantitat.setFocus();
	            	if (textQuantitat.getText()==null)
	            		textError.setText("Error: Cap valor intriduit");
	            	else
	                textError.setText("Error:  Valor incorrecte.");
	                return;
	            }
			  
				if (comboTipus.getSelectionIndex()==-1 ) {
					comboTipus.setFocus();
					textError.setText("Error: Obligatori");
				}
				
				// Factors, agafem per defecte el valor mes baix, per estalviar-nos codi.
				double factorEdat=0.9;
				double factorFumador=0.9;
				double factorProfessio=0.95;
				double factorTipus=1;
				double quantitat = Double.parseDouble(textQuantitat.getText());	 
				int anyNaixement = Integer.parseInt(textAnyNaixement.getText());
                int anyActual = LocalDate.now().getYear();
                int edat =  anyActual - anyNaixement;
                
				if (edat>55)
					factorEdat=1.1;
				else if (edat>=41 && edat <=55)
					factorEdat = 1;			
				
				if(comboFumador.getText().equals("Sí"))
					factorFumador=1.1;
				if(comboProfessio.getText().equals("Risc moderat"))
					factorProfessio = 1.05;
				else if(comboProfessio.getText().equals("Risc alt"))
					factorProfessio = 1.5;
				
				if(comboTipus.getText().equals("Mort o invalidesa per accident"))
					factorTipus=1.5;
				else if(comboTipus.getText().equals("Mort o invalidesa o malaltia greu"))
					factorTipus=1.1;
				
				double resultat = quantitat * factorEdat * factorFumador * factorProfessio/70-edat *10;
				double anual = Math.round(resultat*100.0)/100.0;
				double semestral = Math.round((resultat/2*1.05)*100.0)/100.0;
				double mensual = Math.round(resultat/12*1.10)*100.0/100.0;
			
				textAnual.setText(Double.toString(anual));
				textSemestral.setText(Double.toString(semestral));
				textMensual.setText(Double.toString(mensual));			
				btnRestablir.setEnabled(true);
				
				
			}
		});
		btnCalcular.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnCalcular.setBounds(226, 82, 131, 35);
		btnCalcular.setText("CALCULAR");
		
		lblNewLabel_3 = new Label(compositeDadesAsseguranca, SWT.NONE);
		lblNewLabel_3.setBounds(388, 10, 55, 15);
		lblNewLabel_3.setText("€");
		
		lblNewLabel_4 = new Label(compositeDadesAsseguranca, SWT.SEPARATOR | SWT.HORIZONTAL);
		lblNewLabel_4.setBounds(0, 134, 409, 15);
		lblNewLabel_4.setText("New Label");
		
		lblDadesAsseguranca = new Label(shell, SWT.NONE);
		lblDadesAsseguranca.setBounds(10, 190, 122, 15);
		lblDadesAsseguranca.setText("Dades Assegurança");
		
		lblErrors = new Label(shell, SWT.NONE);
		lblErrors.setBounds(10, 511, 154, 15);
		lblErrors.setText("Missatges d'error i/o alertes");
		shell.setTabList(new Control[]{lblDadesClient});
		
		
		
		
	}
}

		
		
		
		


