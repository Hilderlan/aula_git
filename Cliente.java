import java.util.ArrayList;


public class Cliente {
    private String nome;
    private String cpf;
    private ArrayList<Conta> listacontas;

    public Cliente(String nome, String cpf, ArrayList<Conta> listacontas){
    this.nome = nome;
    this.cpf = cpf;
    this.listacontas = listacontas;
    }

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
        this.cpf=cpf;
    }
    public void setListaContas(ArrayList<Conta> listacontas) {
        this.listacontas=listacontas;
    }

    public void sacar(double value, Conta conta){
        Operacao opr = new Operacao(value,null,conta);
        opr.saque();
    }

    public void depositar(double value, Conta conta){
        Operacao opr = new Operacao(value,null,conta);
        opr.deposito();
    }

    public void transferir(double value, Conta remetente,Conta destinatario){
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
    if (cpf.equals("00000000000") || cpf.equals("11111111111")) {
        return false;
    }
    return true;
    }

} // end CLiente
