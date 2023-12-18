import java.sql.*;

public class JdbcExample {
  // java ; JDBC(an API)  -> database
  // JDBC (Java Database Connectivity)  allows java to talk to other databases
  // 1- The driver
  // link to database
  // username, password
  // write a statement

  public static void main(String[] args) { ////////////////////////START OF MAIN ///////////////////////////

    String dbUrl = "jdbc:mysql://localhost:3306/puppies"; // puppies data base created in MySQL
    String username = "root";
    String password = "Qwerasdfzxcv1234";

    Statement statement = null;
    ResultSet resultSet = null;
    Connection conn = null;


    try {
      // connect to the database
      conn = DriverManager.getConnection(dbUrl, username, password);
      System.out.println("Connecting to database successfully");
      // Execute the sql statements, you need a statement to execute from MySQL. .createStatement() is
      // from JDBC to help execute
      statement = conn.createStatement();

      //executeQuery returns a resultSet and needs the statement object. for reading u use .executeQuery.
      // when writing you use .execute
      resultSet = statement.executeQuery("SELECT * FROM table_of_puppies");
      statement.execute("INSERT INTO table_of_puppies VALUES(NULL, 'Jack', 44)");



      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

  } /////////////////////////////////////////END OF MAIN////////////////////////////////////////////////////

}
