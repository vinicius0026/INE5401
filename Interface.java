import javax.swing.JOptionPane;
public class Interface {

	public static int getHex()
	{
		while(true){
			try{
				String valor = JOptionPane.showInputDialog(null, "Insira uma instrução assembly " +
						"em código hexadecimal para obter a instrução assembly original.", 
						"Disassembler de Instruções MIPS", JOptionPane.INFORMATION_MESSAGE);
				valor.toUpperCase();
				if(valor.length() == 8)
					return Integer.parseInt(valor,16);
				else
					JOptionPane.showMessageDialog(null,"A instrução deve conter 8 dígitos hexadecimais", 
						"Erro", JOptionPane.ERROR_MESSAGE);
			}
			catch(NumberFormatException a){
				JOptionPane.showMessageDialog(null,"O valor inserido não é válido em Hexadecimal", 
						"Erro", JOptionPane.ERROR_MESSAGE);
			}
			catch(NullPointerException a){
				System.exit(0);
			}
		}
	}
	public static void showMessage(String txt){
		JOptionPane.showMessageDialog(null,txt, "Código Assembly Original:", 
				JOptionPane.INFORMATION_MESSAGE);
	}
}
