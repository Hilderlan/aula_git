public class Operacao{
    private int op;
    private double valor;
    private Conta remetente;
    private Conta destinatario;

    public Operacao(int operacao, double valor, Conta remetente, Conta destinatario){
        this.op = operacao;
        this.valor = valor;
        this.remetente = remetente;
        this.destinatario = destinatario;
    }

    // Getters e Setters
    public int getOperacao(){
        return this.op;
    }
    public double getValor(){
        return this.valor;
    }
    public Conta getRemetente(){
        return this.remetente;
    }
    public Conta getDestinatario(){
        return this.destinatario;
    }

    public int setOperacao(int op){
        this.op = op;
    }
    public double setValor(double valor){
        this.valor = valor;
    }
    public Conta setRemetente(Conta remetente){
        this.remetente = remetente;
    }
    public Conta setDestinatario(Conta destinatario){
        this.destinatario = destinatario;
    }

    public void saque(){
        Conta c = this.getDestinatario();
        if(this.getValor() > 0 && this.getValor() < c.getSaldo()){
            c.setSaldo(c.getSaldo() - this.getValor());
        }
        else if(this.getValor() > c.getSaldo()){
            System.out.println("Saldo insuficiente!");
        }
        else if(this.getValor() <= 0){
            System.out.println("Valor 0 ou inválido!");
        }
    }

    public void deposito(){
        Conta c = this.getDestinatario();

        if(this.getValor() > 0){
            c.setSaldo(this.getValor() + c.getSaldo());
        }
        else{
            System.out.println("Valo nulo ou negativo");
        }
    }

    public void transferencia(){
        Conta c1 = this.getRemetente();
        Conta c2 = this.getDestinatario();

        if(this.getValor() > 0 && (c1.getSaldo() - this.getValor()) >= 0){
            c1.setSaldo(c1.getSaldo - this.getValor());
            c2.setSaldo(c2.getSaldo + this.getValor());
        }
        else{
            if((c1.getSaldo - this.getValor()) < 0){
                System.out.println("Saldo insuficiente");
            }
            else if(this.getValor() < 0){
                System.out.println("Valor negativo!");
            }
        }
    }
}