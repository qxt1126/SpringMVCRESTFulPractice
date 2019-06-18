package springrestful_example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import springrestful_example.model.Director;

@Repository
public class DirectorDaoImpl implements DirectorDao {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate)
			throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List<Director> listAllDirector() {
		List<Director> list = new ArrayList<Director>();

		String sql = "SELECT Directors_Id_PK, First_Name, Last_Name FROM dbo.CA_Directors";

		list = namedParameterJdbcTemplate.query(sql,
				getSqlParameterByModel(null), new DirectorMapper());

		return list;
	}

	private SqlParameterSource getSqlParameterByModel(Director director) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (director != null) {
			parameterSource.addValue("Directors_Id_PK", director.getDirectors_Id_PK());
			parameterSource.addValue("First_Name", director.getFirst_Name());
			parameterSource.addValue("Last_Name", director.getLast_Name());
		}
		return parameterSource;
	}

	private static final class DirectorMapper implements RowMapper<Director> {

		public Director mapRow(ResultSet rs, int rowNum) throws SQLException {
			Director director = new Director();
			director.setDirectors_Id_PK(rs.getInt("Directors_Id_PK"));
			director.setFirst_Name(rs.getString("First_Name"));
			director.setLast_Name(rs.getString("Last_Name"));

			return director;
		}

	}

	public void addDirector(Director director) {
		String sql = "INSERT INTO dbo.CA_Directors(First_Name, Last_Name) VALUES(:First_Name, :Last_Name)";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(director));
	}

	public void updateDirector(Director director) {
		String sql = "UPDATE dbo.CA_Directors SET First_Name=:First_Name, Last_Name=:Last_Name WHERE Directors_Id_PK =:Directors_Id_PK";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(director));
	}

	public void delete(Director director) {
		String sql = "DELETE FROM dbo.CA_Directors WHERE Directors_Id_PK =:Directors_Id_PK";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(director));
	}

	public Director findDirectorById(Director director) {
		String sql = "SELECT * FROM dbo.CA_Directors WHERE Directors_Id_PK =:Directors_Id_PK";

		return namedParameterJdbcTemplate.queryForObject(sql,
				getSqlParameterByModel(director), new DirectorMapper());
	}

}
