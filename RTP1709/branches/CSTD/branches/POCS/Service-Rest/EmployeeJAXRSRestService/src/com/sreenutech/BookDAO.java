package com.sreenutech;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Christophe Coenraets
 */
public class BookDAO extends BaseDAO{

    public List<Book> findAll() {
        List<Book> list = new ArrayList<Book>();
        Connection c = null;
    	String sql = "SELECT * FROM books_details1";
        
        try {
            c = getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                list.add(processSummaryRow(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			closeConnection(c);
		}
        return list;
    }
    
    protected Book processSummaryRow(ResultSet rs) throws SQLException {
    	Book book = new Book();
    	book.setIsbn(rs.getString("isbn"));
    	book.setName(rs.getString("name"));
    	book.setAuthor(rs.getString("author"));
    	book.setPages(rs.getString("series"));
    	book.setInstock(rs.getString("instock"));
    	book.setPrice(rs.getString("price"));
    	book.setPages(rs.getString("pages"));
    	book.setLanguage(rs.getString("language"));
    	book.setPublication_year(rs.getString("publication_year"));
    	book.setWeight(rs.getString("weight"));
    	book.setHeight(rs.getString("height"));
    	book.setWidth(rs.getString("width"));
    	book.setImg_url(rs.getString("img_url"));
    	
    	return book;
    }
}
