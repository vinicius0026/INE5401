
public class InstrucaoR extends Instrucao {

	public InstrucaoR(int valorInstrucao) {
		super(valorInstrucao);
		
	}
	private String funcaoToString(){
		int funcao = Integer.parseInt(Instrucao.instrucaoToBinaryString(this.getInstrucao()).substring(26),2);
		switch(funcao){
		case 0x20: 	return "Add";
		case 0x24: 	return "and";
		case 0x25: 	return "or";
		case 0x27: 	return "nor";
		case 0x0: 	return "sll";
		case 0x2A: 	return "slt";
		case 0x02: 	return "srl";
		case 0x22: 	return "sub";
		default :  	return ERROR;
		}
	}
	private String fonte1ToString(){
		return registradorToString(6,11);
	}
	private String fonte2ToString(){
		return registradorToString(11,16);
	}
	private String destinoToString(){
		return registradorToString(16,21);
	}
	private String shamtToString(){
		int shamt = Integer.parseInt(Integer.toBinaryString(this.getInstrucao()).substring(21,26),2);
		return ""+shamt;
	}
	public String toString(){
		if(funcaoToString().equals(ERROR))
			return "Código não especificado, certifique-se de que você inseriu um hexadecimal que"+
				"\n"+"represente uma instrução em assembly";
		return this.funcaoToString()+" "+this.destinoToString() + ", "+this.fonte1ToString()+", "+this.fonte2ToString();
	}
}
