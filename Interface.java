import javax.swing.JOptionPane;
public class Interface {

	public static int getHex()
	{
		while(true){
			try{
				String valor = JOptionPane.showInputDialog(null, "Insira uma instru��o assembly " +
						"em c�digo hexadecimal para obter a instru��o assembly original.", 
						"Disassembler de Instru��es MIPS", JOptionPane.INFORMATION_MESSAGE);
				valor.toUpperCase();
				if(valor.length() == 8)
					return Integer.parseInt(valor,16);
				else
					JOptionPane.showMessageDialog(null,"A instru��o deve conter 8 d�gitos hexadecimais", 
						"Erro", JOptionPane.ERROR_MESSAGE);
			}
			catch(NumberFormatException a){
				JOptionPane.showMessageDialog(null,"O valor inserido n�o � v�lido em Hexadecimal", 
						"Erro", JOptionPane.ERROR_MESSAGE);
			}
			catch(NullPointerException a){
				System.exit(0);
			}
		}
	}
	public static void showMessage(String txt){
		JOptionPane.showMessageDialog(null,txt, "C�digo Assembly Original:", 
				JOptionPane.INFORMATION_MESSAGE);
	}
}
