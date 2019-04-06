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

public void adicionarConta(Conta conta){
this.getListaContas().add(conta);
}

public void operacao(){


}

}
