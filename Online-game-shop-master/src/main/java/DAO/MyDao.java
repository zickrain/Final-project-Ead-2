package DAO;

import Model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyDao {
    private static final String url = "jdbc:postgresql://localhost:5432/Games";
    private static final String user = "postgres";
    private static final String password = "Awesome_97";

    public static boolean getAdminAuthenticate(String adminUsername, String adminPassword) {
        ArrayList<Admin> admins = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, user, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM admins");
                while(resultSet.next()){

                    int id = resultSet.getInt(1);
                    String username = resultSet.getString(2);
                    String password = resultSet.getString(3);
                    Admin admin = new Admin();
                    admin.setAdminId(id);
                    admin.setAdminUsername(username);
                    admin.setAdminPassword(password);
                    admins.add(admin);
                }
            }
            for (Admin admin: admins){
                if (admin.getAdminUsername().equals(adminUsername)
                        && admin.getAdminPassword().equals(adminPassword)){
                    return true;
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return false;
    }

    public static boolean getUserAuthenticate(String username, String userPassword) {
        ArrayList<User> users = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, user, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                while(resultSet.next()){

                    int id = resultSet.getInt(1);
                    String user_username = resultSet.getString(2);
                    String password = resultSet.getString(3);
                    String user_email = resultSet.getString(4);
                    User user = new User();
                    user.setUser_id(id);
                    user.setUsername(user_username);
                    user.setUser_password(password);
                    user.setEmail(user_email);
                    users.add(user);
                }
            }
            for (User user: users){
                if (user.getEmail().equals(username)
                        && user.getUser_password().equals(userPassword)){
                    return true;
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return false;
    }

    public static boolean addNewUser(User newUser) {
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, user, password)){

                String sql = "INSERT INTO users (user_name, user_password, user_email) Values (?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, newUser.getUsername());
                    preparedStatement.setString(2, newUser.getUser_password());
                    preparedStatement.setString(3, newUser.getEmail());
                    preparedStatement.executeUpdate();

                    return true;
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return false;
    }


    public ArrayList<Game> select() {

        ArrayList<Game> games = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, user, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM games");
                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String author = resultSet.getString(3);
                    String img = resultSet.getString(4);
                    String description = resultSet.getString(5);
                    double price = resultSet.getInt(6);
                    int year = resultSet.getInt(7);
                    Game game = new Game();
                    game.setGameId(id);
                    game.setGameName(name);
                    game.setGameYear(year);
                    game.setGamePrice(price);
                    game.setGameAuthor(author);
                    game.setGameImg(img);
                    game.setGameDescription(description);
                    games.add(game);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return games;
    }

    public ArrayList<Cart> cartList(int user_id) {

        ArrayList<Cart> carts = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, user, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM carts WHERE user_id="+user_id);
                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    int amount = resultSet.getInt(2);
                    String gameName = resultSet.getString(3);
                    double price = resultSet.getDouble(4);
                    double total = resultSet.getDouble(5);
                    int userId = resultSet.getInt(6);
                    Cart cart = new Cart();
                    cart.setAmount(amount);
                    cart.setGame_name(gameName);
                    cart.setCart_id(id);
                    cart.setCost(price);
                    cart.setTotal_cost(total);
                    cart.setUser_id(userId);
                    carts.add(cart);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return carts;
    }

    public Game selectOne(int id) {

        Game game = null;
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, user, password)){

                String sql = "SELECT * FROM games WHERE game_id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int gameId = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        String author = resultSet.getString(3);
                        String img = resultSet.getString(4);
                        String description = resultSet.getString(5);
                        double price = resultSet.getInt(6);
                        int year = resultSet.getInt(7);
                        game = new Game();
                        game.setGamePrice(price);
                        game.setGameYear(year);
                        game.setGameName(name);
                        game.setGameId(gameId);
                        game.setGameAuthor(author);
                        game.setGameImg(img);
                        game.setGameDescription(description);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return game;
    }

    public boolean insert(Game game) {

        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, user, password)){

                String sql = "INSERT INTO games (game_name, game_author, game_img, game_description, game_price, game_year) Values (?, ?, ?, ?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, game.getGameName());
                    preparedStatement.setString(2, game.getGameAuthor());
                    preparedStatement.setString(3, game.getGameImg());
                    preparedStatement.setString(4, game.getGameDescription());
                    preparedStatement.setDouble(5, game.getGamePrice());
                    preparedStatement.setInt(6, game.getGameYear());
                    preparedStatement.executeUpdate();

                    return true;
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return false;
    }

    public boolean buyCart(Cart cart) {

        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, user, password)){

                String sql = "INSERT INTO carts (amount, game_name, cost, total_cost, user_id)" +
                        " Values (?, ?, ?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, cart.getAmount());
                    preparedStatement.setString(2, cart.getGame_name());
                    preparedStatement.setDouble(3, cart.getCost());
                    preparedStatement.setDouble(4, cart.getTotal_cost());
                    preparedStatement.setInt(5, cart.getUser_id());
                    preparedStatement.executeUpdate();

                    return true;
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return false;
    }

    public boolean update(Game game) {

        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, user, password)){

                String sql = "UPDATE games SET game_name = ?, game_author = ?, game_img = ?, game_description = ?," +
                        " game_price = ?, game_year = ? WHERE game_id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, game.getGameName());
                    preparedStatement.setString(2, game.getGameAuthor());
                    preparedStatement.setString(3, game.getGameImg());
                    preparedStatement.setString(4, game.getGameDescription());
                    preparedStatement.setDouble(5, game.getGamePrice());
                    preparedStatement.setInt(6, game.getGameYear());
                    preparedStatement.setInt(7, game.getGameId());
                    preparedStatement.executeUpdate();

                    return true;
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return false;
    }

    public boolean delete(int id) {

        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, user, password)){

                String sql = "DELETE FROM games WHERE game_id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    preparedStatement.executeUpdate();
                    return true;
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return false;
    }

    public User selectUser(String user_email) {
        User user1 = null;
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, user, password)){

                String sql = "SELECT * FROM users WHERE user_email=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, user_email);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){

                        int userId = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        String user_password = resultSet.getString(3);
                        String userEmail = resultSet.getString(4);
                        user1 = new User();
                        user1.setEmail(userEmail);
                        user1.setUser_password(user_password);
                        user1.setUsername(name);
                        user1.setUser_id(userId);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return user1;
    }
}
