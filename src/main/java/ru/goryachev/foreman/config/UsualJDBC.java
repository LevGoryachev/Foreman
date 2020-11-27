package ru.goryachev.foreman.config;

public class UsualJDBC {

  /*  String str = "12343213";
    int digits;
    int superline;

    public static void main(String[] args) {

        NotUsedStJDBC cl = new NotUsedStJDBC();
        System.out.println(cl.check());

    }

        private boolean check() {
            str = str.toLowerCase();
            str = str.replace(" ", "");
            int strLen = str.length();

            for(int i = 0; i < strLen / 2; i++)
                if(str.charAt(i) != str.charAt(strLen - i - 1))
                    return false;
            return true;
        }*/




    //classic JDBC connection is not used in this project, just for example
    //work with table of this project "construction"
    /*
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/foreman";
        String username = "postgres";
        String password = "postgres";

        System.out.println("classicJDBC is READY:");
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            final char dm = (char) 34;

            ResultSet resultSet = statement.executeQuery("SELECT * FROM construction");

            ResultSetMetaData rsmd = resultSet.getMetaData();
            int column_count = rsmd.getColumnCount();
            System.out.println("classicJDBC columns: " + column_count);

            while (resultSet.next()) {
                System.out.println("classicJDBC result TWO works: " + resultSet.getInt("id"));
                System.out.println("classicJDBC result TWO works: " + resultSet.getString("codenumber"));
                System.out.println("classicJDBC result TWO works: " + resultSet.getString("name"));
                System.out.println("classicJDBC result TWO works: " + resultSet.getString("description"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("classicJDBC is CLOSED");

    }

*/
}
