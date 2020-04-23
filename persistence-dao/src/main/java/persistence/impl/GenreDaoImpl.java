package persistence.impl;

import domain.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import persistence.dao.GenreDao;
import persistence.mapper.GenreMapper;

import java.util.List;

@Repository
public class GenreDaoImpl implements GenreDao {
    private static final GenreMapper genremaper = new GenreMapper();

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate parameterJdbcTemplate;

    @Value("${queryFindAllGenres}")
    private String queryFindAllGenres;

    @Value("${queryFindGenreByGenreId}")
    private String queryFindGenreByGenreId;

    @Override
    public List<Genre> findAllGenres() {
        List<Genre> genres = jdbcTemplate.query(queryFindAllGenres, genremaper);
        return genres;
    }

    @Override
    public Genre findGenreByGenreId(int genre_id) {
        SqlParameterSource source = new MapSqlParameterSource("genre_id", genre_id);
        Genre genre = parameterJdbcTemplate.queryForObject(queryFindGenreByGenreId,source,genremaper);
        return genre;
    }

    @Override
    public void save(Genre genre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Genre genre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Genre genre) {
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
