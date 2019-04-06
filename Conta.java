public class Conta {

  private int num_agencia;
  private double saldo = 0;

  private void setSaldo(double valor) {
    this.saldo = valor;
  }

  private double getSaldo() {
    return this.saldo;
  }

  private int getAgencia() {
    return num_agencia;
  }

} // fim Conta
