package org.intern.project.assessment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {


    public Database() throws Exception {

        System.out.println("help");

        try {
//            public void function() throws Exception {
                Database obj = new Database();
                obj.connectToDatabase();
//            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    void connectToDatabase() throws Exception {
        System.out.println("Loading Driver");
        Class.forName("org.h2.Driver");
        Connection conn = null;
        Statement st = null;
        try {
            System.out.println("Trying to connect to Database");
            conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            System.out.println("Connected to Database");
            st = conn.createStatement();

            st.executeUpdate("Create table app(id int NOT NULL, name varchar(10), author varchar(10)," +
                    "publisher varchar(10), price int, primary key(id) );");
            //ResultSet s = st.executeQuery("SELECT count(SELECT * FROM INFORMATION_SCHEMA.TABLES);");
            System.out.println("Created Table");

//            st.executeUpdate("insert into app values (2, 'C', 'Rob' , 'Hill', 400)");
//            System.out.println("Insert Executed");

        }catch(SQLException e){
            System.out.println(e);
        }
        finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Connection Closed");
                }
            } catch (SQLException e) {
                if (st != null) {
                    st.close();
                    System.out.println("Statement Closed");
                }
            }
        }
    }

}
