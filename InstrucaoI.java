
public class InstrucaoI extends Instrucao {

	
	public InstrucaoI(int valorInstrucao) {
		super(valorInstrucao);
		
	}
	private String opcodeToString(){
		String instr=Integer.toBinaryString(this.getInstrucao());
		int numzeros=32-instr.length();
		for(int i=0;i<numzeros;i++){
			instr="0"+instr;
		}
		int opcode = Integer.parseInt(instr.substring(0,6),2);
		switch(opcode){
		
		case 0x8:	return"addi";
		case 0xC:	return"andi";
		case 0x4:	return"beq";
		case 0x5:	return"bne";
		case 0x23:	return"lw";
		case 0xD: 	return "ori";
		case 0xA: 	return "slti";
		case 0x2B:	return "sw";
		default: 	return ERROR;
					}
	}
	
	private String fonteToString(){
		return registradorToString(6,11);
	}
	private String destinoToString(){
		return registradorToString(11,16);
	}
	private String imediatoToString(){
		int imediato = Integer.parseInt(Integer.toBinaryString(this.getInstrucao()).substring(16),2);
		return ""+imediato;
	}
	public String toString(){
		return this.opcodeToString()+" " + this.destinoToString() + ", " + 
				this.fonteToString()+", " + this.imediatoToString();
	}
}
