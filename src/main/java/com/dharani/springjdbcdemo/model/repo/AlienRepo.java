package com.dharani.springjdbcdemo.model.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import com.dharani.springjdbcdemo.model.Alien;
@Repository
public class AlienRepo {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Alien alien) {

        String sql = "insert into alientbl (id, name, tech) values (?,?,?)";
        int rows = template.update(sql, alien.getId(),alien.getName(),alien.getTech() );
        System.out.println(String.format("%d row(s) affected", rows));
    }

    public List<Alien> findall(){
        String sql = "select * from alientbl";

        
        RowMapper<Alien> mapper = (rs, rowNum) -> {
                Alien a  = new Alien();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setTech(rs.getString(3));
                return a;
        };

         List<Alien> aliens = template.query(sql, mapper);
         return aliens;

        }

}
