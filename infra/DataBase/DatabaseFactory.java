package infra.DataBase;

public class DatabaseFactory {
    public static DatabaseSQL getDatabase(String nome){
        switch (nome) {
            case "postgresql":
                return new DatabasePostgreSQL();
            case "mysql":
                return new DatabaseMySQL();
            default:
                break;
        }
        return null;
    }
}
