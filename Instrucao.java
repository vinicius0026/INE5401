
public class Instrucao {
	//atributo
	private int instrucaoHexa;

	//constantes
	private static final char OPCODE_ERROR = '*';
	protected static final String ERROR="código não especificado";

	public Instrucao(int valorInstrucao) {
		setInstrucao(valorInstrucao);
	}
	
	public int getInstrucao() {
		return instrucaoHexa;
	}
	
	public void setInstrucao(int instrucaoHexa) {
		if(validaInstrucao(instrucaoHexa))
			this.instrucaoHexa = instrucaoHexa;
	}
	
	public static boolean validaInstrucao(int instrucao){
		String instrucaoString = Integer.toHexString(instrucao);
		if(instrucaoString.length()<8){
			int numZeros=8-instrucaoString.length();
			for(int i=0;i<numZeros;i++){
				instrucaoString="0"+instrucaoString;
			}
		}
		if( (instrucaoString.length() == 8) && (defineTipo(instrucao)!=OPCODE_ERROR) ){ 
			return true;
		}
		return false;
	}

	public static String instrucaoToBinaryString(int instrucao){
		String instr = Integer.toBinaryString(instrucao);
		int numzeros = 32-instr.length();
		for(int i = 0; i < numzeros; i++){
			instr="0"+instr;
		}
		return instr;
	}

	public static char defineTipo(int instrucao){
		String opcodeStr = instrucaoToBinaryString(instrucao).substring(0,6);
		int opcode = Integer.parseInt(opcodeStr,2);
		switch(opcode){
		case 0x0:
			return 'R';
		case 0x8:
		case 0xC:
		case 0x4:
		case 0x5:
		case 0x23:
		case 0xD:
		case 0xA:
		case 0x2B:
			return 'I';
		case 0x2:
			return 'J';
		default: return OPCODE_ERROR;	
		}
	}

	public char defineTipo(){
		return defineTipo(this.instrucaoHexa);
	}

	protected String registradorToString(int inicio, int fim){
		int registrador = Integer.parseInt(Instrucao.instrucaoToBinaryString(instrucaoHexa).substring(inicio,fim),2);
		if(registrador >= 8 && registrador <= 15){
			return "$t"+(registrador-8);
		}
		if(registrador >= 16 && registrador <= 23){
			return "$s"+(registrador-16);
		}
		switch(registrador){
		case 0: 	return "$zero";
		case 1:		return "$at";
		case 2:		return "$v0";
		case 3:		return "$v1";
		case 4:		return "$a0";
		case 5:		return "$a1";
		case 6:		return "$a2";
		case 7:		return "$a3";
		case 24:	return "$t8";
		case 25:	return "$t9";
		case 26:	return "$k0";
		case 27:	return "$k1";
		case 28:	return "$gp";
		case 29:	return "$sp";
		case 30:	return "$fp";
		case 31:	return "$ra";
		default: 	return ERROR;
		}
	}
}
