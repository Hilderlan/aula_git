import java.util.ArrayList;

public class Administradora {
    private ArrayList<Cliente> listaClientes = new ArrayList<>();

    public ArrayList<Cliente> getListaClientes() {
        return this.listaClientes;
    }

    public void cadastrarCliente(Cliente cliente) {
        this.getListaClientes().add(cliente);
    }

    public void removerCliente(Cliente cliente){
        for(Conta conta : cliente.getListaContas()){
            cliente.getListaContas().remove(conta); // Removendo todas as contas associadas ao cliente a ser removido
        }

        this.getListaClientes().remove(cliente);
    }

    public Cliente verificarCPF(String cpf){
        for(Cliente cliente : this.getListaClientes()){
            if(cliente.getCpf() == cpf){
                return cliente;
            }
        }
        return null;
    }

    public Conta verificarConta(int nro_agencia){
        for(Cliente cliente : this.getListaClientes()){
            for(Conta conta : cliente.getListaContas()){
                if(conta.getAgencia() == nro_agencia){
                    return conta;
                }
            }
        }
        return null;
    }
}