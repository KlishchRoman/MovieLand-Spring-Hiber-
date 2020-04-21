package persistence_dao.daoImpl;

import domain.Genre;
import domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import persistence_dao.dao.MovieDao;
import persistence_dao.mapper.MovieMapper;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class MovieDaoImpl implements MovieDao {

    private static final MovieMapper mapper = new MovieMapper();
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate parameterJdbcTemplate;

    @Value("${findAllMovies}")
    private String findAllMovies;
    @Value("${find3RandomMovies}")
    private String find3RandomMovies;
    @Value("${findMoviesByGenre}")
    private String findMoviesByGenre;
    @Value("${findMovieByMovieId}")
    private String findMovieByMovieId;

    @Override
    public List<Movie> findAllMovies() {
       List<Movie> movies= jdbcTemplate.query(findAllMovies, (ResultSet rs, int rowNum)->{
           Movie movieFromBD = new Movie();
           movieFromBD.setMovieId(rs.getInt("movie_id"));
           movieFromBD.setNameRussian(rs.getString("name_russian"));
           movieFromBD.setNameNative(rs.getString("name_native"));
           movieFromBD.setYearOfRelease(rs.getInt("year_of_release"));
           movieFromBD.setRating(rs.getFloat("rating"));
           movieFromBD.setPrice(rs.getBigDecimal("price"));
           movieFromBD.setPicturePath(rs.getString("picture_path"));
         return movieFromBD;
       });
        return movies;
    }

    @Override
    public List<Movie> find3RandomMovies() {
        return jdbcTemplate.query(find3RandomMovies,mapper);
    }

    @Override
    public List<Movie> findMoviesByGenre(Genre genre) {
        SqlParameterSource source = new MapSqlParameterSource("genre_id", genre.getGenreId());
        return parameterJdbcTemplate.query(findMoviesByGenre,source,mapper);
    }

    @Override
    public Movie findMovieByMovieId(int movie_id) {
        SqlParameterSource source = new MapSqlParameterSource("movie_id", movie_id);
        return parameterJdbcTemplate.queryForObject(findMovieByMovieId,source,mapper);
    }

    @Override
    public void save(Movie movie) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Movie movie) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Movie movie) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setParameterJdbcTemplate(NamedParameterJdbcTemplate parameterJdbcTemplate) {
        this.parameterJdbcTemplate = parameterJdbcTemplate;
    }
}
