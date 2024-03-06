package uz.pdp.g33springboot.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uz.pdp.g33springboot.domain.Article;

import java.util.List;

@Repository
public class ArticleDao {

    private final JdbcTemplate jdbcTemplate;

    public ArticleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Article article) {
        jdbcTemplate.update("insert into article(title, content, author, date) values (?, ? , ? , ?)",
                article.getTitle(),
                article.getContent(),
                article.getAuthor(),
                article.getDate()
        );
    }

    public List<Article> getAll() {
        return jdbcTemplate.query("select a.id, a.title, a.content, a.author, a.date  from article a",
                new BeanPropertyRowMapper<>(Article.class));
//        return jdbcTemplate.queryForList("select a.id, a.title, a.content, a.author, a.date  from article a", Article.class);
    }
}
