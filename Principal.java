
public class Principal {

	public static void main (String[]args){
	    System.setProperty("file.encoding", "UTF-8"); 
		while(true){
			
			int entrada;
			Instrucao inst = null;

			while(true){
				entrada = Interface.getHex();
				if(Instrucao.validaInstrucao(entrada))
					break;
				Interface.showMessage("Instrucao inválida, este hexadecimal não representa uma instrução assembly válida");
			}
			
			switch(Instrucao.defineTipo(entrada)){
			case 'I':
				inst = new InstrucaoI(entrada); 
				break;
			case 'R':
				inst = new InstrucaoR(entrada);
				break;
			case 'J':
				inst = new InstrucaoJ(entrada);
				break;
			}

			Interface.showMessage(inst.toString());
		}
	}

}
