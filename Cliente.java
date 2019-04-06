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
<<<<<<< HEAD

=======
 
>>>>>>> 0d4ee15eb8908b5399b07696bd59aeebefa483db
public ArrayList<Conta> getListaContas() {
        return this.listacontas;
    }


public void setNome(String nome) {
        this.nome=nome;
    }

public void setCpf(String cpf) {
        this.cpf=cpf;
    }
<<<<<<< HEAD

=======
 
>>>>>>> 0d4ee15eb8908b5399b07696bd59aeebefa483db
public void setListaContas(ArrayList<Conta> listacontas) {
        this.listacontas=listacontas;
    }

public void saque(double value, Conta conta){
Operacao opr = new Operacao(value,null,cont1);
opr.saque();
}

public void deposito(double value, Conta conta){
Operacao opr = new Operacao(value,null,cont1);
opr.deposito();
}

public void transferencia(double value, Conta remetente,Conta destinatario){
Operacao opr = new Operacao(value,remetente,destinatario);
opr.transferencia();
}

<<<<<<< HEAD
public void excluirConta(int num_agencia) {
  for conta : listacontas {
    if (conta.getAgencia() == num_agencia){
      listacontas.remove(conta);
    }
  }
}

=======
>>>>>>> 0d4ee15eb8908b5399b07696bd59aeebefa483db

}
