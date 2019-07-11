package daos;

import com.sun.jdi.connect.Connector;
import models.OrigText;
import utility.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TextManager extends Dao<OrigText> {
    private Connection conn = ConnectionFactory.getConnection();

    public TextManager() {
        this.dtos = new ArrayList<>();
    }

    public OrigText findById(int id) {
        try {
                Statement stmt = this.conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM origtexts WHERE id=" + id);
                if (rs.next()) return extractTextFromResultSet(rs);
        } catch (SQLException ex) { ex.printStackTrace(); }
        return null;
    }

    private OrigText extractTextFromResultSet(ResultSet rs) throws SQLException {
        return new OrigText(rs.getInt("id"),
                rs.getString("name"),
                rs.getString("language"),
                rs.getString("author"),
                rs.getShort("year"));
    }

    public List<OrigText> findAll(){
        try {
                Statement stmt = this.conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM origtexts");
                while (rs.next()) this.dtos.add(extractTextFromResultSet(rs));
                return this.dtos;
        } catch (SQLException ex) { ex.printStackTrace(); }
        return null;
    }

    public Boolean update(OrigText dto) {
        try {
            PreparedStatement ps =
                    this.conn.prepareStatement("UPDATE origtexts SET name=?, language=?, author=?, year=? WHERE id=?");
            ps.setInt(5, dto.getId());
            if (prepareStatement(dto, ps)) return true;
        } catch (SQLException ex) { ex.printStackTrace(); }
        return false;
    }

    public Boolean create(OrigText dto) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO origtexts VALUES (NULL, ?, ?, ?,?)");
            if (prepareStatement(dto, ps)) return true;
        } catch (SQLException ex) { ex.printStackTrace(); }
        return false;
    }

    public Boolean delete(int id) {
        try {
            Statement stmt = this.conn.createStatement();
            int i = stmt.executeUpdate("DELETE FROM origtexts WHERE id=" + id);
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private boolean prepareStatement(OrigText dto, PreparedStatement ps) throws SQLException {
        ps.setString(1, dto.getName());
        ps.setString(2, dto.getLanguage());
        ps.setString(3, dto.getAuthor());
        ps.setShort(4, dto.getYear());
        int i = ps.executeUpdate();
        return i == 1;
    }
}