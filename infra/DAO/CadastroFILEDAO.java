package infra.DAO;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import infra.DataBase.Database;
import business.model.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael Vargas Mesquita
 */
public final class CadastroFILEDAO implements Database {

    private FileInputStream fileStream;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private boolean moreRecords = true;
    private boolean continua = true;

    private static final LinkedList<Usuario> injector_dados = new LinkedList<Usuario>();
    

    private final String patch = "src\\usuarios.wtf";

    public CadastroFILEDAO() {
        /* Usuarios */
        setupLer();
        if (continua) {
            readRecords();
        }
        cleanupLer();
    }

    /* Leitura dos arquivos individualmente e bem fundada */
    public void setupLer() {
        try {
            fileStream = new FileInputStream(patch);
            input = new ObjectInputStream(fileStream);

        } catch (EOFException eof) {
            continua = false;
            System.err.println("Falha:::: \n" + eof.toString());
        } catch (IOException e) {
            System.err.println("Falha na Abertura do Arquivo para Leitura\n" + e.toString());
            System.exit(1);
        }
    }

    public void readRecords() {
        //Carrega todo o conteúdo do arquivo na Coleção
        try {
            while (moreRecords) {
                injector_dados.add((Usuario) (input.readObject()));

            }
        } catch (EOFException eof) {
            moreRecords = false;
        } catch (IOException e) {
            System.err.println("Erro durante leitura do arquivo\n" + e.toString());
            System.exit(1);
        } catch (ClassNotFoundException c) {
            System.err.println("Erro durante leitura do arquivo - Objeto Inválido\n" + c.toString());
        }

    }

    @SuppressWarnings("empty-statement")
    public void cleanupLer() {
        try {;
            input.close();

        } catch (IOException e) {
            System.err.println("Falha no Fechamento do Arquivo - Durante Gravação!!\n" + e.toString());
            System.exit(1);
        }
    }

    public void setupGravar() {
        //Abre arquivo para gravar
        try {
            output = new ObjectOutputStream(new FileOutputStream(patch, false));
        } catch (IOException e) {
            System.err.println("Falha na Abertura do Arquivo para Gravação\n" + e.toString());
            System.exit(1);
        }
    }

    public void addRecords() {
        //Carrega toda a coleção no arquivo
        try {
            for (Usuario a : injector_dados) {
                output.writeObject(a);
            }
        } catch (IOException e) {
            System.err.println("Erro durante gravação no arquivo\n" + e.toString());
            System.exit(1);
        }
    }

    public void cleanupGravar() {
        //Fechar o arquivo, após todos os objetos terem sido gravados
        try {
            output.flush();
            output.close();

        } catch (IOException e) {
            System.err.println("Falha no Fechamento do Arquivo - Durante Gravação!!\n" + e.toString());
            System.exit(1);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean inserir(Usuario dado) {
        if (dado != null) {
            if (buscar(dado,"2017") == null) {
                injector_dados.add(dado);
                setupGravar();
                addRecords();
                cleanupGravar();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean update(Usuario dado) {
        for (Usuario a : injector_dados) {
            if (a.getLogin().equalsIgnoreCase(dado.getLogin())) {
                
                a.setSenha(dado.getSenha());
                a.setNome(dado.getNome());
                setupGravar();
                addRecords();
                cleanupGravar();
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean updateCC(Usuario dado) {
        for (Usuario a : injector_dados) {
            if (a.getLogin().equalsIgnoreCase(dado.getLogin())) {
                
                a.setSaldoCC(dado.getSaldoCC());
                setupGravar();
                addRecords();
                cleanupGravar();
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean updateCP(Usuario dado) {
        for (Usuario a : injector_dados) {
            if (a.getLogin().equalsIgnoreCase(dado.getLogin())) {
                
                a.setSaldoCP(dado.getSaldoCP());
                setupGravar();
                addRecords();
                cleanupGravar();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remover(Usuario dado) {
        if (dado != null) {
            for (Usuario a : injector_dados) {
                if (a.getLogin().equalsIgnoreCase(dado.getLogin())) {
                   
                    injector_dados.remove(a);
                    setupGravar();
                    addRecords();
                    cleanupGravar();
                    return true;
                }

            }
        }
        return false;
    }

    @Override
    public Usuario buscar(Usuario dado, String data) {
        for (Usuario a : injector_dados) {
            if (a.getLogin().equalsIgnoreCase(dado.getLogin())&&data.equalsIgnoreCase("2017")) {
                return a;
            }

        }
        return null;
    }
    
    public  List<Usuario> listar() {
        List<Usuario> retorno = new ArrayList<>();
        for (Usuario a : injector_dados) {
            retorno.add(a);

        }
        return retorno;
    }

}
