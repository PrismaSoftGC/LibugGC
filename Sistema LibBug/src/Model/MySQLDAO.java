package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLDAO {

        public static final String DRIVER = "com.mysql.jdbc.Driver";
        public static final String DBURL = "jdbc:mysql:///biblioteca";
        private static Connection con;
// metodo para criar a conexao com MySQL

        public static Connection getConnection() {
            if (con == null) {
                try {
                    Class.forName(DRIVER).newInstance();
                    con = DriverManager.getConnection(DBURL, "root","");
                } catch (Exception e) {
                    System.err.println("Exception: " + e.getMessage());
                }
            }
            return con;
        }

        public static ResultSet getResultSet(String query, Object... parametros) {
            PreparedStatement psmt;
            ResultSet rs = null;
            try {
                psmt = con.prepareStatement(query);
                for (int i = 0; i < parametros.length; i++) {
                    psmt.setObject(i + 1, parametros[i]);
                }
                rs = psmt.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return rs;
        }

        public static long executeQuery(String query, Object... parametros) {
            long update = 0;
            PreparedStatement psmt;
            try {
                psmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
                for (int i = 0; i < parametros.length; i++) {
                    psmt.setObject(i + 1, parametros[i]);
                }

                psmt.execute();
                ResultSet rs = psmt.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    update = rs.getLong(1);
                }
                psmt.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return update;
        }

        public static void terminar() {
            try {
                (MySQLDAO.getConnection()).close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
