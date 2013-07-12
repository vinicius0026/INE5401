import javax.swing.JOptionPane;


public class InstrucaoJ extends Instrucao {

	public InstrucaoJ(int valorInstrucao) {
		super(valorInstrucao);
		
	}
	private String opcodeToString(){
		return "j";
	}
	private String addressToString(){
		int address = Integer.parseInt(Instrucao.instrucaoToBinaryString(this.getInstrucao()).substring(6),2);
		return "0x" + Integer.toHexString(address).toUpperCase()	;
	}
	public String toString(){
		return this.opcodeToString()+" "+this.addressToString();
	}
}
