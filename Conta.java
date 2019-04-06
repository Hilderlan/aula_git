public class Conta {

  private int num_agencia;
  private double saldo = 0;

  public void setSaldo(double valor) {
    this.saldo = valor;
  }

  public double getSaldo() {
    return this.saldo;
  }

  public int getAgencia() {
    return num_agencia;
  }

} // fim Conta
