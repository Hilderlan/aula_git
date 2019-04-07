import java.util.ArrayList;

public class ClienteAdmin {

    private ArrayList<Cliente> listaclientes;

    public ArrayList<Cliente> getListaClientes() {
    return this.listaclientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaclientes) {
        this.listaclientes=listaclientes;
    }

    public boolean isCliente(String cpf) {
        for (Cliente c : listaclientes) {
            if (cpf == c.getCpf()) {
                return false;
            }
        }
        return true;
    }

    public void cadastraCliente(Cliente cliente) {
        if (isCliente(cliente.getCpf()) == true) {
            listaclientes.add(cliente);
            System.out.println("\nCliente cadastrado.");
        }
        else {
            System.out.println("\nCliente já existente.");
        }
    }

} // fim Adm clientes
