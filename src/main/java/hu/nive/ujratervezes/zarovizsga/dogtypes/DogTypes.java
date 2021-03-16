package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {

    private final DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT name FROM dog_types WHERE country = ? ORDER BY name")
        ) {
            stmt.setString(1, country.toUpperCase());
            stmt.executeUpdate();
            return selectDogNamesByPreparedStatement(stmt);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot select!", sqle);
        }
    }

    public List<String> selectDogNamesByPreparedStatement(PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            List<String> names = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("name");
                names.add(name.toLowerCase());
            }
            return names;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot select!", sqle);
        }
    }
}
