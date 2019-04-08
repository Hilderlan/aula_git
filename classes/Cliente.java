import java.util.ArrayList;


public class Cliente{
private String nome;
private String cpf;
private ArrayList<Conta> listacontas;

public Cliente(String nome,String cpf,ArrayList<Conta> listacontas){
this.nome=nome;
this.cpf=cpf;
this.listacontas=listacontas;}

public String getNome() {
        return this.nome;
    }

public String getCpf() {
        return this.cpf;
    }

public ArrayList<Conta> getListaContas() {
        return this.listacontas;
    }


public void setNome(String nome) {
        this.nome=nome;
    }

public void setCpf(String cpf) {
	if (isCpf(cpf)) {
        this.cpf=cpf;
	}
    }

public void setListaContas(ArrayList<Conta> listacontas) {
        this.listacontas=listacontas;
    }

public void saque(double value, Conta conta){
Operacao opr = new Operacao(value,null,conta);
opr.saque();
}

public void deposito(double value, Conta conta){
Operacao opr = new Operacao(value,null,conta);
opr.deposito();
}

public void transferencia(double value, Conta remetente,Conta destinatario){
Operacao opr = new Operacao(value,remetente,destinatario);
opr.transferencia();
}

public void addConta(Conta conta){
this.getListaContas().add(conta);
}

public void excluirConta(int num_agencia) {
  for (Conta c : listacontas) {
    if (c.getAgencia() == num_agencia){
      listacontas.remove(c);
    }
  }
}

public static boolean isCpf(String cpf) {
  if (cpf.length() != 11){
    return false;
  }
  
  
  try {
	Long.parseLong(cpf);
} catch (NumberFormatException e) {
	// TODO Auto-generated catch block
	//e.printStackTrace();
	return false;
}
  
  if (cpf.equals("00000000000") || cpf.equals("11111111111")) {
    return false;
  }
  
  int[]digitos = new int[11];
  
  for (int i = 0; i < 11; i++) {
	  digitos[i] = Integer.parseInt(cpf.substring(i, i+1));
  }
  
  int soma = 0;
 
  for (int i = 0; i <= 8; i++) {
	soma += digitos[i] * (10-i);
  }
  
  int resto = soma%11;
  int digitoVerificador = 11-resto;
  
  if (digitoVerificador > 9) {
	  digitoVerificador = 0;
  }
  
  if (digitos[9] != digitoVerificador) {
	  return false;
  }
  
  soma = 0;
  
  for (int i = 0; i <= 9; i++) {
		soma += digitos[i] * (11-i);
	  }
	  
  resto = soma%11;
  digitoVerificador = 11-resto;
  
  if (digitoVerificador > 9) {
	  digitoVerificador = 0;
  }
  
  if (digitos[10] != digitoVerificador) {
	  return false;
  }
  
  return true;
}

} // end CLiente
